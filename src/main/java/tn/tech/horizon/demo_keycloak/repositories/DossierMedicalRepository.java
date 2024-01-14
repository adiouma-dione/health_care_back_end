package tn.tech.horizon.demo_keycloak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.demo_keycloak.entites.DossierMedical;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    Page<DossierMedical> findDossierMedicalByDateCreationContains(String date, Pageable page);
}
