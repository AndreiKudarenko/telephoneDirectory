package com.epam.springadvanced.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PROVIDER_COMPANY")
@Data
@NoArgsConstructor
public class ProviderCompanyModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "companyName", length = 255, nullable = false)
    private String companyName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subscriberModel", cascade = CascadeType.PERSIST)
    private Set<PhoneNumberModel> phoneNumberModel;

}
