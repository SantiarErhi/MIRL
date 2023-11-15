package org.santiarerhi.mirl.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "event", schema = "mirl")
@Entity
@Data
public class Event {
    @Column("event_id")
    @Id
    @GeneratedValue
    private Long id;
    @Column("event_name")
    private String eventName;
    @Column("event_type")
    private EventType eventType;
    @Column("start_datetime")
    private LocalDateTime startDateTime;
    @Column("end_datetime")
    private LocalDateTime endDateTime;
    @Column("geolocation")
    private Point geolocation;
    @Column("photos")
    private List<String> photos;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("user_limit")
    private Integer userLimit;
    @Column("owner_id")
    private String ownerId;
    @Column("edited_at")
    private LocalDateTime editedAt;
    @Column("address")
    private String address;
}
