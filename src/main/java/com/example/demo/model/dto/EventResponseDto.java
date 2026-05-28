package com.example.demo.model.dto;

import java.time.LocalDateTime;

public class EventResponseDto {
    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private int maxParticipants;

    // Konstruktor bezargumentowy
    public EventResponseDto() {
    }

    // Konstruktor pełny
    public EventResponseDto(Long id, String name, LocalDateTime dateTime, int maxParticipants) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.maxParticipants = maxParticipants;
    }

    // Gettery i Settery
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
