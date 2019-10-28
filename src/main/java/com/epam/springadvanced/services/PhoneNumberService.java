package com.epam.springadvanced.services;

import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberModel saveNumber(PhoneNumberModel phoneNumberModel) {
        PhoneNumberModel number = phoneNumberRepository.save(phoneNumberModel);
        return number;
    }

    public List<PhoneNumberModel> getAllNumbers() {
        List<PhoneNumberModel> numbers = phoneNumberRepository.findAll();
        return numbers;
    }

    public List<PhoneNumberModel> getAllSubscriberNumbers(SubscriberModel model) {
        List<PhoneNumberModel> numbers = phoneNumberRepository.findBySubscriberModel(model);
        return numbers;
    }
}
