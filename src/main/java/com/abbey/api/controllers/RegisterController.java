package com.abbey.api.controllers;

import com.abbey.api.initializers.loaders.DataLoader;
import com.abbey.api.models.Feedback;
import com.abbey.api.models.authentication.RegistrationData;
import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.*;
import com.abbey.api.repositories.authentication.UserRepository;
import com.abbey.api.repositories.game.GameRepository;
import com.abbey.api.repositories.game.PlayerRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private DataLoader dataLoader;

    private Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "")
    public @ResponseBody
    Feedback register(@RequestBody RegistrationData registrationData) {
        log.info("TRYING TO REGISTER");

        Feedback feedback = new Feedback("Invalid confirmation of your password.", false);

        if (registrationData.getPassword().equals(registrationData.getConfirmPassword())) {

            User existingUser = userRepository.getByUsername(registrationData.getUsername());

            if (existingUser == null) {

                log.info("CREATING NEW USER");

                // ABBEY > DEPARTMENTS

                Department fieldsDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("Fields")
                        .build();

                Department facilitiesDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("Facilities")
                        .build();

                Department breweryDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("Brewery")
                        .build();

                Map<String, Department> departments = new HashMap<>();

                departments.put("fields", fieldsDepartment);
                departments.put("facilities", facilitiesDepartment);
                departments.put("brewery", breweryDepartment);

                // ABBEY > SCHEDULE

                HashMap<String, Chore> chores = new HashMap<>();

                Chore wakeUp = Chore.builder()
                        .name("Wake-up")
                        .time(4f)
                        .build();

                Chore breakfast = Chore.builder()
                        .name("Breakfast")
                        .time(5f)
                        .build();

                Chore prayOne = Chore.builder()
                        .name("Pray")
                        .time(7f)
                        .build();

                Chore workOne = Chore.builder()
                        .name("Work")
                        .time(7.35f)
                        .build();

                Chore prayTwo = Chore.builder()
                        .name("Pray")
                        .time(11f)
                        .build();

                Chore lunch = Chore.builder()
                        .name("Lunch")
                        .time(12f)
                        .build();

                Chore prayThree = Chore.builder()
                        .name("Pray")
                        .time(13.45f)
                        .build();

                Chore workTwo = Chore.builder()
                        .name("Work")
                        .time(14f)
                        .build();

                Chore diner = Chore.builder()
                        .name("Diner")
                        .time(18f)
                        .build();

                Chore prayFour = Chore.builder()
                        .name("Pray")
                        .time(18.30f)
                        .build();

                Chore sleep = Chore.builder()
                        .name("Sleep")
                        .time(20f)
                        .build();

                chores.put(ObjectId.get().toHexString(), wakeUp);
                chores.put(ObjectId.get().toHexString(), breakfast);
                chores.put(ObjectId.get().toHexString(), prayOne);
                chores.put(ObjectId.get().toHexString(), workOne);
                chores.put(ObjectId.get().toHexString(), prayTwo);
                chores.put(ObjectId.get().toHexString(), lunch);
                chores.put(ObjectId.get().toHexString(), prayThree);
                chores.put(ObjectId.get().toHexString(), workTwo);
                chores.put(ObjectId.get().toHexString(), diner);
                chores.put(ObjectId.get().toHexString(), prayFour);
                chores.put(ObjectId.get().toHexString(), sleep);

                Schedule schedule = Schedule.builder()
                        .chores(chores)
                        .build();

                // ABBEY

                Abbey abbey = Abbey.builder()
                        ._id(ObjectId.get().toHexString())
                        .totalAmtOfMonks(10)
                        .departments(departments)
                        .schedule(schedule)
                        .build();

                // BREWERY

                Brewery brewery = Brewery.builder()
                        ._id(ObjectId.get().toHexString())
                        .build();

                // STORY

                Story story = dataLoader.loadStory();

                // WORKBENCH

                Workbench workbench = Workbench.builder()
                        ._id(ObjectId.get().toHexString())
                        .build();

                // GAME

                Game newGame = Game.builder()
                        ._id(ObjectId.get().toHexString())
                        .abbey(abbey)
                        .brewery(brewery)
                        .story(story)
                        .workbench(workbench)
                        .build();

                // PLAYER

                Player newPlayer = Player.builder()
                        ._id(ObjectId.get().toHexString())
                        .reputation(0)
                        .goldenCoins(10d)
                        .build();

                // USER

                User newUser = User.builder()
                        ._id(ObjectId.get().toHexString())
                        .username(registrationData.getUsername())
                        .password(registrationData.getPassword())
                        .registrationDate(new Date())
                        .gameId(newGame.get_id())
                        .playerId(newPlayer.get_id())
                        .build();

                gameRepository.save(newGame);
                playerRepository.save(newPlayer);
                userRepository.save(newUser);

                feedback.setSuccessful(true);
                feedback.setMessage("Successfully created a new account.");

                log.info("SUCCESSFUL REGISTRATION");

            } else {

                log.error("REGISTRATION FAILED");

                feedback.setMessage("Username in use.");

            }

        }

        return feedback;

    }
}
