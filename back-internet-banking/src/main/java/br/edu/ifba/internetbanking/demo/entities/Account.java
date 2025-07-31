package br.edu.ifba.internetbanking.demo.entities;

import java.math.BigDecimal;

import br.edu.ifba.internetbanking.demo.inputdto.account.AccountInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Size(min=8, max=8)
    @Column(unique = true)
    private String accountNumber;
    @Size(min=4, max=4)
    private String accountBankBranchNumber;
    
    private BigDecimal accountBalance;

    public Account() {
        
    }

    public Account(AccountInputDTO accountInputDTO) {
        this.accountNumber = accountInputDTO.accountNumber();
        this.accountBankBranchNumber = accountInputDTO.accountBankBranchNumber();
        this.accountBalance = new BigDecimal(0);
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountBankBranchNumber() {
        return this.accountBankBranchNumber;
    }

    public void setAccountBankBranchNumber(String accountBankBranchNumber) {
        this.accountBankBranchNumber = accountBankBranchNumber;
    }

    public BigDecimal getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Account orElse(Object object) {
        // TODO Auto-generated method stub
        return null;
    }
    

}
