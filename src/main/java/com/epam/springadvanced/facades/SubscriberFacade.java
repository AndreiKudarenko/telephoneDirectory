package com.epam.springadvanced.facades;

import com.epam.springadvanced.converters.Converter;
import com.epam.springadvanced.dto.PhoneNumberData;
import com.epam.springadvanced.dto.SubscriberData;
import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.services.PhoneNumberService;
import com.epam.springadvanced.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberFacade {

    @Autowired
    private Converter<SubscriberData, SubscriberModel> converter;
    @Autowired
    private Converter<PhoneNumberData, PhoneNumberModel> phoneNumberConverter;
    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private PhoneNumberService phoneNumberService;

    public void saveSubscriber(List<SubscriberData> subscriberData) {
        subscriberData.forEach(data -> {
            SubscriberModel model = converter.convertToModel(data);
            List<PhoneNumberModel> numbers = data.getNumbers()
                    .stream()
                    .map(number -> phoneNumberConverter.convertToModel(number))
                    .collect(Collectors.toList());
            model.setPhoneNumberModel(numbers);
            numbers.forEach(number -> number.setSubscriberModel(model));
            subscriberService.saveSubscriber(model);
        });
    }

    public List<SubscriberData> getAllSubscribers() {
        List<SubscriberModel> allSubscribers = subscriberService.getAllSubscribers();
        allSubscribers.forEach(subscriberModel -> {
            List<PhoneNumberModel> allSubscriberNumbers = phoneNumberService.getAllSubscriberNumbers(subscriberModel);
            subscriberModel.setPhoneNumberModel(allSubscriberNumbers);
        });

        List<SubscriberData> subscriberData = allSubscribers.stream()
                .map(sub -> converter.convertToData(sub))
                .collect(Collectors.toList());
        return subscriberData;
    }

    public SubscriberData getSubscriberById(int id) {
        SubscriberModel subscriberModel = subscriberService.getSubscriberById(id);
        List<PhoneNumberModel> allSubscriberNumbers = phoneNumberService.getAllSubscriberNumbers(subscriberModel);
        subscriberModel.setPhoneNumberModel(allSubscriberNumbers);
        subscriberModel.setId(id);
        SubscriberData subscriberData = converter.convertToData(subscriberModel);
        return subscriberData;
    }
}
