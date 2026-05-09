package com.projekt.eventsystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // To generuje gettery i settery automatycznie
@NoArgsConstructor // Pusty konstruktor
@AllArgsConstructor // Konstruktor ze wszystkimi polami
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}