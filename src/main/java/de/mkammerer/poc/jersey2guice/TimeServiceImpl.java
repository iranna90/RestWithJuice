package de.mkammerer.poc.jersey2guice;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;
import de.mkammerer.poc.jersey2guice.entity.MyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class TimeServiceImpl implements TimeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeServiceImpl.class);

    private final Provider<EntityManager> entityManagerProvider;

    @Inject
    public TimeServiceImpl(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public ShortDate now() {
        LOGGER.info("Service short date access");
        entityManagerProvider.get().getTransaction().begin();
        MyEntity myEntity = entityManagerProvider.get().find(MyEntity.class, 1L);
        entityManagerProvider.get().getTransaction().commit();
        LOGGER.info("My entity {}", myEntity.toString());
        return new ShortDate(myEntity.getZonedDateTime().getYear(),
                myEntity.getZonedDateTime().getMonthValue(),
                myEntity.getZonedDateTime().getDayOfMonth());
    }
}
