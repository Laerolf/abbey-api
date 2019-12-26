package com.abbey.api.controllers.data.game;

import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.Facility;
import com.abbey.api.models.game.Game;
import com.abbey.api.repositories.authentication.UserRepository;
import com.abbey.api.repositories.game.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
@RequestMapping(value = "/api/game")
public class FacilityController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PutMapping(value = "/facilities")
    public @ResponseBody
    ResponseEntity updateFacility(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Facility facility) {

        logger.info("UPDATE FACILITY '{}' OF GAME FOR USER '{}'", facility.getName(), userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Game game = gameRepository.findBy_id(user.getGameId());

         game.getFacilities().forEach(gameFacility -> {
             if (gameFacility.get_id().equals(facility.get_id())){
                 gameFacility.setCollectAmount(facility.getCollectAmount());
                 gameFacility.setCollectable(facility.getCollectable());
                 gameFacility.setName(facility.getName());
                 gameFacility.setProgress(facility.getProgress());
                 gameFacility.setResourceChances(facility.getResourceChances());
                 gameFacility.setStorage(facility.getStorage());
                 gameFacility.setUnlocked(facility.getUnlocked());
                 gameFacility.setLastTimeVisited(new Date());
                 gameFacility.setJob(facility.getJob());
                 gameFacility.setTotalProcessTime(facility.getTotalProcessTime());
                 gameFacility.setProgressStep(facility.getProgressStep());
             }
         });

        gameRepository.save(game);

        Map<Object, Object> model = new HashMap<>();
        model.put("game",game);
        model.put("success",true);

        return ok(model);

    }

}
