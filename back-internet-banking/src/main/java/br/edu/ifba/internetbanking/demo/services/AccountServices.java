package br.edu.ifba.internetbanking.demo.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifba.internetbanking.demo.entities.Account;
import br.edu.ifba.internetbanking.demo.inputdto.account.AccountInputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.account.AccountOutputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.banktransaction.BankTransactionOutputDTO;
import br.edu.ifba.internetbanking.demo.repositories.AccountRepository;

@Service
public class AccountServices {

    private AccountRepository accountRepository;
    private BankTransactionService bankTransactionService;
    private TicketServices ticketServices;

    public AccountServices(AccountRepository accountRepository, BankTransactionService bankTransactionService, TicketServices ticketServices) {
        this.accountRepository = accountRepository;
        this.bankTransactionService = bankTransactionService;
        this.ticketServices = ticketServices;
    }

    public AccountOutputDTO createAccount(AccountInputDTO accountInputDTO) {
        return new AccountOutputDTO(this.accountRepository.save(new Account(accountInputDTO)));
    }

    public BigDecimal accountWithdraw(String accountNumber, BigDecimal withdrawValue) {
        Account accountToWithdraw = this.accountRepository.findByAccountNumber(accountNumber).orElse(null); 

        if (accountToWithdraw != null) {
            BigDecimal newAccountBalance = accountToWithdraw.getAccountBalance().subtract(withdrawValue);
            accountToWithdraw.setAccountBalance(newAccountBalance);
            this.accountRepository.save(accountToWithdraw);
            return newAccountBalance;
        }

        return null;
    }

    public BigDecimal accountDeposit(String accountNumber, BigDecimal depositValue) {
        Account accountToWithdraw = this.accountRepository.findByAccountNumber(accountNumber).orElse(null); 

        if (accountToWithdraw != null) {
            BigDecimal newAccountBalance = accountToWithdraw.getAccountBalance().add(depositValue);
            accountToWithdraw.setAccountBalance(newAccountBalance);
            this.accountRepository.save(accountToWithdraw);
            return newAccountBalance;
        }

        return null;
    }

    public BigDecimal accountTicketPayment(String ticketNumber, BigDecimal valueToPay) {
        return this.ticketServices.payTicket(ticketNumber, valueToPay);
    }

    public List<BankTransactionOutputDTO> listTransactionsByAccountNumber(String accountNumber) {
        return this.bankTransactionService.listBankTransactionsByAccountNumber(accountNumber);
    }
}
