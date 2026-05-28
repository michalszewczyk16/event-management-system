package com.example.demo.service;

import com.example.demo.exception.DomainException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Ta adnotacja rejestruje klasę w kontenerze IoC (Dependency Injection)
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private long currentId = 1;

    public List<Event> getAllEvents() {
        return events;
    }

    public Event getEventById(Long id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Wydarzenie o ID " + id + " nie istnieje."));
    }

    public Event createEvent(Event event) {
        // REGUŁA BIZNESOWA 1: Nie można stworzyć wydarzenia dla więcej niż 10 000 osób (np. ze względów bezpieczeństwa).
        if (event.getMaxParticipants() > 10000) {
            throw new DomainException("Maksymalna liczba uczestników to 10 000 ze względów bezpieczeństwa.");
        }

        event.setId(currentId++);
        events.add(event);
        return event;
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = getEventById(id);

        existingEvent.setName(updatedEvent.getName());
        existingEvent.setDateTime(updatedEvent.getDateTime());
        existingEvent.setMaxParticipants(updatedEvent.getMaxParticipants());

        return existingEvent;
    }

    public void deleteEvent(Long id) {
        Event existingEvent = getEventById(id);

        // REGUŁA BIZNESOWA 2: Nie można usunąć wydarzenia, jeśli do jego rozpoczęcia zostało mniej niż 24 godziny.
        if (existingEvent.getDateTime().isBefore(LocalDateTime.now().plusHours(24))) {
            throw new DomainException("Nie można anulować wydarzenia na mniej niż 24 godziny przed rozpoczęciem!");
        }

        events.remove(existingEvent);
    }
}