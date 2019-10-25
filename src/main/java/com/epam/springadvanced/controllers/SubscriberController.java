package com.epam.springadvanced.controllers;

import com.epam.springadvanced.dto.SubscriberData;
import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.facades.SubscriberFacade;
import com.itextpdf.text.DocumentException;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/subscriber")
public class SubscriberController {

    @Autowired
    SubscriberFacade subscriberFacade;

    @RequestMapping("/add")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public SubscriberModel post(@RequestBody SubscriberData subscriberData) {
        SubscriberModel model = subscriberFacade.saveSubscriber(subscriberData);
        return model;
    }

    @RequestMapping("/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubscriberData> getAll() {
        List<SubscriberData> allSubscribers = subscriberFacade.getAllSubscribers();
        return allSubscribers;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public SubscriberData getById(@PathVariable int id) {
        SubscriberData sub = subscriberFacade.getSubscriberById(id);
        return sub;
    }
}
