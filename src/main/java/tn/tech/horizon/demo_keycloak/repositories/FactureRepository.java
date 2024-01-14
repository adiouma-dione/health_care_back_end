package tn.tech.horizon.demo_keycloak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.demo_keycloak.entites.Consultation;
import tn.tech.horizon.demo_keycloak.entites.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("SELECT f FROM Facture f WHERE f.dossierMedical.idDossierMedical = ?1 order by f.dateFacture desc")
    Page<Facture> findConsultationByDateAndIdDossier(Long idDossier, Pageable pageable);
}
