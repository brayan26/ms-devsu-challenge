package com.devsu.challenge.devsu_challenge.app.controllers.accounts;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AccountRestController implements IAccountRestController {
   private final AccountService accountService;

   public AccountRestController(AccountService accountService) {
      this.accountService = accountService;
   }

   @Override
   public ResponseEntity<Account> create(@RequestBody Account account) {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.accountService.createAccount(account));
   }

   @Override
   public ResponseEntity<Account> getById(@PathVariable String id) {
      return ResponseEntity.ok(this.accountService.getAccountById(id));
   }

   @Override
   public ResponseEntity<?> inactive(@PathVariable String id) {
      this.accountService.inactiveAccount(id);
      return ResponseEntity.status(HttpStatus.ACCEPTED).build();
   }
}
