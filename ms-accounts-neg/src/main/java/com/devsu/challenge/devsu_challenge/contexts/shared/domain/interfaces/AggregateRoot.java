package com.devsu.challenge.devsu_challenge.contexts.shared.domain.interfaces;

import com.devsu.challenge.devsu_challenge.contexts.shared.domain.events.DomainEvent;

public interface AggregateRoot {
    DomainEvent pullDomainEvent();
}
