package com.epam.springadvanced.converters;

import com.epam.springadvanced.dto.PhoneNumberData;
import com.epam.springadvanced.dto.ProviderCompanyData;
import com.epam.springadvanced.entities.PhoneNumberModel;
import com.epam.springadvanced.entities.ProviderCompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberConverter implements Converter<PhoneNumberData, PhoneNumberModel>{

    @Autowired
    ProviderCompanyConverter providerCompanyConverter;

    public PhoneNumberModel convertToModel(PhoneNumberData data) {
        PhoneNumberModel model = new PhoneNumberModel();
        model.setNumber(data.getNumber());
        ProviderCompanyData providerCompanyData = data.getProviderCompanyData();
        ProviderCompanyModel providerCompanyModel = providerCompanyConverter.convertToModel(providerCompanyData);
        model.setProviderCompanyModel(providerCompanyModel);
        return model;
    }

    public PhoneNumberData convertToData(PhoneNumberModel model) {
        PhoneNumberData data = new PhoneNumberData();
        data.setNumber(model.getNumber());
        data.setProviderCompanyData(providerCompanyConverter.convertToData(model.getProviderCompanyModel()));
        return data;
    }

}
