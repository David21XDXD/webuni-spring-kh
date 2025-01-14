package hu.webuni.airport.service;

import java.time.LocalDateTime;

import hu.webuni.airport.model.Address;
import hu.webuni.airport.repository.AddressRepository;
import hu.webuni.airport.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.airport.model.Airport;
import hu.webuni.airport.model.Flight;
import hu.webuni.airport.repository.AirportRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InitDbService {

	private final AirportRepository airportRepository;
	private final FlightService flightService;
	private final AddressRepository addressRepository;
	private final FlightRepository flightRepository;

	@Transactional
	public void deleteDb() {
		flightRepository.deleteAll();
		airportRepository.deleteAll();
		addressRepository.deleteAll();
	}


	@Transactional
	public void addInitData() {
		Address address1 = addressRepository.save(Address.builder().city("Budapest").build());
		Address address2 = addressRepository.save(Address.builder().city("Los Angeles").build());
		Address address3 = addressRepository.save(Address.builder().city("New York").build());
		Address address4 = addressRepository.save(Address.builder().city("London").build());

		Airport airport1 = airportRepository.save(new Airport("airport1", "BUD"));
		airport1.setAddress(address1);
		Airport airport2 = airportRepository.save(new Airport("airport2", "LAX"));
		airport2.setAddress(address2);
		Airport airport3 = airportRepository.save(new Airport("airport3", "JFK"));
		airport3.setAddress(address3);
		Airport airport4 = airportRepository.save(new Airport("airport4", "LGW"));
		airport4.setAddress(address4);
		
		flightService.save(new Flight(0, "ABC123", LocalDateTime.of(2022, 6, 10, 10, 10), airport1, airport2));
		flightService.save(new Flight(0, "ABC456", LocalDateTime.of(2022, 6, 10, 12, 10), airport2, airport3));
		flightService.save(new Flight(0, "DEF234", LocalDateTime.of(2022, 6, 12, 14, 10), airport2, airport4));
		flightService.save(new Flight(0, "GHI345", LocalDateTime.of(2022, 6, 13, 16, 10), airport4, airport1));
	}
}
