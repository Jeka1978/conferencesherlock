package com.conference.hibernate.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 17:22
 */
@Service
@Transactional
public class CatService {
    private final CatRepository catRepository;
    private final MouseRepository mouseRepository;

    @Autowired
    public CatService(CatRepository catRepository, MouseRepository mouseRepository) {
        this.catRepository = catRepository;
        this.mouseRepository = mouseRepository;
    }

    public Cat create(String name) {
        Cat cat = new Cat();

        cat.setName(name);
        cat.setWeight(BigDecimal.ONE);

        return catRepository.save(cat);
    }

    public void update(long id, String name, BigDecimal weight) {
        catRepository.findById(id).ifPresent(e -> {
            e.setName(name);
            e.setWeight(weight);

            catRepository.save(e);
        });
    }

    public void caught(long id, BigDecimal weight) {
        catRepository.findById(id).ifPresent(e -> {
            Mouse mouse = new Mouse();

            mouse.setWeight(weight);

            e.getCaughtMice().add(mouseRepository.save(mouse));

            catRepository.save(e);
        });
    }
}
