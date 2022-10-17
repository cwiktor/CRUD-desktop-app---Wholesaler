package Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sprzedawca extends Pracownik{
    private float bonus;
    private String obszar;
    private List<Zamowienie> zamowienia = new ArrayList<>();

    protected Sprzedawca() {
    }
    public Sprzedawca(String imie, String nazwisko, String email, String pesel, LocalDate dataZatrudnienia, float pensja, float bonus, String obszar) {
        super(imie, nazwisko, email, pesel, dataZatrudnienia, pensja);
        setBonus(bonus);
        setObszar(obszar);
    }

    @OneToMany(mappedBy = "sprzedawca",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
    public void addZamowienie(Zamowienie zamowienie){
        if(!zamowienia.contains(zamowienie)){
            zamowienia.add(zamowienie);
            zamowienie.setSprzedawca(this);
        }
    }

    public float getBonus() {
        return bonus;
    }
    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getObszar() {
        return obszar;
    }
    public void setObszar(String obszar) {
        this.obszar = obszar;
    }

    public void removeZamowienie(Zamowienie zamowienie){
        zamowienia.remove(zamowienie);
    }

    @Override
    public String toString() {
        return "Sprzedawca: ilosc zamowien: "; //+ zamowienia.size();
    }
}
