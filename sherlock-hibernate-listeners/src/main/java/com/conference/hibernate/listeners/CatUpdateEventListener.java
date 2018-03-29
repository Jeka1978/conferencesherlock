package com.conference.hibernate.listeners;

import org.hibernate.event.spi.PreCollectionUpdateEvent;
import org.hibernate.event.spi.PreCollectionUpdateEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 9:26
 */
@Component
public class CatUpdateEventListener implements PreInsertEventListener, PreUpdateEventListener, PreCollectionUpdateEventListener {
    private static final Logger LOG = LoggerFactory.getLogger(CatUpdateEventListener.class);

    private final CatRepository catRepository;


    @Autowired
    public CatUpdateEventListener(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        Object entity = event.getEntity();

        if (entity instanceof Cat) {
            log((Cat) entity);
        }

        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        Object entity = event.getEntity();

        if (entity instanceof Cat) {
            log((Cat) entity);
        }

        return false;
    }

    @Override
    public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
        Object owner = event.getAffectedOwnerOrNull();

        if (owner instanceof Cat) {
            log((Cat) owner);
        }
    }

    private void log(Cat cat) {
        if (cat.getId() != null) {
            catRepository.findFullById(cat.getId())
                    .ifPresent(e -> LOG.info("Cat {} caught {} mice", e.getName(), e.getCaughtMice().stream().map(Mouse::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add)));
        }
    }

//    private void log(Cat cat) {
//        LOG.info("Cat {} caught {} kg of mice", cat.getName(), cat.getCaughtMice().stream().map(Mouse::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
//    }
}
