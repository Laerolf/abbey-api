package com.abbey.api.controllers;

import com.abbey.api.models.authentication.LoginData;
import com.abbey.api.models.authentication.User;
import com.abbey.api.repositories.authentication.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
@RequestMapping(value = "/api/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository users;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("")
    public ResponseEntity login(@RequestBody LoginData data, HttpServletRequest request) {

        String username = data.getUsername();
        String password = data.getPassword();

        this.logger.info("USER LOGIN: {}", username);

        try {

            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(auth);

            HttpSession session = request.getSession(true);
            session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);

            User user = this.userRepository.getByUsername(username);
            user.setLastLoginDate(new Date());
            this.userRepository.save(user);

            Map<Object, Object> model = new HashMap<>();
            model.put("success", true);
            model.put("message", "Successfully logged in.");

            this.logger.info("USER LOGIN: {}: SUCCESSFUL", username);

            return ok(model);

        } catch (AuthenticationException exception) {
            this.logger.error("USER LOGIN: {}: FAILED: {}", username, exception);

            Map<Object, Object> model = new HashMap<>();
            model.put("success", false);
            model.put("message", "Something went wrong.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
        }
    }

}
