package com.epam.springadvanced.controllers;

import com.epam.springadvanced.dto.PhoneNumberData;
import com.epam.springadvanced.facades.PhoneNumberFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping("/phoneNumbers")
public class PhoneNumberController {

    @Autowired
    PhoneNumberFacade phoneNumberFacade;

    @RequestMapping("/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<PhoneNumberData> getAll() {
        List<PhoneNumberData> allNumbers = phoneNumberFacade.getAllNumbers();
        return allNumbers;
    }
}
