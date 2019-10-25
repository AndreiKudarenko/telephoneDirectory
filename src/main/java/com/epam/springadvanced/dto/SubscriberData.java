package com.epam.springadvanced.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubscriberData {
    public String name;
    public List<PhoneNumberData> numbers;
}
