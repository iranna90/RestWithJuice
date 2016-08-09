package de.mkammerer.poc.jersey2guice.guice;

import com.google.inject.PrivateModule;
import com.google.inject.Singleton;

import de.mkammerer.poc.jersey2guice.TimeService;
import de.mkammerer.poc.jersey2guice.TimeServiceImpl;

public class GuiceModule extends PrivateModule {

    protected void configure() {
        bind(TimeService.class).to(TimeServiceImpl.class).in(Singleton.class);
        expose(TimeService.class);
    }
}
