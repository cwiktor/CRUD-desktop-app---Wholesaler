package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adres {

    private Long id;
    private String ulica;
    private int nrDomu;
    private String kodPocztowy;
    private String kraj;
    private Klient klient;

    protected Adres() {}
    public Adres(String ulica, int nrDomu, String kodPocztowy, String kraj) {
        setUlica(ulica);
        setNrDomu(nrDomu);
        setKodPocztowy(kodPocztowy);
        setKraj(kraj);
    }

    @Id
    @GeneratedValue(generator="increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    @OneToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
}
