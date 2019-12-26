package com.abbey.api.controllers.data;

import com.abbey.api.models.translation.Translation;
import com.abbey.api.repositories.translation.TranslationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/translation/{language}")
public class TranslationController {

    @Autowired
    private TranslationRepository translationRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity loadResources(@PathVariable("language") String language) {

        logger.info("LOAD TRANSLATIONS");

        Translation translation = translationRepository.getByLanguage(language);

        Map<Object, Object> model = new HashMap<>();
        model.put("translation",translation);
        model.put("success",true);

        return ok(model);

    }

}
