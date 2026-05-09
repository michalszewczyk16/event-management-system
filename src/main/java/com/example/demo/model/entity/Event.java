package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime eventDate;
    private int maxAttendees;
    // To jest Twoja relacja logiczna: każde wydarzenie ma swojego organizatora (Usera)
    private Long organizerId;
}