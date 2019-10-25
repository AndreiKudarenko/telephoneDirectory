package com.epam.springadvanced.entities;

import javax.persistence.*;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SUBSCRIBER")
@Data
@NoArgsConstructor
public class SubscriberModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subscriberModel", cascade = CascadeType.PERSIST)
    private Set<PhoneNumberModel> phoneNumberModel;

    public SubscriberModel(String name, Set<PhoneNumberModel> phoneNumberModel) {
        this.name = name;
        this.phoneNumberModel = phoneNumberModel;
    }
}
