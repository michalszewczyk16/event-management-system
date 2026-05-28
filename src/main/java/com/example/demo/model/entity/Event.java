package com.example.demo.model.entity;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class Event {
    private Long id;

    @NotBlank(message = "Nazwa wydarzenia nie może być pusta")
    private String name;

    @Future(message = "Data wydarzenia musi być w przyszłości")
    private LocalDateTime dateTime;

    @Min(value = 1, message = "Wydarzenie musi mieć co najmniej 1 miejsce")
    private int maxParticipants;

    // Standardowy konstruktor bezargumentowy
    public Event() {
    }

    // Standardowy konstruktor pełny
    public Event(Long id, String name, LocalDateTime dateTime, int maxParticipants) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.maxParticipants = maxParticipants;
    }

    // Klasyczne Gettery i Settery (zamiast Lomboka)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
