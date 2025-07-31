package br.edu.ifba.internetbanking.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.internetbanking.demo.entities.Ticket;

@Repository("tickets")
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    Ticket findByTicketNumber(String ticketNumber);
}
