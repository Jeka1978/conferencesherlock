package com.conference.hibernate.listeners;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreCollectionUpdateEventListener;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManagerFactory;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 17:11
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
@EntityScan(basePackageClasses = Cat.class)
public class SherlockApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SherlockApplication.class, args);

        SessionFactoryImpl sessionFactory = applicationContext.getBean(EntityManagerFactory.class).unwrap(SessionFactoryImpl.class);

        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

        registry.appendListeners(EventType.PRE_INSERT, applicationContext.getBeansOfType(PreInsertEventListener.class).values().toArray(new PreInsertEventListener[0]));
        registry.appendListeners(EventType.PRE_UPDATE, applicationContext.getBeansOfType(PreUpdateEventListener.class).values().toArray(new PreUpdateEventListener[0]));
        registry.appendListeners(EventType.PRE_COLLECTION_UPDATE, applicationContext.getBeansOfType(PreCollectionUpdateEventListener.class).values().toArray(new PreCollectionUpdateEventListener[0]));
    }
}
