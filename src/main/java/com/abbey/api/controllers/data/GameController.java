package com.abbey.api.controllers.data;

import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.Abbey;
import com.abbey.api.models.game.Facility;
import com.abbey.api.models.game.Game;
import com.abbey.api.models.game.ResourceQuantity;
import com.abbey.api.repositories.authentication.UserRepository;
import com.abbey.api.repositories.game.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping(value = "/api/game")
public class GameController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity loadGame(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("LOAD GAME FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Game game = gameRepository.findBy_id(user.getGameId());

        Map<Object, Object> model = new HashMap<>();
        model.put("game",game);
        model.put("success",true);

        return ok(model);

    }

    @PutMapping(value = "")
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
    public @ResponseBody
    ResponseEntity saveGame(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Game updatedGame) {

        logger.info("UPDATE GAME FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Game game = gameRepository.findBy_id(user.getGameId());

        game.setAbbey(updatedGame.getAbbey());
        game.setBrewery(updatedGame.getBrewery());
        game.setFields(updatedGame.getFields());
        game.setWorkbench(updatedGame.getWorkbench());

        gameRepository.save(game);

        Map<Object, Object> model = new HashMap<>();
        model.put("game",game);
        model.put("success",true);

        return ok(model);

    }

    @PutMapping(value = "/stock")
    public @ResponseBody
    ResponseEntity updateStock(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Map<String, ResourceQuantity> stock) {

        logger.info("UPDATE STOCK OF GAME FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Game game = gameRepository.findBy_id(user.getGameId());

        game.setStock(stock);

        gameRepository.save(game);

        Map<Object, Object> model = new HashMap<>();
        model.put("game",game);
        model.put("success",true);

        return ok(model);

    }

    @PutMapping(value = "/abbey")
    public @ResponseBody
    ResponseEntity updateAbbey(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Abbey abbey) {

        logger.info("UPDATE ABBEY OF GAME FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Game game = gameRepository.findBy_id(user.getGameId());

        game.setAbbey(abbey);

        gameRepository.save(game);

        Map<Object, Object> model = new HashMap<>();
        model.put("game",game);
        model.put("success",true);

        return ResponseEntity.ok().body(model);

    }

}
