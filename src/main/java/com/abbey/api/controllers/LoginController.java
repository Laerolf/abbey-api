package com.abbey.api.controllers;

import com.abbey.api.authenticator.Authenticator;
import com.abbey.api.models.authentication.AuthenticationFeedback;
import com.abbey.api.models.authentication.LoginData;
import com.abbey.api.models.authentication.LoginFeedback;
import com.abbey.api.models.authentication.User;
import com.abbey.api.repositories.authentication.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "")
    public @ResponseBody
    LoginFeedback login(@RequestBody LoginData loginData){

        logger.info("LOGIN: TRYING TO LOGIN");

        LoginFeedback feedback = LoginFeedback.builder().build();

        User intendedUser = userRepository.getByUsername(loginData.getUsername());

        if (intendedUser != null){

            if (intendedUser.getPassword().equals(loginData.getPassword())){
                logger.info("LOGIN: SUCCESSFUL");

                Authenticator authenticator = Authenticator.getInstance();

                Map<String, String> tokenData = new HashMap<>();
                tokenData.put("user", intendedUser.get_id());
                tokenData.put("game", intendedUser.getGameId());
                tokenData.put("player", intendedUser.getPlayerId());

                AuthenticationFeedback authenticationFeedback = authenticator.createToken(tokenData);

                feedback.addData("token", authenticationFeedback.getData().get("token"));

                feedback.setSuccessful(true);
                feedback.setMessage("Successfully logged in!");
            }
            else {
                logger.info("LOGIN: FAILED");

                feedback.setSuccessful(false);
                feedback.setMessage("Wrong password.");
            }

        }
        else {
            logger.info("LOGIN: FAILED");

            feedback.setSuccessful(false);
            feedback.setMessage("There is no user with username '" + loginData.getUsername() + "'.");
        }

        return feedback;
    }

}
