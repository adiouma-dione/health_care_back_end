package tn.tech.horizon.demo_keycloak.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.demo_keycloak.entites.Traitement;
import tn.tech.horizon.demo_keycloak.services.impl.TraitementServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class TraitementRestController {

    private TraitementServiceImpl traitementService;

    @GetMapping("/traitement/list")
    public ResponseEntity<Page<Traitement>> getAllTraitements(Long idDossier, int page, int size) {
        return ResponseEntity.ok(traitementService.getAllTraitements(idDossier, PageRequest.of(page, size)));
    }

    @GetMapping("/traitement/{idTraitement}")
    public ResponseEntity<Traitement> getTraitement(@PathVariable Long idTraitement) {
        return ResponseEntity.ok(traitementService.getTraitement(idTraitement));
    }

    @PostMapping("/traitement/add/{idDossier}")
    public ResponseEntity<Traitement> saveTraitement(
            @RequestBody Traitement traitement, @PathVariable Long idDossier) {
        return ResponseEntity.ok(traitementService.addTraitement(traitement, idDossier));
    }

    @PutMapping("/traitement/update")
    public ResponseEntity<Traitement> updateTraitement(@RequestBody Traitement traitement) {
        return ResponseEntity.ok(traitementService.updateTraitement(traitement));
    }

    @PostMapping("/traitement/delete/{idTraitement}")
    public ResponseEntity<String> deleteTraitement(@PathVariable Long idTraitement) {
        traitementService.deleteTraitement(idTraitement);
        return ResponseEntity.ok(String.format("Traitement %d supprimé!", idTraitement));
    }



}
