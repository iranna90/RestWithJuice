package de.mkammerer.poc.jersey2guice.guice;

import com.google.inject.PrivateModule;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import de.mkammerer.poc.jersey2guice.TimeService;
import de.mkammerer.poc.jersey2guice.TimeServiceImpl;

public class GuiceModule extends PrivateModule {

    protected void configure() {
        install(new JpaPersistModule("test-db"));
        bind(TimeService.class).to(TimeServiceImpl.class).in(Singleton.class);
        expose(PersistService.class);
        expose(TimeService.class);
    }
}
