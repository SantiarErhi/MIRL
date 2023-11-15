package org.santiarerhi.mirl.api.controller;

import org.santiarerhi.mirl.api.model.EventParticipationRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EventRequestController {
    @GetMapping("/events/{eventId}/requests")
    public List<EventParticipationRequest> getEventParticipationRequests(@PathVariable("{eventId}") String eventId) {
        return null; //TODO
    }
}
