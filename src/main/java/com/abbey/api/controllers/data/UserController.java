package com.abbey.api.controllers.data;

import com.abbey.api.models.authentication.User;
import com.abbey.api.repositories.authentication.UserRepository;
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
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity loadUser(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("LOAD USER '{}'", userDetails.getUsername());

        User user = userRepository.findByUsername(userDetails.getUsername());

        Map<Object, Object> model = new HashMap<>();
        model.put("user",user);
        model.put("success",true);

        return ok(model);

    }

}
