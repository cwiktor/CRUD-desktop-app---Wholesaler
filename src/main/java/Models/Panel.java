package Models;


import javax.persistence.*;
import java.util.EnumSet;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Panel {
    private Long id;
    protected int wydajnosc;
    protected float powierzchnia;

    private Zamowienie zamowienie;

    //======== MULTIASPECT
    public enum TypPanelu {Panel, Dachowy, Ziemny}
    public Float ciezar; //dachowy (WIELOASPEKTOWE)
    public String typStelazu; //ziemny (WIELOASPEKTOWE)
    @Enumerated(EnumType.STRING)
    public TypPanelu typPanelu = TypPanelu.Panel;

    protected Panel() {
    }

    public Panel(int wydajnosc, float powierzchnia, TypPanelu typPanelu) {
        setWydajnosc(wydajnosc);
        setPowierzchnia(powierzchnia);
        setTypPanelu(typPanelu);
    }

    public Panel(int wydajnosc, float powierzchnia) {
        setWydajnosc(wydajnosc);
        setPowierzchnia(powierzchnia);
    }

    public static Panel createPanelDachowy(int wydajnosc, float powierzchnia, float ciezar){
        Panel panel = new Panel(wydajnosc,powierzchnia);
        panel.setTypPanelu(TypPanelu.Dachowy);
        panel.setCiezar(ciezar);
        return panel;
    }

    public static Panel createPanelZiemny(int wydajnosc, float powierzchnia, String typStelazu){
        Panel panel = new Panel(wydajnosc,powierzchnia);
        panel.setTypPanelu(TypPanelu.Ziemny);
        panel.setTypStelazu(typStelazu);
        return panel;
    }

    @Id
    @GeneratedValue(generator="increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWydajnosc() {
        return wydajnosc;
    }
    public void setWydajnosc(int wydajnosc) {
        this.wydajnosc = wydajnosc;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Zamowienie getZamowienie() {
        return zamowienie;
    }
    public void setZamowienie(Zamowienie zamowienie) {
        if(this.zamowienie!=zamowienie){
            if(this.zamowienie != null){
                this.zamowienie.removePanel(this);
            }
            this.zamowienie=zamowienie;
            zamowienie.addPanel(this);
        }
    }

    public TypPanelu getTypPanelu() {
        return typPanelu;
    }
    public void setTypPanelu(TypPanelu typPanelu) {
        this.typPanelu = typPanelu;
    }

    public Float getCiezar() {
        return ciezar;
    }
    public void setCiezar(Float ciezar) {
        this.ciezar = ciezar;
    }

    public Float getPowierzchnia() {
        return powierzchnia;
    }
    public void setPowierzchnia(float powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public String getTypStelazu() {
        return typStelazu;
    }
    public void setTypStelazu(String typStelazu) {
        this.typStelazu = typStelazu;
    }

    @Override
    public String toString() {
        return "Panel{" +
                ", |Z.wartosc | " + zamowienie.getWartosc() +
                ", wydajnosc=" + wydajnosc +
                ", powierzchnia=" + powierzchnia +
                ", typPanelu=" + typPanelu +
                '}';
    }
}
