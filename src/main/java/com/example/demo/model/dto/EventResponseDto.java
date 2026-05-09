package com.example.demo.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventResponseDto {
    private String title;
    private LocalDateTime eventDate;
    private int maxAttendees;
}