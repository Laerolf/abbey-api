package com.abbey.api.controllers.data;

import com.abbey.api.models.game.Resource;
import com.abbey.api.repositories.game.ResourceRepository;
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
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
@RequestMapping(value = "/api/resources")
public class ResourcesController {

    @Autowired
    private ResourceRepository resourceRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity loadResources(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("LOAD RESOURCES FOR USER '{}'", userDetails.getUsername());

        List<Resource> resources = resourceRepository.findAll();

        Map<Object, Object> model = new HashMap<>();
        model.put("resources",resources);
        model.put("success",true);

        return ok(model);

    }

}
