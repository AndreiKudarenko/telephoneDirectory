package com.epam.springadvanced.converters;

import com.epam.springadvanced.dto.PhoneNumberData;
import com.epam.springadvanced.dto.SubscriberData;
import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.SubscriberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class SubscriberConverter implements Converter<SubscriberData, SubscriberModel> {
    @Autowired
    private PhoneNumberConverter phoneNumberConverter;

    public SubscriberModel convertToModel(SubscriberData data) {
        SubscriberModel model = new SubscriberModel();
        model.setName(data.getName());
        List<PhoneNumberData> phoneNumberData = data.getNumbers();
        List<PhoneNumberModel> phoneNumberModel = phoneNumberData.stream()
                .map(numberData -> phoneNumberConverter.convertToModel(numberData))
                .collect(Collectors.toList());
        model.setPhoneNumberModel(phoneNumberModel);

        return model;
    }

    public SubscriberData convertToData(SubscriberModel model) {
        SubscriberData data = new SubscriberData();
        data.setName(model.getName());
        data.setNumbers(model.getPhoneNumberModel()
        .stream()
        .map(number -> phoneNumberConverter.convertToData(number))
                .collect(Collectors.toList()));
        return data;
    }
}
