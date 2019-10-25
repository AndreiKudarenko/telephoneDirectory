package com.epam.springadvanced.facades;

import com.epam.springadvanced.converters.SubscriberConverter;
import com.epam.springadvanced.dto.SubscriberData;
import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberFacade {

    @Autowired
    private SubscriberConverter converter;
    @Autowired
    private SubscriberService subscriberService;

    public SubscriberModel saveSubscriber(SubscriberData subscriberData) {
        SubscriberModel model = converter.convertToModel(subscriberData);
        return subscriberService.saveSubscriber(model);
    }

    public List<SubscriberData> getAllSubscribers() {
        List<SubscriberModel> allSubscribers = subscriberService.getAllSubscribers();
        List<SubscriberData> subsData = allSubscribers.stream()
                .map(sub -> converter.convertToData(sub))
                .collect(Collectors.toList());
        return subsData;
    }

    public SubscriberData getSubscriberById(int id) {
        SubscriberModel subscriberById = subscriberService.getSubscriberById(id);
        SubscriberData subscriberData = converter.convertToData(subscriberById);
        return subscriberData;
    }
}
