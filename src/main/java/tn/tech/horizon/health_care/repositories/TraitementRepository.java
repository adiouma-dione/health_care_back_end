package tn.tech.horizon.health_care.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.health_care.entites.Traitement;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Long> {
//    @Query("SELECT t FROM Traitement t WHERE t.dossierMedical.idDossierMedical = ?1")
    Page<Traitement> findTraitementByDossierMedical_IdDossierMedicalOrderByIdTraitementDesc(Long idDossier, Pageable pageable);
}
