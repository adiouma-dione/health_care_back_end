package tn.tech.horizon.health_care.services;

import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.User;

@Service
public interface UserService {
    User getUser(String username);
    User addUser(User user);
    User updateUser(User user);

    void deleteUserById(Long idUser);

    String deleteUser(String username);
}
