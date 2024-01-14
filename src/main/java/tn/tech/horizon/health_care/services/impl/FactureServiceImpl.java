package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.DossierMedical;
import tn.tech.horizon.health_care.entites.Facture;
import tn.tech.horizon.health_care.repositories.FactureRepository;
import tn.tech.horizon.health_care.services.FactureService;

@Service
@AllArgsConstructor
public class FactureServiceImpl implements FactureService {

    private FactureRepository factureRepository;
    private DossierMedicalServiceImpl dossierMedicalService;


    @Override
    public Page<Facture> getAllFactures(Long idDossier, Pageable page) {
        return factureRepository.findConsultationByDateAndIdDossier(idDossier, page);
    }

    @Override
    public Facture addFacture(Facture facture, Long idDossier) {
        DossierMedical dossierMedical = dossierMedicalService.getDossierMedical(idDossier);
        facture.setDossierMedical(dossierMedical);
        return factureRepository.save(facture);
    }

    @Override
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture getFacture(Long idFacture) {
        return factureRepository.findById(idFacture).orElse(null);
    }

    @Override
    public void deleteFacture(Long idFacture) {
        factureRepository.deleteById(idFacture);
    }
}
