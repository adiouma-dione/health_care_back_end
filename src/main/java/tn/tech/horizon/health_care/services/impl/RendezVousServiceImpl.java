package tn.tech.horizon.health_care.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.health_care.entites.RendezVous;
import tn.tech.horizon.health_care.repositories.RendezVousRepository;
import tn.tech.horizon.health_care.services.RendezVousService;

@Service
@AllArgsConstructor
public class RendezVousServiceImpl implements RendezVousService {

    private RendezVousRepository rendezVousRepository;

    @Override
    public Page<RendezVous> getAllRendezVouss(String date, Pageable page) {
        return rendezVousRepository.findRendezVousByDateRendezVousContains(date, page);
    }

    @Override
    public RendezVous addRendezVous(RendezVous rendezVous) {
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

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
}
