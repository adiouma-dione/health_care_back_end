package tn.tech.horizon.demo_keycloak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.demo_keycloak.entites.Secretaire;

@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire, Long> {
    Page<Secretaire> findSecretaireByNomContains(String nom, Pageable page);
}
