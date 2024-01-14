package tn.tech.horizon.demo_keycloak.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.demo_keycloak.entites.RendezVous;
import tn.tech.horizon.demo_keycloak.services.impl.RendezVousServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class RendezVousRestController {

    private RendezVousServiceImpl rendezVousService;

    @GetMapping("/rendezVous/list")
    public ResponseEntity<Page<RendezVous>> getAllRendezVouss(String date, int page, int size) {
        return ResponseEntity.ok(rendezVousService.getAllRendezVouss(date, PageRequest.of(page, size)));
    }

    @GetMapping("/rendezVous/{idRendezVous}")
    public ResponseEntity<RendezVous> getRendezVous(@PathVariable Long idRendezVous) {
        return ResponseEntity.ok(rendezVousService.getRendezVous(idRendezVous));
    }

    @PostMapping("/rendezVous/add")
    public ResponseEntity<RendezVous> saveRendezVous(@RequestBody RendezVous rendezVous) {
        return ResponseEntity.ok(rendezVousService.addRendezVous(rendezVous));
    }

    @PostMapping("/rendezVous/update")
    public ResponseEntity<RendezVous> updateRendezVous(@RequestBody RendezVous rendezVous) {
        return ResponseEntity.ok(rendezVousService.updateRendezVous(rendezVous));
    }

    @PostMapping("/rendezVous/delete/{idRendezVous}")
    public ResponseEntity<String> deleteRendezVous(@PathVariable Long idRendezVous) {
        rendezVousService.deleteRendezVous(idRendezVous);
        return ResponseEntity.ok(String.format("RendezVous %d supprimé!", idRendezVous));
    }



}
