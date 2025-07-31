package br.edu.ifba.internetbanking.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifba.internetbanking.demo.entities.User;
import br.edu.ifba.internetbanking.demo.inputdto.user.UserInputDTO;
import br.edu.ifba.internetbanking.demo.outputdto.user.UserOutputDTO;
import br.edu.ifba.internetbanking.demo.services.UserServices;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    @Operation(summary = "Returns a http.OK + usuario-criado ou badRequest")
    public ResponseEntity<UserOutputDTO> createUser(UserInputDTO userInputDTO) {
       UserOutputDTO createdUser = this.userServices.createUser(userInputDTO);

       if (createdUser != null) {
        return ResponseEntity.ok(createdUser);
       }

       return ResponseEntity.badRequest().build();
    }

}
