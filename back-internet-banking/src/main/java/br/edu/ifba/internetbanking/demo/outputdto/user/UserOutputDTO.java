package br.edu.ifba.internetbanking.demo.outputdto.user;

import br.edu.ifba.internetbanking.demo.entities.User;

public record UserOutputDTO(Long userId, String userCPF, String userName, String userEmail, String userPassword) {
    public UserOutputDTO(User user) {
        this(user.getUserId(), user.getUserCPF(), user.getUserName(), user.getUserEmail(), user.getUserPassword());
    }
}
