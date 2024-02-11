package tn.tech.horizon.health_care.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Patient;

@Service
public interface PatientService {
    Page<Patient> getAllPatients(String nom, Pageable page);
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    Patient getPatient(Long id);
    Patient getPatientByEmail(String email);
    void deletePatient(Long id);

}
