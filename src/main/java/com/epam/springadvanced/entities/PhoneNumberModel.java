package com.epam.springadvanced.entities;

import javax.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PHONE")
@Data
@NoArgsConstructor
public class PhoneNumberModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "number", length = 255, nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn
    private SubscriberModel subscriberModel;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn
    private ProviderCompanyModel ProviderCompanyModel;

    public PhoneNumberModel(String number) {
        this.number = number;
    }
}
