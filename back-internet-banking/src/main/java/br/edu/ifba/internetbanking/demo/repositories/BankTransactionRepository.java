package br.edu.ifba.internetbanking.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifba.internetbanking.demo.entities.BankTransaction;

@Repository("bank_transactions")
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
    @Query("SELECT t FROM bank_transactions t WHERE t.bankTransactionAccount.accountNumber = :accountNumber")
    List<BankTransaction> findByAccountNumber(String accountNumber);
}
