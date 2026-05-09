package com.example.demo.controller; // Dopasowane do Twojego screena

import com.example.demo.model.entity.Event;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    // Nasza lista w pamięci RAM [cite: 10]
    private List<Event> events = new ArrayList<>();

    public EventController() {
        // Dodajemy startowe dane, żebyś od razu widział coś w przeglądarce
        events.add(new Event(1L, "Koncert", "Muzyka na żywo", LocalDateTime.now().plusDays(5), 50, 1L));
    }

    // Endpoint GET (all) - lista wszystkich wydarzeń [cite: 9]
    @GetMapping
    public List<Event> getAllEvents() {
        return events;
    }

    // Endpoint GET (id) - pobieranie po ID [cite: 9]
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Endpoint POST - dodawanie nowego wydarzenia [cite: 9, 114]
    @PostMapping
    public Event createEvent(@RequestBody Event newEvent) {
        events.add(newEvent);
        return newEvent;
    }
}