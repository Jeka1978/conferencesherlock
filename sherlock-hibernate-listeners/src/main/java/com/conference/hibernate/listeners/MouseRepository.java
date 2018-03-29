package com.conference.hibernate.listeners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 9:31
 */
@Repository
public interface MouseRepository extends JpaRepository<Mouse, Long> {
}
