package hu.webuni.airport.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Cacheable
public class Airport {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include()
	private long id;

	@Size(min = 3, max = 20)
	private String name;
	private String iata;

	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;

	@OneToMany(mappedBy = "takeoff")
	private List<Flight> departures;

	@OneToMany(mappedBy = "landing")
	private List<Flight> arrivals;
	
	public Airport(String name, String iata) {
		this.name = name;
		this.iata = iata;
	}
}
