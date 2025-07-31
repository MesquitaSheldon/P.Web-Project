package br.edu.ifba.internetbanking.demo.controllers;

import org.springframework.http.ResponseEntity;

import br.edu.ifba.internetbanking.demo.entities.User;
import br.edu.ifba.internetbanking.demo.inputdto.user.UserInputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.user.UserOutputDTO;
import br.edu.ifba.internetbanking.demo.services.UserServices;

public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    
    public ResponseEntity<UserOutputDTO> createUser(UserInputDTO userInputDTO) {
       UserOutputDTO createdUser = this.userServices.createUser(userInputDTO);

       if (createdUser != null) {
        return ResponseEntity.ok(createdUser);
       }

       return ResponseEntity.badRequest().build();
    }

}
