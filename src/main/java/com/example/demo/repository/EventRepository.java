package com.example.demo.repository;

import com.example.demo.model.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Automatycznie filtruje po polu 'deleted'
    Page<Event> findByDeletedFalse(Pageable pageable);
}