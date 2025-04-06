package com.devsu.challenge.devsu_challenge.contexts.shared.domain.events;

import lombok.Data;

import java.util.Date;

@Data
public abstract class DomainEvent {
    private final String eventId;
    private final String eventName;
    private final EventType eventType;
    private final Date occurredOn;

    public DomainEvent(String eventId, String eventName, EventType eventType, Date occurredOn) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.occurredOn = occurredOn;
    }
}
