package tn.tech.horizon.demo_keycloak.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tn.tech.horizon.demo_keycloak.entites.Consultation;
import tn.tech.horizon.demo_keycloak.entites.DossierMedical;
import tn.tech.horizon.demo_keycloak.repositories.ConsultationRepository;
import tn.tech.horizon.demo_keycloak.services.ConsultationService;

@Service
@AllArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;
    private DossierMedicalServiceImpl dossierMedicalService;

    @Override
    public Page<Consultation> getAllConsultations( Long idDossier, Pageable page) {
        return consultationRepository.findConsultationByDateAndIdDossier(idDossier, page);
    }

    @Override
    public Consultation addConsultation(Consultation consultation, Long idDossier) {
        DossierMedical dossier = dossierMedicalService.getDossierMedical(idDossier);
        consultation.setDossierMedical(dossier);
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation updateConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation getConsultation(Long idConsultation) {
        return consultationRepository.findById(idConsultation).orElse(null);
    }

    @Override
    public void deleteConsultation(Long idPatient) {
        consultationRepository.deleteById(idPatient);
    }

}
