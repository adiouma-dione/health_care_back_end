package tn.tech.horizon.demo_keycloak.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.Medecin;
import tn.tech.horizon.demo_keycloak.repositories.MedecinRepository;
import tn.tech.horizon.demo_keycloak.services.MedecinService;

@Service
@AllArgsConstructor
public class MedecinServiceImpl implements MedecinService {

    private MedecinRepository medecinRepository;


    @Override
    public Page<Medecin> getAllMedecins(String nom, Pageable page) {
        return medecinRepository.findMedecinByNomContains(nom, page);
    }

    @Override
    public Medecin addMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin getMedecin(Long idMedecin) {
        return medecinRepository.findById(idMedecin).orElse(null);
    }

    @Override
    public void deleteMedecin(Long idMedecin) {
        medecinRepository.deleteById(idMedecin);
    }
}
