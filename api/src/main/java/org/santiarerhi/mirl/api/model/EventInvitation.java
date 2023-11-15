package org.santiarerhi.mirl.api.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "event_invitation", schema = "mirl")
@Entity
public class EventInvitation {
    @Id
    @GeneratedValue
    @Column("invitation_id")
    private Long invitationId;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("event_id")
    private Integer eventId;
    @Column("user_id")
    private Long userId;
    @Column("invitation_status")
    private EventInvitationStatus invitationStatus;
    @Column("status_changed_at")
    @Nullable
    private LocalDateTime statusChangedAt;
}
