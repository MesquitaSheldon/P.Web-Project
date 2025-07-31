package br.edu.ifba.internetbanking.demo.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifba.internetbanking.demo.entities.Account;
import br.edu.ifba.internetbanking.demo.inputdto.account.AccountInputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.account.AccountOutputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.banktransaction.BankTransactionOutputDTO;
import br.edu.ifba.internetbanking.demo.repositories.AccountRepository;
import br.edu.ifba.internetbanking.demo.services.AccountServices;
import br.edu.ifba.internetbanking.demo.services.BankTransactionService;
import br.edu.ifba.internetbanking.demo.services.TicketServices;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/api/account")
public class AccountController {

    private AccountServices accountServices;
    
    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AccountOutputDTO> createAccount(@RequestBody AccountInputDTO accountInputDTO) {
        AccountOutputDTO createdAccount = this.accountServices.createAccount(accountInputDTO);

        if (createdAccount != null) {
            return ResponseEntity.ok(createdAccount);
        }

        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<BigDecimal> accountWithdraw(String accountNumber, BigDecimal withdrawValue) {
        BigDecimal accountNewValue = accountServices.accountWithdraw(accountNumber, withdrawValue);

        if (accountNewValue != null) {
            return ResponseEntity.ok(accountNewValue);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BigDecimal> accountDeposit(String accountNumber, BigDecimal depositValue) {
        BigDecimal accountNewValue = accountServices.accountWithdraw(accountNumber, depositValue);

        if (accountNewValue != null) {
            return ResponseEntity.ok(accountNewValue);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BigDecimal> accountTicketPayment(String ticketNumber, BigDecimal valueToPay) {
        BigDecimal paidValue = accountServices.accountTicketPayment(ticketNumber, valueToPay);

        if (paidValue != null) {
            return ResponseEntity.ok(paidValue);
        }

        return ResponseEntity.notFound().build();
    }

    public List<BankTransactionOutputDTO> listTransactionsByAccountNumber(String accountNumber) {
        return this.accountServices.listTransactionsByAccountNumber(accountNumber);
    }
}
