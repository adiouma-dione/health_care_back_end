package tn.tech.horizon.health_care.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.health_care.entites.Secretaire;

@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire, Long> {
    Page<Secretaire> findSecretaireByNomContains(String nom, Pageable page);
}
