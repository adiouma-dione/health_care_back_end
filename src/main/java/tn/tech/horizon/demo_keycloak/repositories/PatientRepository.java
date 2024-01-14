package tn.tech.horizon.demo_keycloak.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tech.horizon.demo_keycloak.entites.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
//    Page<Patient> findPatientByNom(String nom, int page, int size);
    Page<Patient> findPatientByNomContains(String nom, Pageable page);
}
