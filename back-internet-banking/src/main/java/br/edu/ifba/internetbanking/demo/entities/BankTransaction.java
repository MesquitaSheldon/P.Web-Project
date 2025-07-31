package br.edu.ifba.internetbanking.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ifba.internetbanking.demo.inputdto.banktransaction.BankTransactionInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="bank_transactions")
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankTransactionId;
    
    private BankTransactionType bankTransactionType;
    private LocalDate bankTransactionDate;
    private LocalTime bankTransactionTime;
    private BigDecimal bankTransactionValue;
    
    @ManyToOne
    private Account bankTransactionAccount;

    public BankTransaction() {

    }

    public BankTransaction(BankTransactionInputDTO bankTransactionInputDTO) {
        this.bankTransactionType = bankTransactionInputDTO.bankTransactionType();
        this.bankTransactionDate = bankTransactionInputDTO.bankTransactionDate();
        this.bankTransactionTime = bankTransactionInputDTO.bankTransactionTime();
        this.bankTransactionValue = bankTransactionInputDTO.bankTransactionValue();

    }

    public Long getBankTransactionId() {
        return this.bankTransactionId;
    }

    public void setBankTransactionId(Long bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public BankTransactionType getBankTransactionType() {
        return this.bankTransactionType;
    }

    public void setBankTransaction(BankTransactionType bankTransactionType) {
        this.bankTransactionType = bankTransactionType;
    }

    public LocalDate getBankTransactionDate() {
        return this.bankTransactionDate;
    }

    public void setBankTransaction(LocalDate bankTransactionDate) {
        this.bankTransactionDate = bankTransactionDate;
    }

    public LocalTime getBankTransactionTime() {
        return this.bankTransactionTime;
    }

    public void setBankTransactionTime(LocalTime bankTransactionTime) {
        this.bankTransactionTime = bankTransactionTime;
    }

    public BigDecimal getBankTransactionValue() {
        return this.bankTransactionValue;
    }

    public void setBankTransactionValue(BigDecimal bankTransactionValue) {
        this.bankTransactionValue = bankTransactionValue;
    }

    public Account getBankTransactionAccount() {
        return this.bankTransactionAccount;
    }

    public void setBankTransactionAccount(Account bankTransactionAccount) {
        this.bankTransactionAccount = bankTransactionAccount;
    }
}
