package com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.service;

import com.devsu.challenge.devsu_challenge.contexts.shared.domain.events.DomainEvent;
import com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.utils.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class KafkaEventHandlerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Environment env;

    @Async
    public void publisher(DomainEvent event) {
        kafkaTemplate.send(
                event.getEventName(),
                Objects.requireNonNull(env.getProperty("kafka.producer.key")),
                GenericMapper.serialize(event)
        );
    }
}
