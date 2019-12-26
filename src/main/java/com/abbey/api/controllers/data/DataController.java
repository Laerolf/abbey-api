package com.abbey.api.controllers.data;

import com.abbey.api.models.authentication.User;
import com.abbey.api.models.game.*;
import com.abbey.api.repositories.authentication.UserRepository;
import com.abbey.api.repositories.game.*;
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
@RequestMapping(value = "/api/data")
public class DataController {

    @Autowired
    private BreweryProcessorRepository breweryProcessorRepository;

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private  RecipeRepository recipeRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private TransmutationRepository transmutationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity loadData(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("LOAD DATA FOR USER '{}'", userDetails.getUsername());

        List<Beer> beers = beerRepository.findAll();
        List<Facility> facilities = facilityRepository.findAll();
        List<Recipe> recipes = recipeRepository.findAll();
        List<Resource> resources = resourceRepository.findAll();
        List<Transmutation> transmutations = transmutationRepository.findAll();
        List<Vendor> vendors = vendorRepository.findAll();
        List<BreweryProcessor> breweryProcessors = breweryProcessorRepository.findAll();

        User user = userRepository.findByUsername(userDetails.getUsername());
        Player player = playerRepository.getBy_id(user.getPlayerId());
        Game game = gameRepository.findBy_id(user.getGameId());

        Map<Object, Object> model = new HashMap<>();
        model.put("beers",beers);
        model.put("facilities",facilities);
        model.put("recipes",recipes);
        model.put("resources",resources);
        model.put("transmutations",transmutations);
        model.put("vendors", vendors);
        model.put("breweryProcessors",breweryProcessors);
        model.put("user",user);
        model.put("player",player);
        model.put("game",game);

        model.put("success",true);

        return ok(model);
    }

}
