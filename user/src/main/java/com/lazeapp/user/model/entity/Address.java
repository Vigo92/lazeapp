package com.lazeapp.user.model.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {


    private String address;

    private String city;

    private String country;
}