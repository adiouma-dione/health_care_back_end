package tn.tech.horizon.health_care.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.health_care.entites.RendezVous;
import tn.tech.horizon.health_care.services.impl.RendezVousServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class RendezVousRestController {

    private RendezVousServiceImpl rendezVousService;

    @GetMapping("/rendezVous/list")
    public ResponseEntity<Page<RendezVous>> getAllRendezVous(String date, int page, int size) {
        return ResponseEntity.ok(rendezVousService.getAllRendezVous(date, PageRequest.of(page, size)));
    }

    @GetMapping("/rendezVous/medecin")
    public ResponseEntity<Page<RendezVous>> getAllRendezVousByMedecin(Long idMedecin, int page, int size) {
        return ResponseEntity.ok(rendezVousService.getAllRendezVousByMedecin(idMedecin, PageRequest.of(page, size)));
    }

    @GetMapping("/rendezVous/patient")
    public ResponseEntity<Page<RendezVous>> getRendezVousByPatient(Long idPatient, int page, int size) {
        return ResponseEntity.ok(rendezVousService.getRendezVousByPatient(idPatient, PageRequest.of(page, size)));
    }

    @GetMapping("/rendezVous/{idRendezVous}")
    public ResponseEntity<RendezVous> getRendezVous(@PathVariable Long idRendezVous) {
        return ResponseEntity.ok(rendezVousService.getRendezVous(idRendezVous));
    }

    @PostMapping("/rendezVous/add/{idPatient}/{idMedecin}")
    public ResponseEntity<RendezVous> saveRendezVous(
            @RequestBody RendezVous rendezVous,
            @PathVariable Long idPatient,
            @PathVariable Long idMedecin) {
        RendezVous savedRendezVous = rendezVousService.addRendezVous(rendezVous, idPatient, idMedecin);
        return ResponseEntity.ok(savedRendezVous);
    }

    @PutMapping("/rendezVous/update")
    public ResponseEntity<RendezVous> updateRendezVous(@RequestBody RendezVous rendezVous) {
        return ResponseEntity.ok(rendezVousService.updateRendezVous(rendezVous));
    }

    @PostMapping("/rendezVous/delete/{idRendezVous}")
    public ResponseEntity<String> deleteRendezVous(@PathVariable Long idRendezVous) {
        rendezVousService.deleteRendezVous(idRendezVous);
        return ResponseEntity.ok(String.format("RendezVous %d supprimé!", idRendezVous));
    }



}
