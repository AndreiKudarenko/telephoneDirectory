package com.epam.springadvanced.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubscriberData {
    private int id;
    private String name;
    private List<PhoneNumberData> numbers;
}
