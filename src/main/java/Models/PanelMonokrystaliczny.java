package Models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class PanelMonokrystaliczny extends Panel{

    public enum BarwaEnum {Niebieski, Czarny}
    @Enumerated(EnumType.STRING)
    private BarwaEnum barwa;

    protected PanelMonokrystaliczny() {
    }
    public PanelMonokrystaliczny(Panel p, BarwaEnum barwa) {
        super(p.wydajnosc, p.powierzchnia, p.typPanelu);
        setBarwa(barwa);
        setTypPanelu(typPanelu);
        setCiezar(p.getCiezar());
        setTypStelazu(p.getTypStelazu());
    }

    public BarwaEnum getBarwa() {
        return barwa;
    }

    public void setBarwa(BarwaEnum barwa) {
        this.barwa = barwa;
    }
}
