package com.abbey.api.controllers;

import com.abbey.api.initializers.loaders.DataLoader;
import com.abbey.api.models.Feedback;
import com.abbey.api.models.authentication.ERole;
import com.abbey.api.models.authentication.RegistrationData;
import com.abbey.api.models.authentication.Role;
import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.*;
import com.abbey.api.repositories.authentication.RoleRepository;
import com.abbey.api.repositories.authentication.UserRepository;
import com.abbey.api.repositories.game.FacilityRepository;
import com.abbey.api.repositories.game.GameRepository;
import com.abbey.api.repositories.game.PlayerRepository;
import com.abbey.api.repositories.game.ProcessorRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
@RequestMapping(value = "/api/register")
public class RegisterController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private ProcessorRepository processorRepository;

    @Autowired
    private DataLoader dataLoader;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "")
    public @ResponseBody
    ResponseEntity register(@RequestBody RegistrationData registrationData) {

        this.logger.info("USER REGISTRATION: {}", registrationData.getUsername());

        Feedback feedback = new Feedback("Invalid confirmation of your password.", false);

        try {

            User existingUser = userRepository.getByUsername(registrationData.getUsername());

            if (existingUser == null) {

                this.logger.info("USER REGISTRATION: {}: CREATING NEW USER", registrationData.getUsername());

                // ABBEY > DEPARTMENTS

                Department fieldsDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("fields")
                        .build();

                Department facilitiesDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("facilities")
                        .build();

                Department processorDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("processors")
                        .build();

                Department breweryDepartment = Department.builder()
                        ._id(ObjectId.get().toHexString())
                        .monks(0)
                        .name("brewery")
                        .build();

                Map<String, Department> departments = new HashMap<>();

                departments.put("fields", fieldsDepartment);
                departments.put("facilities", facilitiesDepartment);
                departments.put("processors", processorDepartment);
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
                        ._id(ObjectId.get().toHexString())
                        .chores(chores)
                        .build();

                // ABBEY

                Abbey abbey = Abbey.builder()
                        ._id(ObjectId.get().toHexString())
                        .totalAmtOfMonks(10)
                        .departments(departments)
                        .schedule(schedule)
                        .build();

                // FACILITIES

                List<Facility> facilities = this.facilityRepository.findAll();

                // PROCESSORS

                List<Processor> processors = this.processorRepository.findAll();

                // BREWERY

                Brewery brewery = Brewery.builder()
                        ._id(ObjectId.get().toHexString())
                        .breweryProcessors(new HashMap<>())
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
                        .facilities(facilities)
                        .processors(processors)
                        .brewery(brewery)
                        .story(story)
                        .workbench(workbench)
                        .fields(new ArrayList<>())
                        .stock(new HashMap<>())
                        .build();

                // PLAYER

                Player newPlayer = Player.builder()
                        ._id(ObjectId.get().toHexString())
                        .reputation(0)
                        .goldenCoins(10d)
                        .build();

                // USER

                User newUser = User.builder()
                        .id(ObjectId.get().toHexString())
                        .username(registrationData.getUsername())
                        .password(encoder.encode(registrationData.getPassword()))
                        .registrationDate(new Date())
                        .gameId(newGame.get_id())
                        .playerId(newPlayer.get_id())
                        .build();

                Set<Role> strRoles = registrationData.getRoles();
                Set<Role> roles = new HashSet<>();

                if (strRoles == null) {
                    try {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER);
                        roles.add(userRole);
                    }
                    catch (RuntimeException exception){
                        throw new RuntimeException("Error: Role is not found.");
                    }
                } else {
                    strRoles.forEach(role -> {
                        if (role.getName().name().equals("admin")) {
                            try {
                                Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN);
                                roles.add(userRole);
                            } catch (RuntimeException exception) {
                                throw new RuntimeException("Error: Role is not found.");
                            }
                        } else {
                            try {
                                Role userRole = roleRepository.findByName(ERole.ROLE_USER);
                                roles.add(userRole);
                            } catch (RuntimeException exception) {
                                throw new RuntimeException("Error: Role is not found.");
                            }
                        }
                    });
                }

                newUser.setRoles(roles);

                gameRepository.save(newGame);
                playerRepository.save(newPlayer);
                userRepository.save(newUser);

                feedback.setSuccessful(true);
                feedback.setMessage("Successfully created a new account.");

                this.logger.info("USER REGISTRATION: {}: SUCCESSFUL", registrationData.getUsername());

                return ResponseEntity.ok(feedback);

            } else {

                feedback.setMessage("Username in use.");

                this.logger.error("USER REGISTRATION: {}: FAILED: {}", registrationData.getUsername(), feedback.getMessage().toUpperCase());

                return ResponseEntity.badRequest().body(feedback);

            }

        } catch (Exception exception) {

            feedback.setSuccessful(false);
            feedback.setMessage("Something went wrong.");

            this.logger.error("USER REGISTRATION: {}: FAILED: {}", registrationData.getUsername(), exception);

            return ResponseEntity.badRequest().body(feedback);
        }

    }
}
