package tn.tech.horizon.health_care.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.health_care.entites.Secretaire;
import tn.tech.horizon.health_care.services.impl.SecretaireServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class SecretaireRestController {

    private SecretaireServiceImpl secretaireService;

    @GetMapping("/secretaire/list")
    public ResponseEntity<Page<Secretaire>> getAllSecretaires(String name, int page, int size) {
        return ResponseEntity.ok(secretaireService.getAllSecretaires(name, PageRequest.of(page, size)));
    }

    @GetMapping("/secretaire/{idSecretaire}")
    public ResponseEntity<Secretaire> getSecretaire(@PathVariable Long idSecretaire) {
        return ResponseEntity.ok(secretaireService.getSecretaire(idSecretaire));
    }

    @GetMapping("/secretaire-email/{email}")
    public ResponseEntity<Secretaire> getSecretaireByEmail(@PathVariable String email) {
        return ResponseEntity.ok(secretaireService.getSecretaireByEmail(email));
    }

    @PostMapping("/secretaire/add")
    public ResponseEntity<Secretaire> saveSecretaire(@RequestBody Secretaire secretaire) {
        return ResponseEntity.ok(secretaireService.addSecretaire(secretaire));
    }

    @PutMapping("/secretaire/update")
    public ResponseEntity<Secretaire> updateSecretaire(@RequestBody Secretaire secretaire) {
        return ResponseEntity.ok(secretaireService.updateSecretaire(secretaire));
    }

    @PostMapping("/secretaire/delete/{idSecretaire}")
    public ResponseEntity<String> deleteSecretaire(@PathVariable Long idSecretaire) {
        secretaireService.deleteSecretaire(idSecretaire);
        return ResponseEntity.ok(String.format("Secretaire %d supprimé!", idSecretaire));
    }



}
