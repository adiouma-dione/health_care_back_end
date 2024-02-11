package tn.tech.horizon.health_care.controllers;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.health_care.entites.Consultation;
import tn.tech.horizon.health_care.services.impl.ConsultationServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class ConsultationRestController {

    private ConsultationServiceImpl consultationService;

    @GetMapping("/consultation/list")
//    @RolesAllowed("medecin")
    public ResponseEntity<Page<Consultation>> getAllConsultations(
            Long idDossier, int page, int size) {
        return ResponseEntity.ok(consultationService.getAllConsultations(idDossier, PageRequest.of(page, size)));
    }

    @GetMapping("/consultation/{idConsultation}")
    public ResponseEntity<Consultation> getConsultation(@PathVariable Long idConsultation) {
        return ResponseEntity.ok(consultationService.getConsultation(idConsultation));
    }

    @PostMapping("/consultation/add/{idDossier}")
    public ResponseEntity<Consultation> saveConsultation(
            @RequestBody Consultation consultation, @PathVariable Long idDossier) {
        return ResponseEntity.ok(consultationService.addConsultation(consultation, idDossier));
    }

    @PutMapping("/consultation/update")
    public ResponseEntity<Consultation> updateConsultation(@RequestBody Consultation consultation) {
        return ResponseEntity.ok(consultationService.updateConsultation(consultation));
    }

    @PostMapping("/consultation/delete/{idConsultation}")
    public ResponseEntity<String> deleteConsultation(@PathVariable Long idConsultation) {
        consultationService.deleteConsultation(idConsultation);
        return ResponseEntity.ok(String.format("Consultation %d supprimé!", idConsultation));
    }


}
