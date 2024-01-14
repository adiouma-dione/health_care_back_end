package tn.tech.horizon.demo_keycloak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.demo_keycloak.entites.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Page<Medecin> findMedecinByNomContains(String nom, Pageable page);
}
