package Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klient extends Osoba{
    private boolean czyRabat;
    private Adres adres;
    private List<Zamowienie> zamowienia = new ArrayList<>();

    protected Klient() {
    }

    public Klient(String imie, String nazwisko, String email, Adres adres,  boolean czyRabat){
        super(imie, nazwisko, email);
        setAdres(adres);
        setCzyRabat(czyRabat);
    }

    public void addZamowienie(Zamowienie zamowienie){
        if(!zamowienia.contains(zamowienie)){
            zamowienia.add(zamowienie);
            zamowienie.setKlient(this);
        }
    }

    @OneToMany(mappedBy = "klient",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    @OneToOne
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
        adres.setKlient(this);
    }

    public boolean isCzyRabat() {
        return czyRabat;
    }
    public void setCzyRabat(boolean czyRabat) {
        this.czyRabat = czyRabat;
    }

    public void removeZamowienie(Zamowienie zamowienie){
        zamowienia.remove(zamowienie);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "adres='" + adres + '\'' +
                ", czyRabat=" + czyRabat +
                '}';
    }
}
