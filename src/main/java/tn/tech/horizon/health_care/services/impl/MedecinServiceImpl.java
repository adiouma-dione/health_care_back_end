package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Medecin;
import tn.tech.horizon.health_care.entites.User;
import tn.tech.horizon.health_care.repositories.MedecinRepository;
import tn.tech.horizon.health_care.services.MedecinService;

@Service
@AllArgsConstructor
public class MedecinServiceImpl implements MedecinService {

    private MedecinRepository medecinRepository;
    private UserServiceImpl userService;

    @Override
    public Page<Medecin> getAllMedecins(String nom, Pageable page) {
        return medecinRepository.findMedecinByNomContains(nom, page);
    }

    @Override
    public Medecin addMedecin(Medecin medecin) {
        User user = User.builder()
                .prenom(medecin.getPrenom())
                .nom(medecin.getNom())
                .role("medecin")
                .username(medecin.getEmail())
                .password("0000")
                .build();
        userService.addUser(user);
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        User getUser = userService.getUser(medecin.getEmail());
        User user = User.builder()
                .idUser(getUser.getIdUser())
                .prenom(medecin.getPrenom())
                .nom(medecin.getNom())
                .username(medecin.getEmail())
                .role("medecin")
                .password("0000")
                .build();
        userService.addUser(user);
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin getMedecin(Long idMedecin) {
        return medecinRepository.findById(idMedecin).orElse(null);
    }


    @Override
    public Medecin getMedecinByEmail(String email) {
        return medecinRepository.findMedecinByEmail(email).orElse(null);
    }

    @Override
    public void deleteMedecin(Long idMedecin) {
        medecinRepository.deleteById(idMedecin);
    }
}
