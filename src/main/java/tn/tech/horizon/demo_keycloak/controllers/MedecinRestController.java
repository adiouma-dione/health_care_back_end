package tn.tech.horizon.demo_keycloak.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.demo_keycloak.entites.Medecin;
import tn.tech.horizon.demo_keycloak.services.impl.MedecinServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class MedecinRestController {

    private MedecinServiceImpl medecinService;

    @GetMapping("/medecin/list")
    public ResponseEntity<Page<Medecin>> getAllMedecins(String name, int page, int size) {
        return ResponseEntity.ok(medecinService.getAllMedecins(name, PageRequest.of(page, size)));
    }

    @GetMapping("/medecin/{idMedecin}")
    public ResponseEntity<Medecin> getMedecin(@PathVariable Long idMedecin) {
        return ResponseEntity.ok(medecinService.getMedecin(idMedecin));
    }

    @PostMapping("/medecin/add")
    public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
        return ResponseEntity.ok(medecinService.addMedecin(medecin));
    }

    @PostMapping("/medecin/update")
    public ResponseEntity<Medecin> updateMedecin(@RequestBody Medecin medecin) {
        return ResponseEntity.ok(medecinService.updateMedecin(medecin));
    }

    @PostMapping("/medecin/delete/{idMedecin}")
    public ResponseEntity<String> deleteMedecin(@PathVariable Long idMedecin) {
        medecinService.deleteMedecin(idMedecin);
        return ResponseEntity.ok(String.format("Medecin %d supprimé!", idMedecin));
    }



}
