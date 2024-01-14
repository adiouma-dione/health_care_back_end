package tn.tech.horizon.demo_keycloak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.Traitement;

@Service
public interface TraitementService {
//    Page<Traitement> getAllTraitements(String date, Pageable page);
//    Traitement addTraitement(Traitement traitement);

    Page<Traitement> getAllTraitements(Long idDossier, Pageable page);

    Traitement addTraitement(Traitement traitement, Long idDossier);

    Traitement updateTraitement(Traitement traitement);
    Traitement getTraitement(Long id);
    void deleteTraitement(Long id);
}
