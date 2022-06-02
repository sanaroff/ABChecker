package my.local.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import my.local.project.model.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public
interface EventJpaRepository extends JpaRepository<Event, Long> {
	@Query("select b from Event b where b.start >= ?1 and b.finish <= ?2")
	List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);

	@Query("select b from Event b, Client c where b.clientId = c.ID")
	List<Event> findByClient(Long clientId);
	
}