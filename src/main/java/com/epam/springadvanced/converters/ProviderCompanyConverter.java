package com.epam.springadvanced.converters;

import com.epam.springadvanced.dto.ProviderCompanyData;
import com.epam.springadvanced.entities.ProviderCompanyModel;
import org.springframework.stereotype.Service;

@Service
public class ProviderCompanyConverter implements Converter<ProviderCompanyData, ProviderCompanyModel> {
    @Override
    public ProviderCompanyModel convertToModel(ProviderCompanyData data) {
        ProviderCompanyModel model = new ProviderCompanyModel();
        model.setCompanyName(data.getName());
        return model;
    }

    @Override
    public ProviderCompanyData convertToData(ProviderCompanyModel model) {
        return null;
    }
}
