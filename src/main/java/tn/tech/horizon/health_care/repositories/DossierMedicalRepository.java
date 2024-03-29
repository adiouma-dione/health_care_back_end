package tn.tech.horizon.health_care.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.health_care.entites.DossierMedical;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    Page<DossierMedical> findDossierMedicalByDateCreationContains(String date, Pageable page);
}
