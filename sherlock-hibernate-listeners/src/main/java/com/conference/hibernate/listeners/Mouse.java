package com.conference.hibernate.listeners;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 9:04
 */
@Entity
public class Mouse {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "S_MOUSE", allocationSize = 25)
    private Long id;
    private BigDecimal weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
