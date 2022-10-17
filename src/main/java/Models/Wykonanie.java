package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Wykonanie {

    private Long id;
    private LocalDate dataOd;
    private LocalDate dataDo;

    private Technik technik;

    private Zamowienie zamowienie;

    protected Wykonanie() {
    }

    public Wykonanie(LocalDate dataOd, LocalDate dataDo) {
        this.dataOd = dataOd;
        this.dataDo = dataDo;
    }

    @Id
    @GeneratedValue(generator="increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataOd() {
        return dataOd;
    }

    public void setDataOd(LocalDate dataOd) {
        this.dataOd = dataOd;
    }

    public LocalDate getDataDo() {
        return dataDo;
    }

    public void setDataDo(LocalDate dataDo) {
        this.dataDo = dataDo;
    }

    @ManyToOne
    public Technik getTechnik() {
        return technik;
    }
    public void setTechnik(Technik technik) {
        if(this.technik!=technik){
            if(this.technik != null){
                this.technik.removeWykonanie(this);
            }
            this.technik=technik;
            technik.addWykonanie(this);
        }
    }

    @ManyToOne
    public Zamowienie getZamowienie() {
        return zamowienie;
    }
    public void setZamowienie(Zamowienie zamowienie) {
        if(this.zamowienie!=zamowienie){
            if(this.zamowienie != null){
                this.zamowienie.removeWykonanie(this);
            }
            this.zamowienie=zamowienie;
            zamowienie.addWykonanie(this);
        }
    }

    @Override
    public String toString() {
        return "Wykonanie{" +
                "dataOd=" + dataOd +
                ", dataDo=" + dataDo +
                '}';
    }
}
