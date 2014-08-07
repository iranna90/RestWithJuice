package de.mkammerer.poc.jersey2guice;

import java.util.Date;

public class TimeServiceImpl implements TimeService {
    @Override
    public Date now() {
        return new Date();
    }
}
