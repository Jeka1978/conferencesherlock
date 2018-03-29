package com.conference.hibernate.listeners;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 9:03
 */
@Entity
public class Cat {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "S_CAT", allocationSize = 25)
    private Long id;
    private String name;
    private BigDecimal weight;
    @OneToMany
    private List<Mouse> caughtMice = new ArrayList<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public List<Mouse> getCaughtMice() {
        return caughtMice;
    }

    public void setCaughtMice(List<Mouse> caughtMice) {
        this.caughtMice = caughtMice;
    }
}
