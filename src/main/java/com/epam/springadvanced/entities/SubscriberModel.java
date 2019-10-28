package com.epam.springadvanced.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SubscriberModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<PhoneNumberModel> phoneNumberModel = new ArrayList<>();

    public SubscriberModel(String name, List<PhoneNumberModel> phoneNumberModel) {
        this.name = name;
        this.phoneNumberModel = phoneNumberModel;
    }
}
