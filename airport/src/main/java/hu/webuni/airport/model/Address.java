package hu.webuni.airport.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include()
    private Long id;
    private String country;
    private String street;
    private String city;
    private String zip;
}
