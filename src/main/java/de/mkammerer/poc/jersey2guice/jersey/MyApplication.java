package de.mkammerer.poc.jersey2guice.jersey;

import com.google.inject.Guice;

import de.mkammerer.poc.jersey2guice.guice.GuiceModule;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

public class MyApplication extends ResourceConfig {

    @Inject
    public MyApplication(ServiceLocator serviceLocator) {
        packages("de.mkammerer.poc.jersey2guice.jersey", "de.mkammerer.poc.jersey2guice.providers");

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
    }
}
