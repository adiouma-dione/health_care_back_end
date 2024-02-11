package tn.tech.horizon.health_care.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.health_care.entites.User;
import tn.tech.horizon.health_care.repositories.UserRepository;
import tn.tech.horizon.health_care.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class UserRestController {

    private UserServiceImpl userService;
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUsers(String username, int page, int size) {
        return ResponseEntity.ok(userRepository.findUsersByUsernameContains(username, PageRequest.of(page, size)));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping("/user/delete/{idUser}")
    public void deleteUser(@PathVariable Long idUser) {
        userService.deleteUserById(idUser);
    }
}
