package com.abbey.api.controllers.data;

import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.Player;
import com.abbey.api.repositories.authentication.UserRepository;
import com.abbey.api.repositories.game.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
@RequestMapping(value = "/api/player")
public class PlayerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity loadPlayer(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("LOAD PLAYER FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Player player = playerRepository.getBy_id(user.getPlayerId());

        Map<Object, Object> model = new HashMap<>();
        model.put("player",player);
        model.put("success",true);

        return ok(model);

    }

    @PutMapping(value = "")
    public @ResponseBody
    ResponseEntity updatePlayer(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Player updatedPlayer) {

        logger.info("UPDATE PLAYER FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Player player = playerRepository.getBy_id(user.getPlayerId());

        player.setCounter(updatedPlayer.getCounter());
        player.setGoldenCoins(updatedPlayer.getGoldenCoins());
        player.setReputation(updatedPlayer.getReputation());
        player.setName(updatedPlayer.getName());

        playerRepository.save(player);

        Map<Object, Object> model = new HashMap<>();
        model.put("player",player);
        model.put("success",true);

        return ok(model);

    }
}
