package com.epam.springadvanced.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @Column(name = "firstName", length = 255, nullable = false)
    private String firstName;

    @Column(name = "secondName", length = 255, nullable = false)
    private String secondName;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    private Set<PhoneNumberModel> phoneNumberModel;

    public SubscriberModel(String firstName, String secondName, Set<PhoneNumberModel> phoneNumberModel) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumberModel = phoneNumberModel;
    }
}
