package hu.webuni.airport.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
public class AddressDto {
    private Long id;
    private String country;
    private String street;
    private String city;
    private String zip;
}
