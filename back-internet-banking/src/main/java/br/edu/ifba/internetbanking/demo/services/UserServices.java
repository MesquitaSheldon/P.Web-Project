package br.edu.ifba.internetbanking.demo.services;

import org.springframework.stereotype.Service;

import br.edu.ifba.internetbanking.demo.entities.User;
import br.edu.ifba.internetbanking.demo.inputdto.user.UserInputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.user.UserOutputDTO;
import br.edu.ifba.internetbanking.demo.repositories.UserRepository;

@Service
public class UserServices {
    private UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserOutputDTO createUser(UserInputDTO userInputDTO) {
        return new UserOutputDTO(this.userRepository.save(new User(userInputDTO)));
    }
}
