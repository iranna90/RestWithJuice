package de.mkammerer.poc.jersey2guice.entity;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iranna.patil on 13-08-2016.
 */
public class DataBaseInititalizer {

    public static final Logger LOGGER = LoggerFactory.getLogger(DataBaseInititalizer.class);

    @Inject
    public DataBaseInititalizer(PersistService persistService) {
        LOGGER.error("data base initialized");
        persistService.start();
    }
}
