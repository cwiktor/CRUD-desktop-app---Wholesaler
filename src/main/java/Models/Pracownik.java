package Models;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pracownik extends Osoba{

    private String pesel;
    private LocalDate dataZatrudnienia;
    private float pensja;
    private static final int minimalnyWiek = 18;
    protected Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, String email, String pesel, LocalDate dataZatrudnienia, float pensja) {
        super(imie, nazwisko, email);
        setPesel(pesel);
        setDataZatrudnienia(dataZatrudnienia);
        setPensja(pensja);
    }

    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public float getPensja() {
        return pensja;
    }
    public void setPensja(float pensja) {
        this.pensja = pensja;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }
    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public int obliczStazPracy(){
        return LocalDate.now().getYear() - dataZatrudnienia.getYear();
    }

}
