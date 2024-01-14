package tn.tech.horizon.demo_keycloak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.demo_keycloak.entites.Consultation;
import tn.tech.horizon.demo_keycloak.entites.DossierMedical;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    @Query("SELECT c FROM Consultation c WHERE c.dossierMedical.idDossierMedical = ?1 order by c.date desc")
    Page<Consultation> findConsultationByDateAndIdDossier(Long idDossier, Pageable pageable);

}
