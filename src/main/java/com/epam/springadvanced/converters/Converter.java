package com.epam.springadvanced.converters;

public interface Converter<D, M> {

    M convertToModel(final D data);

    D convertToData(final M model);
}
