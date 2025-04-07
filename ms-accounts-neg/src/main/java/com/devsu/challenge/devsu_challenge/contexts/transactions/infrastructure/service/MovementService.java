package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.service;

import com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.exceptions.GenericBadRequestException;
import com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.utils.DateUtils;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.movement.create.MovementCreatorUseCase;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.movement.find.MovementsFinderByAccountIdUseCase;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.MovementType;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.error.TransactionError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {
   private final AccountService accountService;
   private final MovementCreatorUseCase movementCreatorUseCase;
   private final MovementsFinderByAccountIdUseCase movementsFinderByAccountIdUseCase;

   public Movement registerMovement(Movement movement) {
      // Validamos la cuenta
      Account account = this.accountService.getAccountById(movement.getAccountId());

      // Si el valor de transacción es positivo aún cuando el movimiento es un retiro, lo convertimos a negativo
      if (MovementType.DEBIT.equals(movement.getType())
            && movement.getValue().compareTo(BigDecimal.ZERO) > 0) {
         movement.setValue(movement.getValue().negate());
      }

      // validamos el nuevo saldo
      BigDecimal previousBalance = account.getBalance();
      BigDecimal newBalance = previousBalance.add(movement.getValue());
      if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
         throw new GenericBadRequestException("<MovementService.registerMovement> insufficient balance",
               TransactionError.builder().insufficientBalance());
      }

      // Guardamos el movimiento
      Movement domain = Movement.builder()
            .movementDate(DateUtils.localDateToString(LocalDateTime.now()))
            .type(movement.getType())
            .value(movement.getValue())
            .balance(newBalance)
            .accountId(movement.getAccountId())
            .build();
      Movement response = this.movementCreatorUseCase.run(domain);

      // Actualizar el nuevo saldo en la cuenta
      this.accountService.updateBalance(domain.getAccountId(), newBalance);
      return response;
   }

   public List<Movement> findMovementsByAccountId(String accountId) {
      return this.movementsFinderByAccountIdUseCase.run(accountId);
   }

   public List<Movement> findMovementsByDateRangeAndClientId(String startDate, String endDate, String clientId) {
      return List.of();
   }
}
