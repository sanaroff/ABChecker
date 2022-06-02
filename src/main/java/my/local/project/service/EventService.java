package my.local.project.service;

import my.local.project.model.Event;
import my.local.project.repository.EventJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService extends AbstractService<Event, EventJpaRepository> {
    private final EventJpaRepository eventJpaRepository;

    @Autowired
    public EventService(EventJpaRepository eventJpaRepository) {
        this.eventJpaRepository = eventJpaRepository;
    }

    @Override
    public List<Event> findAll() {
        return eventJpaRepository.findAll();
    }

    @Override
    public Event save(Event event) {
        return eventJpaRepository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Event event) {
        eventJpaRepository.delete(event);
    }

    @Override
    public void deleteByID(Long id) {
        eventJpaRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Event> events) {
        eventJpaRepository.deleteAll(events);
    }

    public void getEventsBetweenDates(LocalDateTime start, LocalDateTime finish) {
        eventJpaRepository.findByDateBetween(start, finish);
    }

    public List<Event> findByClient(Long clientId){
        return eventJpaRepository.findByClient(clientId);
    }
}
