package br.edu.ifba.internetbanking.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifba.internetbanking.demo.entities.BankTransaction;
import br.edu.ifba.internetbanking.demo.inputdto.banktransaction.BankTransactionInputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.banktransaction.BankTransactionOutputDTO;
import br.edu.ifba.internetbanking.demo.repositories.BankTransactionRepository;

@Service
public class BankTransactionService {
    private BankTransactionRepository bankTransactionRepository;

    public BankTransactionService(BankTransactionRepository bankTransactionRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
    }

    public BankTransactionOutputDTO createTransaction(BankTransactionInputDTO bankTransactionInputDTO) {
        return new BankTransactionOutputDTO(this.bankTransactionRepository.save(new BankTransaction(bankTransactionInputDTO)));
    }

    public List<BankTransactionOutputDTO> listBankTransactionsByAccountNumber(String accountNumber) {
        return this.bankTransactionRepository.findByAccountNumber(accountNumber).stream().map(BankTransactionOutputDTO::new).toList();
    }
}
