package tech.im.RejestrOfert.repo;

import tech.im.RejestrOfert.model.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface OfertaRepo extends JpaRepository<Oferta, Long> {
    void deleteOfertaById(Long id);

    Optional<Oferta> findOfertaById(Long id);
}