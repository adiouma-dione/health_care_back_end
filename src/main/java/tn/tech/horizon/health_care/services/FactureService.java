package tn.tech.horizon.health_care.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Facture;

@Service
public interface FactureService {

    Page<Facture> getAllFactures(Long idDossier, Pageable page);

    Facture addFacture(Facture facture, Long idDossier);

    Facture updateFacture(Facture facture);

    Facture getFacture(Long idFacture);

    void deleteFacture(Long idFacture);
}
