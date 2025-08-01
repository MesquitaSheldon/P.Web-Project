    package br.edu.ifba.internetbanking.demo.controllers;

    import io.swagger.v3.oas.annotations.Operation;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;

    import br.edu.ifba.internetbanking.demo.inputdto.user.UserInputDTO;
    import br.edu.ifba.internetbanking.demo.outputdto.user.UserOutputDTO;
    import br.edu.ifba.internetbanking.demo.services.UserServices;

    @RestController
    @RequestMapping("/api/user")
    public class UserController {

        private UserServices userServices;

        public UserController(UserServices userServices) {
            this.userServices = userServices;
        }

        @PostMapping
        @Operation(summary = "Returns a http.OK + usuario-criado ou badRequest")
        public ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO userInputDTO) {
           UserOutputDTO createdUser = this.userServices.createUser(userInputDTO);

           if (createdUser != null) {
            return ResponseEntity.ok(createdUser);
           }

           return ResponseEntity.badRequest().build();
        }

        @GetMapping
        @Operation(summary = "Retorna os dados do usuário sheldon")
        public ResponseEntity<UserOutputDTO> getUser(){
            return ResponseEntity.ok(new UserOutputDTO(1L,"123.123.123-12","sheldon","sheldon@email.com","123"));
        }

    }
