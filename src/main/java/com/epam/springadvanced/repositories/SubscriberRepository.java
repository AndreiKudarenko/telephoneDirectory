package com.epam.springadvanced.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.springadvanced.entities.SubscriberModel;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberModel, Integer> {
}
