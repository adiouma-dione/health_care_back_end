package tn.tech.horizon.demo_keycloak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.Patient;

@Service
public interface PatientService {
    Page<Patient> getAllPatients(String nom, Pageable page);
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    Patient getPatient(Long id);
    void deletePatient(Long id);

}
