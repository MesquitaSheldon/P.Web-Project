package br.edu.ifba.internetbanking.demo.inputdto.ticket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ifba.internetbanking.demo.entities.Account;
import br.edu.ifba.internetbanking.demo.entities.BankTransactionType;

public record TicketInputDTO(String ticketNumber, BigDecimal ticketValue, Account ticketAccount) {
        public TicketInputDTO(String ticketNumber, BigDecimal ticketValue, Account ticketAccount) {
        this.ticketNumber = ticketNumber;
        this.ticketValue = ticketValue;
        this.ticketAccount = ticketAccount;
    }
}