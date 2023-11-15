package org.santiarerhi.mirl.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "event_participation_request", schema = "mirl")
@Entity
public class EventParticipationRequest {
    @Id
    @GeneratedValue
    @Column("invitation_id")
    private Long id;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("event_id")
    private Long eventId;
    @Column("user_id")
    private Long userId;
    @Column("request_status")
    private EventParticipationRequestStatus participationRequestStatus;
    @Column("status_changed_at")
    private LocalDateTime statusChangedAt;
}
