package tn.tech.horizon.health_care.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.health_care.entites.Facture;
import tn.tech.horizon.health_care.services.impl.FactureServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class FactureRestController {

    private FactureServiceImpl factureService;

    @GetMapping("/facture/list")
    public ResponseEntity<Page<Facture>> getAllFactures(
            Long idDossier, int page, int size) {
        return ResponseEntity.ok(factureService.getAllFactures(idDossier, PageRequest.of(page, size)));
    }

    @GetMapping("/facture/{idFacture}")
    public ResponseEntity<Facture> getFacture(@PathVariable Long idFacture) {
        return ResponseEntity.ok(factureService.getFacture(idFacture));
    }

    @PostMapping("/facture/add/{idDossier}")
    public ResponseEntity<Facture> saveFacture(
            @RequestBody Facture facture, @PathVariable Long idDossier) {
        return ResponseEntity.ok(factureService.addFacture(facture, idDossier));
    }

    @PutMapping("/facture/update")
    public ResponseEntity<Facture> updateFacture(@RequestBody Facture facture) {
        return ResponseEntity.ok(factureService.updateFacture(facture));
    }

    @PostMapping("/facture/delete/{idFacture}")
    public ResponseEntity<String> deleteFacture(@PathVariable Long idFacture) {
        factureService.deleteFacture(idFacture);
        return ResponseEntity.ok(String.format("Facture %d supprimé!", idFacture));
    }



}
