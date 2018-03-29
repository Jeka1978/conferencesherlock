package com.conference.hibernate.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 17:48
 */
@Component
public class SherlockRunner {
    private static final Logger LOG = LoggerFactory.getLogger(SherlockRunner.class);
    
    private final CatService catService;

    @Autowired
    public SherlockRunner(CatService catService) {
        this.catService = catService;
    }

    @Scheduled(fixedDelay = 1000)
    public void run() {
        LOG.info("Started");

        Cat tom = catService.create("Tom");

        catService.caught(tom.getId(), BigDecimal.ONE);
        catService.caught(tom.getId(), BigDecimal.ONE);
        catService.caught(tom.getId(), BigDecimal.ONE);
        catService.caught(tom.getId(), BigDecimal.ONE);
        catService.caught(tom.getId(), BigDecimal.ONE);
        catService.caught(tom.getId(), BigDecimal.ONE);

        catService.update(tom.getId(), "Tommy", BigDecimal.TEN);

        LOG.info("Completed");
    }
}
