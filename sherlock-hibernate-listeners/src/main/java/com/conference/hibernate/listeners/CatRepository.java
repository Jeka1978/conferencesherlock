package com.conference.hibernate.listeners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 9:31
 */
@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    @Query("from Cat c join fetch c.caughtMice where c.id = :ID")
    Optional<Cat> findFullById(@Param("ID") long id);
}
