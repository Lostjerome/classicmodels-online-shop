package com.example.classicmodelsonlineshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Offices")
@NamedQueries({
        @NamedQuery(name = "Office.FIND_BY_CITY_OR_COUNTRY",
                query = "SELECT o FROM Office o WHERE o.city LIKE :cityOrCountry OR o.country LIKE :cityOrCountry"),
})
public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;

    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employees;
}