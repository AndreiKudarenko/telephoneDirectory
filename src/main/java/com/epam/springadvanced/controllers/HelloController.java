package com.epam.springadvanced.controllers;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;

import com.epam.springadvanced.services.PdfGenerator;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.repositories.PhoneNumberRepository;
import com.epam.springadvanced.repositories.SubscriberRepository;

@Controller
public class HelloController {

    @Autowired
    SubscriberRepository subscriberRepository;
    @Autowired
    PhoneNumberRepository phoneNumberRepository;
    @Autowired
    PdfGenerator pdfGenerator;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/")
    @ResponseBody
    public SubscriberModel post() {
        HashSet phoneNumbers = new HashSet();
        PhoneNumberModel number = phoneNumberRepository.save(new PhoneNumberModel("11111111"));
        phoneNumbers.add(number);
        int id = subscriberRepository.save(new SubscriberModel("Andrei", "Kudarenko", phoneNumbers)).getId();
        return subscriberRepository.findById(id).get();
    }

    @RequestMapping("/allUsers")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getAllSubs() throws DocumentException {
        List<SubscriberModel> all = subscriberRepository.findAll();

        ByteArrayInputStream byteArrayInputStream = pdfGenerator.convertSubscriberToPdf(all);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=subscribers.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }

    @RequestMapping("/allNumbers")
    @ResponseBody
    public List<PhoneNumberModel> getAllNumbers() {
        return phoneNumberRepository.findAll();
    }
}
