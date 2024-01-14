package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Secretaire;
import tn.tech.horizon.health_care.repositories.SecretaireRepository;
import tn.tech.horizon.health_care.services.SecretaireService;

@Service
@AllArgsConstructor
public class SecretaireServiceImpl implements SecretaireService {

    private SecretaireRepository secretaireRepository;

    @Override
    public Page<Secretaire> getAllSecretaires(String nom, Pageable page) {
        return secretaireRepository.findSecretaireByNomContains(nom, page);
    }

    @Override
    public Secretaire addSecretaire(Secretaire secretaire) {
        return secretaireRepository.save(secretaire);
    }

    @Override
    public Secretaire updateSecretaire(Secretaire secretaire) {
        return secretaireRepository.save(secretaire);
    }

    @Override
    public Secretaire getSecretaire(Long id) {
        return secretaireRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSecretaire(Long id) {
        secretaireRepository.deleteById(id);
    }
}
