package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.DossierMedical;
import tn.tech.horizon.health_care.entites.Patient;
import tn.tech.horizon.health_care.repositories.DossierMedicalRepository;
import tn.tech.horizon.health_care.repositories.PatientRepository;
import tn.tech.horizon.health_care.services.PatientService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private DossierMedicalRepository dossierMedicalRepository;

    @Override
    public Page<Patient> getAllPatients(String nom, Pageable page) {
        return patientRepository.findPatientByNomContains(nom, page);
    }

    @Override
    public Patient addPatient(Patient patient) {
        DossierMedical dossierMedical = new DossierMedical();
        dossierMedical.setIdDossierMedical(null);
        dossierMedical.setDateCreation(String.valueOf(LocalDate.now()));
        DossierMedical dm = dossierMedicalRepository.save(dossierMedical);
        patient.setDossierMedical(dm);
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
