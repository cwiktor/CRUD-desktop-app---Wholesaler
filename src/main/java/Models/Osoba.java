package Models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Osoba {

    private Long id;
    private String imie;
    private String nazwisko;
    private String email;

    public Osoba() { }

    public Osoba(String imie, String nazwisko, String email){
        setImie(imie);
        setNazwisko(nazwisko);
        setEmail(email);
    }


    @Id
    @GeneratedValue(generator="increment")
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
