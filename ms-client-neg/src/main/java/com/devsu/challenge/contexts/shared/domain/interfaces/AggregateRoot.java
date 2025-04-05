package com.devsu.challenge.contexts.shared.domain.interfaces;


import com.devsu.challenge.contexts.shared.domain.events.DomainEvent;

public interface AggregateRoot {
    DomainEvent pullDomainEvent();
}
