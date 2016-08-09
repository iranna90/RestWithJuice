package de.mkammerer.poc.jersey2guice;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import java.util.Date;

public interface TimeService {
    ShortDate now();
}
