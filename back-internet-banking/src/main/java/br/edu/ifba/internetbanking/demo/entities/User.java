package br.edu.ifba.internetbanking.demo.entities;

import org.hibernate.validator.constraints.br.CPF;

import br.edu.ifba.internetbanking.demo.inputdto.user.UserInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @CPF
    @Column(unique = true)
    private String userCPF;
    private String userName;
    private String userEmail;
    @Size(min=8)
    private String userPassword;

    public User() {
        
    }

    public User(UserInputDTO userInputDTO) {
        this.userCPF = userInputDTO.userCPF();
        this.userName = userInputDTO.userName();
        this.userEmail = userInputDTO.userEmail();
        this.userPassword = userInputDTO.userPassword();
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserCPF() {
        return this.userCPF;
    }

    public void setUserCPF(String userCPF) {
        this.userCPF = userCPF;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
}
