package br.edu.ifba.internetbanking.demo.outputdto.ticket;

import java.math.BigDecimal;

import br.edu.ifba.internetbanking.demo.entities.Account;
import br.edu.ifba.internetbanking.demo.entities.Ticket;
import br.edu.ifba.internetbanking.demo.inputdto.ticket.TicketInputDTO;

public record TicketOutputDTO(Long ticketId, String ticketNumber, BigDecimal ticketValue, Account ticketAccount) {
    public TicketOutputDTO(Ticket ticket) {
        this(ticket.getTicketId(), ticket.getTicketNumber(), ticket.getTicketValue(), ticket.getTicketAccount());
    }
}
