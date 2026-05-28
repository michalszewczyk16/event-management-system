package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        // Walidacja biznesowa
        if (event.getMaxParticipants() > 10000) {
            throw new IllegalArgumentException("Maksymalna liczba uczestników to 10 000.");
        }
        return eventRepository.save(event);
    }

    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findByDeletedFalse(pageable);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .filter(event -> !event.isDeleted())
                .orElseThrow(() -> new ResourceNotFoundException("Wydarzenie nie istnieje."));
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setName(eventDetails.getName());
        event.setDateTime(eventDetails.getDateTime());
        event.setMaxParticipants(eventDetails.getMaxParticipants());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        event.setDeleted(true);
        eventRepository.save(event);
    }
}
