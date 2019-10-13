package com.abbey.api.controllers;

import com.abbey.api.repositories.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

}
