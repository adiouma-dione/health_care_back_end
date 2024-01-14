package tn.tech.horizon.demo_keycloak.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.demo_keycloak.entites.Patient;
import tn.tech.horizon.demo_keycloak.services.impl.PatientServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class PatientRestController {

    private PatientServiceImpl patientService;

    @GetMapping("/patient/list")
    public ResponseEntity<Page<Patient>> getAllPatientsByPage(String name, int page, int size) {
        return ResponseEntity.ok(patientService.getAllPatients(name, PageRequest.of(page, size)));
    }

    @GetMapping("/patient/{idPatient}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long idPatient) {
        return ResponseEntity.ok(patientService.getPatient(idPatient));
    }

    @PostMapping("/patient/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @PutMapping("/patient/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }

    @PostMapping("/patient/delete/{idPatient}")
    public ResponseEntity<String> deletePatient(@PathVariable Long idPatient) {
        patientService.deletePatient(idPatient);
        return ResponseEntity.ok(String.format("Patient %d supprimé!", idPatient));
    }

}
