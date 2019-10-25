package com.epam.springadvanced.facades;

import com.epam.springadvanced.converters.PhoneNumberConverter;
import com.epam.springadvanced.dto.PhoneNumberData;
import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberFacade {

    @Autowired
    private PhoneNumberConverter converter;
    @Autowired
    private PhoneNumberService phoneNumberService;

    public PhoneNumberModel addNumber(PhoneNumberModel model) {
        PhoneNumberModel phoneNumberModel = phoneNumberService.saveNumber(model);
        return phoneNumberModel;
    }

    public List<PhoneNumberData> getAllNumbers() {
        List<PhoneNumberModel> allNumbers = phoneNumberService.getAllNumbers();
        List<PhoneNumberData> numbersData = allNumbers.stream()
                .map(number -> converter.convertToData(number))
                .collect(Collectors.toList());
        return numbersData;
    }
}
