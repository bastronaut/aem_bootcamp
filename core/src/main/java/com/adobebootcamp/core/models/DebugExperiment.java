package com.adobebootcamp.core.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by BSijtsma on 26-04-2017.
 */
public class DebugExperiment {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugExperiment.class);

    public String getHelloWorldMessage() {
        int one = 1;
        // Set your first breakpoint on line 16
        int two = 2;
        int three = 1 + 2;
        String four = "four";
        String five = "five";
        String helloWorld = "Hello Bootcampees!";

        // Set your second breakpoint on line 23
        LOGGER.error("\nWe are logging from the Debug Experiment\n");
        LOGGER.error(helloWorld);

        return helloWorld;
    }

    public String getSomething() {
        return "";
    }
}
