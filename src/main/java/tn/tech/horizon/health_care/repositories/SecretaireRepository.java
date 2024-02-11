package tn.tech.horizon.health_care.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.health_care.entites.Medecin;
import tn.tech.horizon.health_care.entites.Secretaire;

import java.util.Optional;

@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire, Long> {
    Page<Secretaire> findSecretaireByNomContains(String nom, Pageable page);
    Optional<Secretaire> findSecretaireByEmail(String email);
}
