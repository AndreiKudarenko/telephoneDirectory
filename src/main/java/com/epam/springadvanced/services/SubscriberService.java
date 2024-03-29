package com.epam.springadvanced.services;

import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.repositories.PhoneNumberRepository;
import com.epam.springadvanced.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public SubscriberModel saveSubscriber(SubscriberModel subscriberModel) {
        SubscriberModel subscriber = subscriberRepository.save(subscriberModel);
        return subscriber;
    }

    public List<SubscriberModel> getAllSubscribers() {
        List<SubscriberModel> subscribers = subscriberRepository.findAll();
        return subscribers;
    }

    public SubscriberModel getSubscriberById(int id) {
        Optional<SubscriberModel> sub = subscriberRepository.findById(id);
        return sub.get();
    }
}
