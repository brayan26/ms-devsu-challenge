package com.devsu.challenge.contexts.client.domain.events;

import com.devsu.challenge.contexts.shared.domain.events.DomainEvent;
import com.devsu.challenge.contexts.shared.domain.events.EventType;
import lombok.Getter;

import java.util.Date;

@Getter
public class ClientEvent extends DomainEvent {
    //should refer to the event I'm launching
    public static final String EVENT_NAME = "ms.client.neg.client.event";
    private final ClientPayload payload;

    public ClientEvent(String eventId, ClientPayload payload, EventType eventType, Date occurredOn) {
        super(eventId, EVENT_NAME, EventType.CREATED, occurredOn);
        this.payload = payload;
    }
}
