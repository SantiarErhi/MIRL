package org.santiarerhi.mirl.api.controller;

import com.google.common.collect.Lists;
import org.santiarerhi.mirl.api.model.Event;
import org.santiarerhi.mirl.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class EventController {
    private final EventRepository eventRepository;
    
    EventController(@Autowired EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam Integer page,
                                 @RequestParam(required = false) String radius,
                                 @RequestParam(required = false) Boolean owned,
                                 @RequestParam(required = false) Boolean subscribed
    ) {
        return Lists.newArrayList(eventRepository.findAll());
    }
    
    @GetMapping("/events/recommended")
    public List<Event> getRecomendedEvents(@RequestParam Integer page) {
        return Lists.newArrayList(eventRepository.findAll());
    }
    
    @PostMapping("/events")
    public Event getEvents(@RequestBody Event event) {
        return eventRepository.save(event);
    }
    
    @GetMapping("/events/{eventId}")
    public Optional<Event> getEvent(@PathVariable("{eventId}") Long eventId) {
        return eventRepository.findById(eventId);
    }
    
    @PutMapping("/events/{eventId}")
    public Event updateEvent(@PathVariable("{eventId}") Long eventId, @RequestBody Event event) {
        event.setId(eventId);
        return eventRepository.save(event);
    }
}
