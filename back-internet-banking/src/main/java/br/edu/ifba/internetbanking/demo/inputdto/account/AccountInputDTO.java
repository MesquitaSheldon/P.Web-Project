package br.edu.ifba.internetbanking.demo.inputdto.account;

import java.math.BigDecimal;

public record AccountInputDTO(String accountNumber, String accountBankBranchNumber, BigDecimal accountBalance) {
    public AccountInputDTO(String accountNumber, String accountBankBranchNumber, BigDecimal accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBankBranchNumber = accountBankBranchNumber; 
        this.accountBalance = accountBalance;
    }
}
