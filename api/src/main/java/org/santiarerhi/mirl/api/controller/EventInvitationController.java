package org.santiarerhi.mirl.api.controller;

import org.santiarerhi.mirl.api.model.EventInvitation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EventInvitationController {
    @GetMapping("/events/{eventId}/invitations")
    public List<EventInvitation> getEventInvitations(@PathVariable("{eventId}") String eventId) {
        return null; //TODO
    }
    
    @PostMapping("/events/{eventId}/invitations")
    public EventInvitation createEventInvitation(@PathVariable("{eventId}") String eventId) {
        return null; //TODO
    }
    
    @GetMapping("/events/{eventId}/invitations/{invitation_id}")
    public EventInvitation getEventInvitation(@PathVariable("{eventId}") String eventId, @PathVariable("{invitation_id}") String invitationId) {
        return null; //TODO
    }
    
    @PutMapping("/events/{eventId}/invitations/{invitation_id}")
    public EventInvitation updateEventInvitation(@PathVariable("{eventId}") String eventId, @PathVariable("{invitation_id}") String invitationId) {
        return null; //TODO
    }
}
