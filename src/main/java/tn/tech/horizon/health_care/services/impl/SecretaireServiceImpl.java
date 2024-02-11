package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Secretaire;
import tn.tech.horizon.health_care.entites.User;
import tn.tech.horizon.health_care.repositories.SecretaireRepository;
import tn.tech.horizon.health_care.services.SecretaireService;

@Service
@AllArgsConstructor
public class SecretaireServiceImpl implements SecretaireService {

    private SecretaireRepository secretaireRepository;
    private UserServiceImpl userService;

    @Override
    public Page<Secretaire> getAllSecretaires(String nom, Pageable page) {
        return secretaireRepository.findSecretaireByNomContains(nom, page);
    }

    @Override
    public Secretaire addSecretaire(Secretaire secretaire) {
        User user = User.builder()
                .prenom(secretaire.getPrenom())
                .nom(secretaire.getNom())
                .username(secretaire.getEmail())
                .password("0000")
                .role("secretaire")
                .build();
        userService.addUser(user);
        return secretaireRepository.save(secretaire);
    }

    @Override
    public Secretaire updateSecretaire(Secretaire secretaire) {
        User getUser = userService.getUser(secretaire.getEmail());
        User user = User.builder()
                .idUser(getUser.getIdUser())
                .prenom(secretaire.getPrenom())
                .nom(secretaire.getNom())
                .username(secretaire.getEmail())
                .role("secretaire")
                .password("0000")
                .build();
        userService.addUser(user);
        return secretaireRepository.save(secretaire);
    }

    @Override
    public Secretaire getSecretaire(Long id) {
        return secretaireRepository.findById(id).orElse(null);
    }

    @Override
    public Secretaire getSecretaireByEmail(String email) {
        return secretaireRepository.findSecretaireByEmail(email).orElse(null);
    }

    @Override
    public void deleteSecretaire(Long id) {
        secretaireRepository.deleteById(id);
    }
}
