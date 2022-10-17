package Models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Entity
public class Zamowienie {

    private Long id;
    private float wartosc;
    private LocalDate dataZlozenia;
    private LocalDate dataRealizacji;
    private Sprzedawca sprzedawca;
    private Klient klient;
    private List<Wykonanie> wykonania = new ArrayList<>();
    private List<Panel> panele = new ArrayList<>();
    private List<Raport> raporty = new Vector<Raport>();

    protected Zamowienie() {
    }
    public Zamowienie(float wartosc, LocalDate dataZlozenia, LocalDate dataRealizacji) {
        setWartosc(wartosc);
        setDataZlozenia(dataZlozenia);
        setDataRealizacji(dataRealizacji);
    }

    @Id
    @GeneratedValue(generator="increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getWartosc() {
        return wartosc;
    }
    public void setWartosc(float wartosc) {
        this.wartosc = wartosc;
    }

    public LocalDate getDataZlozenia() {
        return dataZlozenia;
    }
    public void setDataZlozenia(LocalDate dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }
    public LocalDate getDataRealizacji() {
        return dataRealizacji;
    }
    public void setDataRealizacji(LocalDate dataRealizacji) {
        this.dataRealizacji = dataRealizacji;
    }

    @OneToMany (mappedBy = "zamowienie",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Wykonanie> getWykonania() {
        return wykonania;
    }

    public void setWykonania(List<Wykonanie> wykonania) {
        this.wykonania = wykonania;
    }
    public void addPanel(Panel panel){
        if(!panele.contains(panel)){
            panele.add(panel);
            panel.setZamowienie(this);
        }
    }
    public void addWykonanie(Wykonanie wykonanie){
        if(!wykonania.contains(wykonanie)){
            wykonania.add(wykonanie);
            wykonanie.setZamowienie(this);
        }
    }

    @ManyToOne
    public Sprzedawca getSprzedawca() {
        return sprzedawca;
    }
    public void setSprzedawca(Sprzedawca sprzedawca) {
        if(this.sprzedawca!=sprzedawca){
            if(this.sprzedawca != null){
                this.sprzedawca.removeZamowienie(this);
            }
            this.sprzedawca=sprzedawca;
            sprzedawca.addZamowienie(this);
        }
    }

    @ManyToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        if(this.klient!=klient){
            if(this.klient != null){
                this.klient.removeZamowienie(this);
            }
            this.klient=klient;
            klient.addZamowienie(this);
        }
    }

    @OneToMany(mappedBy = "zamowienie",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Panel> getPanele() {
        return panele;
    }

    public void setPanele(List<Panel> panele) {
        this.panele = panele;
    }

    public void removeWykonanie(Wykonanie w){
        wykonania.remove(w);
    }

    public void removePanel(Panel panel){
        panele.remove(panel);
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                ", wartosc " + wartosc +
                //", sprzedawca " + sprzedawca.getImie() +
                '}';
    }

    @OneToMany(mappedBy = "zamowienie",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Raport> getRaporty() {
        return raporty;
    }

    public void setRaporty(List<Raport> raporty) {
        this.raporty = raporty;
    }

    public Raport utworzRaport(String opis){
        Raport raport = new Raport(opis);
        raport.setZamowienie(this);
        raporty.add(raport);
        return raport;
    }
    @Entity(name = "Raport")
    public static class Raport{
        protected Raport() {
        }
        private Long id;
        @ManyToOne
        private Zamowienie zamowienie;
        private String opis;
        private Raport(String opis) {
            setOpis(opis);
        }

        @Id
        @GeneratedValue(generator="increment")
        public Long getId() {
            return id;
        }

        @ManyToOne
        public Zamowienie getZamowienie() {
            return zamowienie;
        }

        public void setZamowienie(Zamowienie zamowienie) {
            this.zamowienie = zamowienie;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOpis() {
            return opis;
        }
        public void setOpis(String opis) {
            this.opis = opis;
        }

        @Override
        public String toString() {
            return "opis='" + getOpis() + " " ;
        }
    }

    public void minusRabat(){
        if(this.klient.isCzyRabat()){
            wartosc=wartosc-(wartosc*0.15f);
        }
    }

}
