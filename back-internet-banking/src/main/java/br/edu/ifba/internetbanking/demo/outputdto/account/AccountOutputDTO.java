package br.edu.ifba.internetbanking.demo.outputdto.account;

import java.math.BigDecimal;

import br.edu.ifba.internetbanking.demo.entities.Account;

public record AccountOutputDTO(Long accountId, String accountNumber, String accountBankBranchNumber, BigDecimal accountBalance) {
    public AccountOutputDTO(Account account) {
        this(account.getAccountId(), account.getAccountNumber(), account.getAccountBankBranchNumber(), account.getAccountBalance());
    }
}
