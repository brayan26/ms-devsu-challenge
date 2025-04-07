package com.devsu.challenge.devsu_challenge.app.controllers.movements;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.service.MovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MovementRestController implements IMovementsRestController {
   private final MovementService service;

   public MovementRestController(MovementService service) {
      this.service = service;
   }

   @Override
   public ResponseEntity<Movement> create(@RequestBody Movement movement) {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.registerMovement(movement));
   }

   @Override
   public ResponseEntity<List<Movement>> findByAccountId(@PathVariable String accountId) {
      return ResponseEntity.ok(this.service.findMovementsByAccountId(accountId));
   }

   @Override
   public ResponseEntity<List<Movement>> report(@RequestParam(name = "startDate") String startDate,
                                                @RequestParam(name = "endDate") String endDate,
                                                @RequestParam(name = "clientId") String clientId) {
      return ResponseEntity.ok(this.service.findMovementsByDateRangeAndClientId(startDate, endDate, clientId));
   }
}
