package com.epam.springadvanced.dto;

import lombok.Data;

@Data
public class PhoneNumberData {
    private String number;
    private ProviderCompanyData providerCompanyData;
}
