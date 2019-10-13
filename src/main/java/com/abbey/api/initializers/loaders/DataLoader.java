package com.abbey.api.initializers.loaders;

import com.abbey.api.models.game.*;
import com.abbey.api.repositories.game.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataLoader {

    private Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private BeerRepository beerRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private BreweryProcessorRepository breweryProcessorRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private TransmutationRepository transmutationRepository;
    @Autowired
    private VendorRepository vendorRepository;

    private Map<String, String> dataPaths;

    public DataLoader() {
        this.dataPaths = new HashMap<>();
        this.dataPaths.put("resources", "/data/resources.json");
        this.dataPaths.put("beers", "/data/beers.json");
        this.dataPaths.put("breweryProcessors", "/data/breweryProcessors.json");
        this.dataPaths.put("facilities", "/data/facilities.json");
        this.dataPaths.put("recipes", "/data/recipes.json");
        this.dataPaths.put("transmutations", "/data/transmutations.json");
        this.dataPaths.put("vendors", "/data/vendors.json");
    }

    public void loadData() {
        for (Map.Entry<String, String> entry : this.dataPaths.entrySet()) {

            switch (entry.getKey()) {

                case "resources":
                    this.loadResources(entry.getKey(), entry.getValue());
                    break;

                case "beers":
                    this.loadBeers(entry.getKey(), entry.getValue());
                    break;

                case "breweryProcessors":
                    this.loadBreweryProcessors(entry.getKey(), entry.getValue());
                    break;

                case "facilities":
                    this.loadFacilities(entry.getKey(), entry.getValue());
                    break;

                case "recipes":
                    this.loadRecipes(entry.getKey(), entry.getValue());
                    break;

                case "transmutations":
                    this.loadTransmutations(entry.getKey(), entry.getValue());
                    break;

                case "vendors":
                    this.loadVendors(entry.getKey(), entry.getValue());
                    break;
            }
        }

        this.loadStory();
    }

    public Story loadStory() {

        String dataPathAbbotNames = "/data/storyAbbotNames.json";
        String dataPathRandomFacts = "/data/storyRandomFacts.json";
        String dataPathStoryChapters = "/data/storyChapters.json";

        Map<String, String> storyChapters = new HashMap<>();
        List<String> randomFacts = new ArrayList<>();
        List<String> abbotNames = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, String>> typeReferenceMap = new TypeReference<Map<String, String>>() {
        };
        TypeReference<List<String>> typeReferenceList = new TypeReference<List<String>>() {
        };

        InputStream inputStream = TypeReference.class.getResourceAsStream(dataPathStoryChapters);
        try {
            storyChapters = mapper.readValue(inputStream, typeReferenceMap);
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", "story chapters", exception.getMessage());
        }

        inputStream = TypeReference.class.getResourceAsStream(dataPathRandomFacts);
        try {
            randomFacts = mapper.readValue(inputStream, typeReferenceList);
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", "random facts", exception.getMessage());
        }

        inputStream = TypeReference.class.getResourceAsStream(dataPathAbbotNames);
        try {
            abbotNames = mapper.readValue(inputStream, typeReferenceList);
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", "abbot names", exception.getMessage());
        }

        return Story.builder()
                ._id(ObjectId.get().toHexString())
                .chapters(storyChapters)
                .abbotNames(abbotNames)
                .randomFacts(randomFacts)
                .build();
    }

    private void loadResources(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Resource>> typeReference = new TypeReference<List<Resource>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<Resource> resources = mapper.readValue(inputStream, typeReference);

            resources.forEach(resource -> {
                if (this.resourceRepository.getByName(resource.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), resource.getName());
                    this.resourceRepository.save(resource);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

    private void loadBeers(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Beer>> typeReference = new TypeReference<List<Beer>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<Beer> beers = mapper.readValue(inputStream, typeReference);

            beers.forEach(beer -> {
                if (this.beerRepository.getByName(beer.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), beer.getName());
                    this.beerRepository.save(beer);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

    private void loadBreweryProcessors(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<BreweryProcessor>> typeReference = new TypeReference<List<BreweryProcessor>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<BreweryProcessor> breweryProcessors = mapper.readValue(inputStream, typeReference);

            breweryProcessors.forEach(breweryProcessor -> {
                if (this.breweryProcessorRepository.getByName(breweryProcessor.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), breweryProcessor.getName());
                    this.breweryProcessorRepository.save(breweryProcessor);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

    private void loadFacilities(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Facility>> typeReference = new TypeReference<List<Facility>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<Facility> facilities = mapper.readValue(inputStream, typeReference);

            facilities.forEach(facility -> {
                if (this.facilityRepository.getByName(facility.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), facility.getName());
                    this.facilityRepository.save(facility);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

    private void loadRecipes(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Recipe>> typeReference = new TypeReference<List<Recipe>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<Recipe> recipes = mapper.readValue(inputStream, typeReference);

            recipes.forEach(recipe -> {
                if (this.recipeRepository.getByName(recipe.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), recipe.getName());
                    this.recipeRepository.save(recipe);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

    private void loadTransmutations(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Transmutation>> typeReference = new TypeReference<List<Transmutation>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<Transmutation> transmutations = mapper.readValue(inputStream, typeReference);

            transmutations.forEach(transmutation -> {
                if (this.transmutationRepository.getByName(transmutation.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), transmutation.getName());
                    this.transmutationRepository.save(transmutation);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

    private void loadVendors(String elementName, String elementDataPath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Vendor>> typeReference = new TypeReference<List<Vendor>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(elementDataPath);
        try {
            List<Vendor> vendors = mapper.readValue(inputStream, typeReference);

            vendors.forEach(vendor -> {
                if (this.vendorRepository.getByName(vendor.getName()) == null) {
                    this.logger.info("CREATING {}: {}", elementName.toUpperCase(), vendor.getName());
                    this.vendorRepository.save(vendor);
                }
            });
        } catch (IOException exception) {
            this.logger.error("Unable to load all {}: {}", elementName, exception.getMessage());
        }
    }

}
