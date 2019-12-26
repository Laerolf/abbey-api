package com.abbey.api.controllers.data;


import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.Game;
import com.abbey.api.models.game.Story;
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
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
@RequestMapping(value = "/api/stories")
public class StoriesController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PutMapping(value = "")
    public @ResponseBody
    ResponseEntity updateStory(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Story updatedStory) {

        logger.info("UPDATE STORY FOR USER '{}'", userDetails.getUsername());

        User user = userRepository.getByUsername(userDetails.getUsername());
        Game game = gameRepository.findBy_id(user.getGameId());

        Story oldStory = game.getStory();

        oldStory.setStoryAnswers(updatedStory.getStoryAnswers());
        oldStory.setCompleteStory(updatedStory.getCompleteStory());

        game.setStory(oldStory);

        gameRepository.save(game);

        Map<Object, Object> model = new HashMap<>();
        model.put("story",oldStory);
        model.put("success",true);

        return ok(model);

    }

}
