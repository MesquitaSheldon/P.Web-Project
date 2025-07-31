package br.edu.ifba.internetbanking.demo.inputdto.banktransaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ifba.internetbanking.demo.entities.Account;
import br.edu.ifba.internetbanking.demo.entities.BankTransactionType;

public record BankTransactionInputDTO(BankTransactionType bankTransactionType, LocalDate bankTransactionDate, LocalTime bankTransactionTime, BigDecimal bankTransactionValue, Account bankTransactionAccount) {
    public BankTransactionInputDTO(BankTransactionType bankTransactionType, LocalDate bankTransactionDate, LocalTime bankTransactionTime, BigDecimal bankTransactionValue, Account bankTransactionAccount) {
        this.bankTransactionType = bankTransactionType;
        this.bankTransactionDate = bankTransactionDate;
        this.bankTransactionTime = bankTransactionTime;
        this.bankTransactionValue = bankTransactionValue;
        this.bankTransactionAccount = bankTransactionAccount;
    }
} 
