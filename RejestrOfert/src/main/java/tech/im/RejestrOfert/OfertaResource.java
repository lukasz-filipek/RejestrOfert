package tech.im.RejestrOfert;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.im.RejestrOfert.model.Oferta;
import tech.im.RejestrOfert.service.OfertaService;


import java.util.List;

@RestController
@RequestMapping("/oferta")
public class OfertaResource {
    private final OfertaService ofertaService;

    public OfertaResource(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Oferta>> getAllOferta () {
        List<Oferta> oferty = ofertaService.findAllOferta();
        return new ResponseEntity<>(oferty, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Oferta> getOfertaById (@PathVariable("id") Long id) {
        Oferta oferta = ofertaService.findOfertaById(id);
        return new ResponseEntity<>(oferta, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Oferta> addOferta(@RequestBody Oferta oferta) {
        Oferta newOferta = ofertaService.addOferta(oferta);
        return new ResponseEntity<>(newOferta, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Oferta> updateOferta(@RequestBody Oferta oferta) {
        Oferta updateOferta = ofertaService.updateOferta(oferta);
        return new ResponseEntity<>(updateOferta, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOferta(@PathVariable("id") Long id) {
        ofertaService.deleteOferta(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
