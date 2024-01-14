package tn.tech.horizon.demo_keycloak.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.demo_keycloak.entites.Secretaire;
import tn.tech.horizon.demo_keycloak.services.impl.SecretaireServiceImpl;

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

    @PostMapping("/secretaire/add")
    public ResponseEntity<Secretaire> saveSecretaire(@RequestBody Secretaire secretaire) {
        return ResponseEntity.ok(secretaireService.addSecretaire(secretaire));
    }

    @PostMapping("/secretaire/update")
    public ResponseEntity<Secretaire> updateSecretaire(@RequestBody Secretaire secretaire) {
        return ResponseEntity.ok(secretaireService.updateSecretaire(secretaire));
    }

    @PostMapping("/secretaire/delete/{idSecretaire}")
    public ResponseEntity<String> deleteSecretaire(@PathVariable Long idSecretaire) {
        secretaireService.deleteSecretaire(idSecretaire);
        return ResponseEntity.ok(String.format("Secretaire %d supprimé!", idSecretaire));
    }



}
