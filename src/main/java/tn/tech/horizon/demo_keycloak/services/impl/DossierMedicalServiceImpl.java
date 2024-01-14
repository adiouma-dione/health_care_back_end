package tn.tech.horizon.demo_keycloak.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.DossierMedical;
import tn.tech.horizon.demo_keycloak.entites.Patient;
import tn.tech.horizon.demo_keycloak.repositories.DossierMedicalRepository;
import tn.tech.horizon.demo_keycloak.repositories.MedecinRepository;
import tn.tech.horizon.demo_keycloak.repositories.PatientRepository;
import tn.tech.horizon.demo_keycloak.services.DossierMedicalService;

@Service
@AllArgsConstructor
public class DossierMedicalServiceImpl implements DossierMedicalService {

    private DossierMedicalRepository dossierMedicalRepository;
    private PatientServiceImpl patientService ;
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;

    @Override
    public Page<DossierMedical> getAllDossierMedicals(String date, Pageable page) {
        return dossierMedicalRepository.findDossierMedicalByDateCreationContains(date, page);
    }

//    @Override
//    public DossierMedical addDossierMedical(Long idPatient) {
////        , Long idMedecin
//        Patient patient = patientRepository.findById(idPatient).orElse(null);
//        if (patient != null) {
//            DossierMedical dossierMedical = patient.getDossierMedicaux();
//        }
////        Long idP = (long) idPatient;
////        Long idM = (long) idMedecin;
//        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
//        dossierMedical.setPatient(patient);
//        dossierMedical.setMedecin(medecin);
//        return dossierMedicalRepository.save(dossierMedical);
//    }

    @Override
    public DossierMedical updateDossierMedical(DossierMedical dossierMedical, Long idPatient, Long idMedecin) {
//        , Long idPatient, Long idMedecin
//        Patient patient = patientService.getPatient(idPatient);
//        Medecin medecin = medecinService.getMedecin(idMedecin);
//        dossierMedical.setPatient(patient);
//        dossierMedical.setMedecin(medecin);
        return dossierMedicalRepository.save(dossierMedical);
    }

    @Override
    public DossierMedical updateDossierMedical(Long idPatient) {
//        DossierMedical dossierMedical, Long idPatient, Long idMedecin
        DossierMedical dossierMedical = this.getDossierMedical(idPatient);
        Patient patient = patientService.getPatient(idPatient);
//        Medecin medecin = medecinService.getMedecin(idMedecin);
        dossierMedical.setPatient(patient);
//        dossierMedical.setMedecin(medecin);
        return dossierMedicalRepository.save(dossierMedical);
    }

    @Override
    public DossierMedical getDossierMedical(Long idDossierMedical) {
        return dossierMedicalRepository.findById(idDossierMedical).orElse(null);
    }

    @Override
    public void deleteDossierMedical(Long idDossierMedical) {
        dossierMedicalRepository.deleteById(idDossierMedical);
    }
}
