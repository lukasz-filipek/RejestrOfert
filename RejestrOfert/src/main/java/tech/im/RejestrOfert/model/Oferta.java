package tech.im.RejestrOfert.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Oferta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nazwaKlienta;
    private String dataOtrzymaniazapytania;
    private String nazwaZespolu;
    private String waga;
    private String nrRysunku;
    private String okresRealizacji;
    private String minimalnaPartia;
    private String terminWyceny;
    private String imgUrl;
    private String uwagi;
    @Column(nullable = false, updatable = false)
    private String ofertaCode;

    public Oferta() {}

    public Oferta(String nazwaKlienta, String dataOtrzymaniazapytania, String nazwaZespolu, String waga, String nrRysunku, String okresRealizacji, String minimalnaPartia, String terminWyceny, String imgUrl, String uwagi, String ofertaCode) {

        this.nazwaKlienta = nazwaKlienta;
        this.dataOtrzymaniazapytania = dataOtrzymaniazapytania;
        this.nazwaZespolu = nazwaZespolu;
        this.waga = waga;
        this.nrRysunku = nrRysunku;
        this.okresRealizacji = okresRealizacji;
        this.minimalnaPartia = minimalnaPartia;
        this.terminWyceny = terminWyceny;
        this.imgUrl = imgUrl;
        this.uwagi = uwagi;
        this.ofertaCode = ofertaCode;

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNazwaKlienta() {

        return nazwaKlienta;
    }

    public void  setNazwaKlienta(String nazwaKlienta) {

        this.nazwaKlienta = nazwaKlienta;
    }

    public String getDataOtrzymaniazapytania() {

        return dataOtrzymaniazapytania;
    }

    public void  setDataOtrzymaniazapytania(String dataOtrzymaniazapytania) {
        this.dataOtrzymaniazapytania = dataOtrzymaniazapytania;
    }

    public String getNazwaZespolu() {

        return nazwaZespolu;
    }

    public void  setNazwaZespolu(String nazwaZespolu) {

        this.nazwaZespolu = nazwaZespolu;
    }

    public String getWaga() {

        return waga;
    }

    public void  setWaga(String waga) {

        this.waga = waga;
    }

    public String getNrRysunku() {

        return nrRysunku;
    }

    public void  setNrRysunku(String nrRysunku) {

        this.nrRysunku = nrRysunku;
    }

    public String getOkresRealizacji() {
        return okresRealizacji;
    }

    public void  setOkresRealizacji(String okresRealizacji) {

        this.okresRealizacji = okresRealizacji;
    }

    public String getMinimalnaPartia() {

        return minimalnaPartia;
    }

    public void  setMinimalnaPartia(String minimalnaPartia) {

        this.minimalnaPartia = minimalnaPartia;
    }

    public String getTerminWyceny() {

        return terminWyceny;
    }

    public void  setTerminWyceny(String terminWyceny) {

        this.terminWyceny = terminWyceny;
    }

    public String getImgUrl() {

        return imgUrl;
    }

    public void  setImgUrl(String imgUrl) {

        this.imgUrl = imgUrl;
    }

    public String getUwagi() {

        return uwagi;
    }

    public void  setUwagi(String uwagi) {

        this.uwagi = uwagi;
    }

    public String getOfertaCode() {

        return ofertaCode;
    }

    public void  setOfertaCode(String ofertaCode) {

        this.ofertaCode = ofertaCode;
    }



    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", nazwaKlienta='" + nazwaKlienta + '\'' +
                ", dataOtrzymaniazapytania='" + dataOtrzymaniazapytania + '\'' +
                ", nazwaZespolu='" + nazwaZespolu + '\'' +
                ", waga='" + waga + '\'' +
                ", nrRysunku='" + nrRysunku + '\'' +
                ", okresRealizacji='" + okresRealizacji + '\'' +
                ", minimalnaPartia='" + minimalnaPartia + '\'' +
                ", terminWyceny='" + terminWyceny + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", uwagi='" + uwagi + '\'' +
                '}';
    }



}
