package hu.webuni.airport.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.airport.model.Airport;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long>{
	Long countByIata(String iata);
	Long countByIataAndIdNot(String iata, long id);

	@EntityGraph(attributePaths = {"address", "departures"})
	@Query("SELECT a FROM Airport a")
	//@Query("SELECT a FROM Airport a LEFT JOIN FETCH a.address")
	List<Airport> findByAllWithAddressAndDepartures(Pageable pageable);

	@EntityGraph(attributePaths = {"arrivals"})
	@Query("SELECT a FROM Airport a")
	List<Airport> findByAllWithArrivals(Pageable pageable);

	@EntityGraph(attributePaths = {"address"})
	@Query("SELECT a FROM Airport a")
	List<Airport> findByAllWithAddress(Pageable pageable);

	@EntityGraph(attributePaths = {"arrivals"})
	@Query("SELECT a FROM Airport a WHERE a.id IN :ids")
	List<Airport> findByIdWithArrivals(List<Long> ids);

	@EntityGraph(attributePaths = {"departures"})
	@Query("SELECT a FROM Airport a WHERE a.id IN :ids")
	List<Airport> findByIdWithDepartures(List<Long> ids);
}
