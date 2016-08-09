package de.mkammerer.poc.jersey2guice;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class TimeServiceImpl implements TimeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeServiceImpl.class);

    public ShortDate now() {
        LOGGER.info("Service short date access");
        LocalDate localDate = LocalDate.now();
        return new ShortDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }
}
