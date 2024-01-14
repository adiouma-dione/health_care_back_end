package tn.tech.horizon.demo_keycloak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.DossierMedical;

@Service
public interface DossierMedicalService {
    Page<DossierMedical> getAllDossierMedicals(String date, Pageable page);

//    DossierMedical addDossierMedical(DossierMedical dossierMedical, int idPatient, int idMedecin);

//    DossierMedical addDossierMedical(DossierMedical dossierMedical, Long idPatient, Long idMedecin);

//    DossierMedical addDossierMedical(Long idPatient, Long idMedecin);

//    DossierMedical addDossierMedical(Long idPatient);

//    DossierMedical updateDossierMedical(DossierMedical dossierMedical);

    DossierMedical updateDossierMedical(DossierMedical dossierMedical, Long idPatient, Long idMedecin);

    DossierMedical updateDossierMedical(Long idPatient);

    DossierMedical getDossierMedical(Long idDossierMedical);

    void deleteDossierMedical(Long idDossierMedical);
}
