package tn.tech.horizon.health_care.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.tech.horizon.health_care.entites.DossierMedical;
import tn.tech.horizon.health_care.services.impl.DossierMedicalServiceImpl;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class DossierMedicalRestController {

    private DossierMedicalServiceImpl dossierMedicalService;

    @GetMapping("/dossierMedical/list")
    public ResponseEntity<Page<DossierMedical>> getAllDossierMedicals(String name, int page, int size) {
        return ResponseEntity.ok(dossierMedicalService.getAllDossierMedicals(name, PageRequest.of(page, size)));
    }

    @GetMapping("/dossierMedical/{idDossierMedical}")
    public ResponseEntity<DossierMedical> getDossierMedical(@PathVariable Long idDossierMedical) {
        return ResponseEntity.ok(dossierMedicalService.getDossierMedical(idDossierMedical));
    }

    @PutMapping("/dossierMedical/update1")
    public ResponseEntity<DossierMedical> updateDossierMedical(@RequestBody DossierMedical dossierMedical, @RequestParam Long idPatient, @RequestParam Long idMedecin) {
//        , @RequestParam Long idPatient, @RequestParam Long idMedecin
//        , idPatient, idMedecin
        return ResponseEntity.ok(dossierMedicalService.updateDossierMedical(dossierMedical, idPatient, idMedecin));
    }

    @PutMapping("/dossierMedical/update/{idPatient}")
    public ResponseEntity<DossierMedical> updateDossierMedical(@PathVariable Long idPatient) {
//        , @RequestParam Long idPatient, @RequestParam Long idMedecin
//        , idPatient, idMedecin
        return ResponseEntity.ok(dossierMedicalService.updateDossierMedical(idPatient));
    }


//    @PostMapping("/dossierMedical/add")
//    public ResponseEntity<DossierMedical> saveDossierMedical(
//            @RequestBody DossierMedical dossierMedical,
//            @RequestParam int idPatient,
//            @RequestParam int idMedecin
//    ) {
//        return ResponseEntity.ok(dossierMedicalService.addDossierMedical(dossierMedical, idPatient, idMedecin));
//    }

//    @PostMapping("/dossierMedical/add")
//    public ResponseEntity<DossierMedical> saveDossierMedical(
//            @RequestBody DossierMedical dossierMedical,
//            @RequestParam Long idPatient
////            @RequestParam Long idMedecin
//    ) {
//        return ResponseEntity.ok(dossierMedicalService.addDossierMedical(idPatient));
//    }


    @PostMapping("/dossierMedical/delete/{idDossierMedical}")
    public ResponseEntity<String> deleteDossierMedical(@PathVariable Long idDossierMedical) {
        dossierMedicalService.deleteDossierMedical(idDossierMedical);
        return ResponseEntity.ok(String.format("DossierMedical %d supprimé!", idDossierMedical));
    }


}
