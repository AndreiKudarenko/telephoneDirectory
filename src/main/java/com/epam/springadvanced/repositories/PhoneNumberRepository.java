package com.epam.springadvanced.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.springadvanced.entities.PhoneNumberModel;

import java.util.List;
import java.util.Set;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumberModel, Integer> {
    Set<PhoneNumberModel> findBySubscriberModelId(int SubId);
}
