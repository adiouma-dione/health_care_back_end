package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.DossierMedical;
import tn.tech.horizon.health_care.entites.Traitement;
import tn.tech.horizon.health_care.repositories.TraitementRepository;
import tn.tech.horizon.health_care.services.TraitementService;

@Service
@AllArgsConstructor
public class TraitementServiceImpl implements TraitementService {

    private TraitementRepository traitementRepository;
    private DossierMedicalServiceImpl dossierMedicalService;
    @Override
    public Page<Traitement> getAllTraitements(Long idDossier, Pageable page) {
        return traitementRepository.findTraitementByDossierMedical_IdDossierMedicalOrderByIdTraitementDesc(idDossier, page);
    }

    @Override
    public Traitement addTraitement(Traitement traitement, Long idDossier) {
        DossierMedical dossier = dossierMedicalService.getDossierMedical(idDossier);
        traitement.setDossierMedical(dossier);
        return traitementRepository.save(traitement);
    }

    @Override
    public Traitement updateTraitement(Traitement traitement) {
        return traitementRepository.save(traitement);
    }

    @Override
    public Traitement getTraitement(Long id) {
        return traitementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTraitement(Long id) {
        traitementRepository.deleteById(id);
    }
}
