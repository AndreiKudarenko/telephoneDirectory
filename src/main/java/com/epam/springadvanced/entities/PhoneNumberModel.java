package com.epam.springadvanced.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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

    @ManyToOne
    @JoinColumn
    private SubscriberModel subscriberModel;

    public PhoneNumberModel(String number) {
        this.number = number;
    }
}
