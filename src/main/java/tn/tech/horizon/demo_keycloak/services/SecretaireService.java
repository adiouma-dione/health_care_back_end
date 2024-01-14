package tn.tech.horizon.demo_keycloak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.Secretaire;

@Service
public interface SecretaireService {
    Page<Secretaire> getAllSecretaires(String nom, Pageable page);
    Secretaire addSecretaire(Secretaire secretaire);
    Secretaire updateSecretaire(Secretaire secretaire);
    Secretaire getSecretaire(Long id);
    void deleteSecretaire(Long id);
}
