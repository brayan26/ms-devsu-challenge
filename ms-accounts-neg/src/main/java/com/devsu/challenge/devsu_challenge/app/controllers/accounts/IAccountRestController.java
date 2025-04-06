package com.devsu.challenge.devsu_challenge.app.controllers.accounts;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
public interface IAccountRestController {
   @PostMapping(path = "/create", produces = {"application/json"})
   ResponseEntity<Account> create(@RequestBody Account account);

   @GetMapping(path = "/get/{id}", produces = {"application/json"})
   ResponseEntity<Account> getById(@PathVariable String id);

   @GetMapping(path = "/inactive/{id}", produces = {"application/json"})
   ResponseEntity<?> inactive(@PathVariable String id);
}
