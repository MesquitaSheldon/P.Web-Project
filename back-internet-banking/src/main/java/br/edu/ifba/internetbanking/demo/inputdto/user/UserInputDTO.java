package br.edu.ifba.internetbanking.demo.inputdto.user;

public record UserInputDTO(String userCPF, String userName, String userEmail, String userPassword) {
    public UserInputDTO(String userCPF, String userName, String userEmail, String userPassword) {
        this.userCPF = userCPF;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }   
}
