package com.epam.springadvanced.controllers;

import com.epam.springadvanced.dto.SubscriberData;
import com.epam.springadvanced.facades.SubscriberFacade;
import com.epam.springadvanced.parsers.SubscriberParser;
import com.epam.springadvanced.services.PdfGenerator;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberFacade subscriberFacade;
    @Autowired
    private SubscriberParser subscriberParser;
    @Autowired
    private PdfGenerator pdfGenerator;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public String post(@RequestParam("file") MultipartFile file) {
        List<SubscriberData> subscriberData = null;
        try {
            subscriberData = subscriberParser.parseToObject(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        subscriberFacade.saveSubscriber(subscriberData);
        return "successful";
    }

    @RequestMapping(value = "/all", headers = "Accept=application/json")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<InputStreamResource> getAll() throws DocumentException {
        List<SubscriberData> allSubscribers = subscriberFacade.getAllSubscribers();
        ByteArrayInputStream bis = pdfGenerator.convertSubscriberToPdf(allSubscribers);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping("/get")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<InputStreamResource> getById(@RequestParam String id) throws DocumentException {
        SubscriberData sub = subscriberFacade.getSubscriberById(Integer.valueOf(id));
        ByteArrayInputStream bis = pdfGenerator.convertSubscriberToPdf(sub);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
