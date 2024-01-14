package tn.tech.horizon.health_care.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Medecin;

@Service
public interface MedecinService {
    Page<Medecin> getAllMedecins(String nom, Pageable page);

    Medecin addMedecin(Medecin medecin);

    Medecin updateMedecin(Medecin medecin);

    Medecin getMedecin(Long idMedecin);

    void deleteMedecin(Long idMedecin);
}
