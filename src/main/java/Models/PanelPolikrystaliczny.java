package Models;

import javax.persistence.Entity;

@Entity
public class PanelPolikrystaliczny extends Panel{
    private boolean czyJestDotacja;

    private final float wysokoscDotacji = 2/10;

    protected PanelPolikrystaliczny(){}
    public PanelPolikrystaliczny(Panel p, boolean czyJestDotacja){
        super(p.wydajnosc, p.powierzchnia, p.typPanelu);
        setCzyJestDotacja(czyJestDotacja);
        setTypPanelu(typPanelu);
        setCiezar(p.getCiezar());
        setTypStelazu(p.getTypStelazu());
    }

    public boolean isCzyJestDotacja() {
        return czyJestDotacja;
    }
    public void setCzyJestDotacja(boolean czyJestDotacja) {
        this.czyJestDotacja = czyJestDotacja;
    }

}
