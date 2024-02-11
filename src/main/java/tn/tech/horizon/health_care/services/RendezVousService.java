package tn.tech.horizon.health_care.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.RendezVous;

@Service
public interface RendezVousService {

    Page<RendezVous> getAllRendezVous(String date, Pageable page);

    Page<RendezVous> getAllRendezVousByMedecin(Long idMedecin, Pageable page);

    Page<RendezVous> getRendezVousByPatient(Long idPatient, Pageable page);

    RendezVous addRendezVous(RendezVous rendezVous, Long idPatient, Long idMedecin);

    RendezVous updateRendezVous(RendezVous rendezVous);
    RendezVous getRendezVous(Long id);
    void deleteRendezVous(Long id);
}
