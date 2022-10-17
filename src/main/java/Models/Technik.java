package Models;

import Config.HibernateConfig;
import Controllers.TechnikControllerDAO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Technik extends Pracownik{

    private List<String> specjalizacje; // atrybut powtarzalny
    @OneToMany(mappedBy = "technik",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wykonanie> wykonania = new ArrayList<>();

    protected Technik() {
    }
    public Technik(String imie, String nazwisko, String email, String pesel, LocalDate dataZatrudnienia, float pensja, List<String> specjalizacje) {
        super(imie, nazwisko, email, pesel, dataZatrudnienia, pensja);
        setSpecjalizacje(specjalizacje);
    }

    public void addWykonanie(Wykonanie wykonanie){
        if(!wykonania.contains(wykonanie)){
            wykonania.add(wykonanie);
            wykonanie.setTechnik(this);
        }
    }

    @OneToMany(mappedBy = "technik",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Wykonanie> getWykonania() {
        return wykonania;
    }

    public void setWykonania(List<Wykonanie> wykonania) {
        this.wykonania = wykonania;
    }

    @ElementCollection(targetClass=String.class)
    public List<String> getSpecjalizacje() {
        return specjalizacje;
    }
    public void setSpecjalizacje(List<String> specjalizacje) {
        this.specjalizacje = specjalizacje;
    }

    public static void showWolnyTechnik(){
        HibernateConfig.StartHibernateConfiguration();
        TechnikControllerDAO technikControllerDAO = new TechnikControllerDAO();
        for(Technik technik: technikControllerDAO.getAll()){
            if(technik.getWykonania().size()==0){
                System.out.println("Wolny: "+technik.getNazwisko());
            }
        }
    }

    public void removeWykonanie(Wykonanie w){
        wykonania.remove(w);
    }

}
