package com.epam.springadvanced.controllers;

import com.epam.springadvanced.dto.SubscriberData;
import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.SubscriberModel;
import com.epam.springadvanced.facades.SubscriberFacade;
import com.epam.springadvanced.parsers.SubscriberParser;
import com.epam.springadvanced.services.PdfGenerator;
import com.itextpdf.text.DocumentException;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class SubscriberController {

    @Autowired
    private SubscriberFacade subscriberFacade;
    @Autowired
    private SubscriberParser subscriberParser;
    @Autowired
    private PdfGenerator pdfGenerator;

    @PostMapping(value = "/upload")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String post(@RequestParam("file") MultipartFile file) {
        SubscriberData subscriberData = null;
        try {
            subscriberData = subscriberParser.parseToObject(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SubscriberModel model = subscriberFacade.saveSubscriber(subscriberData);
        return "addSubscriber";
    }

    @RequestMapping("subscribers/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubscriberData> getAll() {
        List<SubscriberData> allSubscribers = subscriberFacade.getAllSubscribers();
        return allSubscribers;
    }

    @GetMapping(value = "/addSubscriber")
    public String addPersonForm(Model model) {
        SubscriberData subscriberData = new SubscriberData();
        model.addAttribute("subscriber", subscriberData);
        return "addSubscriber";
    }

    @RequestMapping("subscribers/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public SubscriberData getById(@PathVariable int id) {
        SubscriberData sub = subscriberFacade.getSubscriberById(id);
        return sub;
    }
}
