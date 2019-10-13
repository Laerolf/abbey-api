package com.abbey.api.initializers;

import com.abbey.api.initializers.loaders.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class Initializer implements ApplicationRunner {

    private Logger logger;

    @Autowired
    DataLoader dataLoader;

    public Initializer() {
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.initializeDB();
    }

    private void initializeDB() {
        this.dataLoader.loadData();
    }
}
