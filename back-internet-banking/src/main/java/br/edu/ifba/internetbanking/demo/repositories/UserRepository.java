package br.edu.ifba.internetbanking.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.internetbanking.demo.entities.User;

@Repository("users")
public interface UserRepository extends JpaRepository<User, Long> {
    
}
