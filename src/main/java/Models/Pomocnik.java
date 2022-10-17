package Models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Pomocnik extends Pracownik{

    private int iloscNadgodzin;

    protected Pomocnik() {
    }

    public Pomocnik(String imie, String nazwisko, String email, String pesel, float pensja, LocalDate dataZatrudnienia, int iloscNadgodzin) {
        super(imie, nazwisko, email, pesel, dataZatrudnienia, pensja);
        setDataZatrudnienia(dataZatrudnienia);
    }

    public int getIloscNadgodzin() {
        return iloscNadgodzin;
    }

    public void setIloscNadgodzin(int iloscNadgodzin) {
        this.iloscNadgodzin = iloscNadgodzin;
    }
}
