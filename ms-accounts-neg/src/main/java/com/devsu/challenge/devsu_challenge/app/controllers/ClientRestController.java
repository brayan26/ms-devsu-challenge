package com.devsu.challenge.app.controllers;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.infrastructure.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/client")
public class ClientRestController {
   private final ClientService service;

   public ClientRestController(ClientService service) {
      this.service = service;
   }

   @PostMapping(path = "/save", consumes = {"application/json"}, produces = {"application/json"})
   public ResponseEntity<?> save(@RequestBody Client client) {
      return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(client));
   }

   @PatchMapping(path = "/update/{id}", consumes = {"application/json"}, produces = {"application/json"})
   public ResponseEntity<?> update(@RequestBody Client client, @PathVariable String id) {
      return ResponseEntity.ok(service.updateUser(client, id));
   }

   @GetMapping(path = "/get/{clientId}", produces = {"application/json"})
   public ResponseEntity<?> getClient(@PathVariable String clientId) {
      return ResponseEntity.ok(service.findById(clientId));
   }

   @GetMapping(path = "/findAll", produces = {"application/json"})
   public ResponseEntity<?> findAllClients() {
      return ResponseEntity.ok(service.findAllClients());
   }

   @DeleteMapping(path = "/delete/{id}", produces = {"application/json"})
   public ResponseEntity<?> delete(@PathVariable String id) {
      service.delete(id);
      return ResponseEntity.accepted().build();
   }
}
