package tech.im.RejestrOfert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.im.RejestrOfert.exception.OfertaNotFoundException;
import tech.im.RejestrOfert.model.Oferta;
import tech.im.RejestrOfert.repo.OfertaRepo;


import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OfertaService {
    private final OfertaRepo ofertaRepo;

    @Autowired
    public  OfertaService(OfertaRepo ofertaRepo) {
        this.ofertaRepo = ofertaRepo;
    }

    public Oferta addOferta(Oferta oferta) {
        oferta.setOfertaCode(UUID.randomUUID().toString());
        return ofertaRepo.save(oferta);
    }

    public List<Oferta> findAllOferta() {
        return ofertaRepo.findAll();
    }

    public Oferta updateOferta(Oferta oferta) {
        return ofertaRepo.save(oferta);
    }

    public Oferta findOfertaById(Long id) {
        return ofertaRepo.findOfertaById(id)
                .orElseThrow(() -> new OfertaNotFoundException("Oferta o id " + id + "nie znaleziona"));
    }

    public void deleteOferta(Long id) {
        ofertaRepo.deleteOfertaById(id);
    }

}
