package com.abbey.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping(value = "/api/logout")
@Controller
public class LogoutController {


    @PostMapping(value = "")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok().body("logout");
    }

}
