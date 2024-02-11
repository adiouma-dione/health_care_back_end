package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.Medecin;
import tn.tech.horizon.health_care.entites.Patient;
import tn.tech.horizon.health_care.entites.RendezVous;
import tn.tech.horizon.health_care.repositories.RendezVousRepository;
import tn.tech.horizon.health_care.services.RendezVousService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@AllArgsConstructor
public class RendezVousServiceImpl implements RendezVousService {

    private RendezVousRepository rendezVousRepository;
    private PatientServiceImpl patientService;
    private MedecinServiceImpl medecinService;

    @Override
    public Page<RendezVous> getAllRendezVous(String date, Pageable page) {
        return rendezVousRepository.findRendezVousByDateRendezVousContains(date, page);
    }

    @Override
    public Page<RendezVous> getAllRendezVousByMedecin(Long idMedecin, Pageable page) {
        return rendezVousRepository.findRendezVousByMedecin_IdMedecin(idMedecin, page);
    }
//
    @Override
    public Page<RendezVous> getRendezVousByPatient(Long idPatient, Pageable page) {
        return rendezVousRepository.findRendezVousByPatient_IdPatientOrderByIdRendezVousDesc(idPatient, page);
    }

    @Override
    public RendezVous addRendezVous(RendezVous rendezVous, Long idPatient, Long idMedecin) {
        Patient patient = patientService.getPatient(idPatient);
        Medecin medecin = medecinService.getMedecin(idMedecin);

        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateRV = formatter.format(new Date());
        formatter = new SimpleDateFormat("hh:mm");
        String heureRV = formatter.format(new Date());
        rendezVous.setDateRendezVous(dateRV);
        rendezVous.setHeureRendezVous(heureRV);

        rendezVous.setPatient(patient);
        rendezVous.setMedecin(medecin);
        rendezVous.setIsConfirmed(false);

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous updateRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous getRendezVous(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

//    @Override
//    public RendezVous getRendezVousByMedecin(Long id) {
//        return rendezVousRepository.findById(id).orElse(null);
//    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
}
