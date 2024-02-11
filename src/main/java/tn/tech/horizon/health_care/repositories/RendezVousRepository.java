package tn.tech.horizon.health_care.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.health_care.entites.Medecin;
import tn.tech.horizon.health_care.entites.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    Page<RendezVous> findRendezVousByDateRendezVousContains(String date, Pageable page);
    Page<RendezVous> findRendezVousByMedecin_IdMedecin(Long medecin_idMedecin, Pageable pageable);
    Page<RendezVous> findRendezVousByPatient_IdPatientOrderByIdRendezVousDesc
            (Long idPatient, Pageable page);
}
