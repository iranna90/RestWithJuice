package de.mkammerer.poc.jersey2guice.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import de.mkammerer.poc.jersey2guice.TimeService;
import de.mkammerer.poc.jersey2guice.TimeServiceImpl;

public class GuiceModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(TimeService.class).to(TimeServiceImpl.class).in(Singleton.class);
    }
}
