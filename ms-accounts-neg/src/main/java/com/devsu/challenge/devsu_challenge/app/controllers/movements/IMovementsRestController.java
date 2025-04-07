package com.devsu.challenge.devsu_challenge.app.controllers.movements;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movements")
public interface IMovementsRestController {
   @PostMapping(path = "/create", produces = {"application/json"})
   ResponseEntity<Movement> create(@RequestBody Movement movement);

   @GetMapping(path = "/findByAccountId/{accountId}", produces = {"application/json"})
   ResponseEntity<List<Movement>> findByAccountId(@PathVariable String accountId);

   @GetMapping(path = "/report", produces = {"application/json"})
   ResponseEntity<List<Movement>> report(@RequestParam(name = "startDate") String startDate,
                                         @RequestParam(name = "endDate") String endDate,
                                         @RequestParam(name = "clientId") String clientId);
}
