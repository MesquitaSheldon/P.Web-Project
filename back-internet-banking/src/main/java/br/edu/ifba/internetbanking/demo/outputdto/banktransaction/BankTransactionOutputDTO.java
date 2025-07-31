package br.edu.ifba.internetbanking.demo.outputdto.banktransaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ifba.internetbanking.demo.entities.BankTransaction;
import br.edu.ifba.internetbanking.demo.entities.BankTransactionType;

public record BankTransactionOutputDTO(Long bankTransctionId, BankTransactionType bankTransactionType, LocalDate bankTransactionDate, LocalTime bankTransactionTime, BigDecimal bankTransactionValue) {
    public BankTransactionOutputDTO(BankTransaction bankTransaction) {
        this(bankTransaction.getBankTransactionId(), bankTransaction.getBankTransactionType(), bankTransaction.getBankTransactionDate(), bankTransaction.getBankTransactionTime(), bankTransaction.getBankTransactionValue());
    }
}
