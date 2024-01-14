package tn.tech.horizon.health_care.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Consultation;

@Service
public interface ConsultationService {
    Page<Consultation> getAllConsultations(Long idDossier, Pageable page);
//    Consultation addConsultation(Consultation consultation);

    Consultation addConsultation(Consultation consultation, Long idDossier);

    Consultation updateConsultation(Consultation consultation);
    Consultation getConsultation(Long idConsultation);
    void deleteConsultation(Long idConsultation);
}
