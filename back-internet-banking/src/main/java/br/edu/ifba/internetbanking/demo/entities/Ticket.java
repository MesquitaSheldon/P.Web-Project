package br.edu.ifba.internetbanking.demo.entities;

import java.math.BigDecimal;

import br.edu.ifba.internetbanking.demo.inputdto.ticket.TicketInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    @Size(min = 10, max=10)
    @NotBlank
    @Column(unique = true)
    private String ticketNumber;
    private BigDecimal ticketValue;
    @ManyToOne
    private Account ticketAccount; 
    private TicketStatus ticketStatus;

    public Ticket() {

    }

    public Ticket(TicketInputDTO ticketInputDTO) {
        this.ticketNumber = ticketInputDTO.ticketNumber();
        this.ticketValue = ticketInputDTO.ticketValue();
        this.ticketAccount = ticketInputDTO.ticketAccount();
        this.ticketStatus = TicketStatus.UNPAID;
    }

    public Long getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketValue(BigDecimal ticketValue) {
        this.ticketValue = ticketValue;
    }

    public BigDecimal getTicketValue() {
        return this.ticketValue;
    }

    public void setTicketAccount(Account ticketAccount) {
        this.ticketAccount = ticketAccount;
    }

    public Account getTicketAccount() {
        return this.ticketAccount;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus; 
    }

    public TicketStatus getTicketStatus() {
        return this.ticketStatus;
    }

    public Ticket orElse(Object object) {
        // TODO Auto-generated method stub
        return null;
    }
}
