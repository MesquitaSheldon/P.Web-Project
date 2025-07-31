package br.edu.ifba.internetbanking.demo.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.edu.ifba.internetbanking.demo.entities.Ticket;
import br.edu.ifba.internetbanking.demo.entities.TicketStatus;
import br.edu.ifba.internetbanking.demo.outputdto.ticket.TicketOutputDTO;
import br.edu.ifba.internetbanking.demo.repositories.TicketRepository;

@Service
public class TicketServices {
    private TicketRepository ticketRepository;

    public TicketServices(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public BigDecimal payTicket(String ticketNumber, BigDecimal valueToPay) {
        Ticket ticketToPay = this.ticketRepository.findByTicketNumber(ticketNumber).orElse(null);

        if (ticketToPay != null) {
            BigDecimal beforePaymentTicketValue = ticketToPay.getTicketValue();
            BigDecimal afterPaymentTicketValue = beforePaymentTicketValue.subtract(valueToPay);
            
            TicketStatus ticketStatus = afterPaymentTicketValue.compareTo(new BigDecimal(0)) == 1 ? TicketStatus.PARTIALLY_PAID : TicketStatus.PAID;
            
            ticketToPay.setTicketValue(afterPaymentTicketValue);
            ticketToPay.setTicketStatus(ticketStatus);
            this.ticketRepository.save(ticketToPay);
        }

        return null;
    } 
}
