package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.User;
import tn.tech.horizon.health_care.repositories.UserRepository;
import tn.tech.horizon.health_care.services.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long idUser) {
        userRepository.deleteById(idUser);
    }
    @Override
    public String deleteUser(String username) {
        try {
            userRepository.deleteByUsername(username);
            return "Utilisateur supprimé";
        } catch (Exception e) {
            return String.format("Erreur lors de la suppression, %s", e);
        }
    }
}
