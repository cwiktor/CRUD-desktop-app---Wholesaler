import Config.HibernateConfig;
import GUI.MainScreen;
import Models.*;
import Models.Panel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class Main {
    public static void main(String[] args) {
        startGUI();
        //fillDatabase();
    }
    public static void startGUI(){
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        HibernateConfig.StartHibernateConfiguration();
        //fillDatabase();
        JFrame jFrame = new JFrame("Zamowienie Main Panel");
        jFrame.setContentPane(new MainScreen().Main);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(700,350);
        jFrame.setVisible(true);
    }

    public static void fillDatabase(){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Zamowienie zamowienie1 = new Zamowienie(10000,LocalDate.of(2022,10,10), LocalDate.of(2022,10,11));
            Zamowienie zamowienie2 = new Zamowienie(1123,LocalDate.of(2021,1,11), LocalDate.of(2021,2,1));
            Zamowienie zamowienie3 = new Zamowienie(20000,LocalDate.of(2020,12,12), LocalDate.of(2020,12,12));
            Zamowienie zamowienie4 = new Zamowienie(30202,LocalDate.of(2022,5,5), LocalDate.of(2022,6,5));
            Zamowienie zamowienie5 = new Zamowienie(10001,LocalDate.of(2022,10,10), LocalDate.of(2022,10,11));

            Zamowienie.Raport raport1 = zamowienie1.utworzRaport("zamowienie1 opis1 opis opis");
            Zamowienie.Raport raport2 = zamowienie1.utworzRaport("zamowienie1 opis2 opis opis");
            Zamowienie.Raport raport3 = zamowienie2.utworzRaport("Zamowienie2 opis1 opis opis");
            Zamowienie.Raport raport4 = zamowienie3.utworzRaport("Zamowienie2 opis1 opis opis");

            Adres adres1 = new Adres("Krakowska",11,"00-111", "Polska");
            Adres adres2 = new Adres("11Listopada",17,"00-111", "Polska");
            Adres adres3 = new Adres("Zeromskiego",17,"00-111", "Polska");
            Adres adres4 = new Adres("Koszykowa",17,"00-111", "Polska");

            Klient klient1 = new Klient("Jan", "Kowalski", "kowalski@email.com",adres1,true);
            Klient klient2 = new Klient("Tomasz", "Nowak", "nowak@email.com",adres2,true);
            Klient klient3 = new Klient("Marcin", "Polak", "abascki@email.com",adres3,true);
            Klient klient4 = new Klient("Rafal", "Rafalski", "abc@email.com",adres4,true);

            PanelPolikrystaliczny panelPolikrystaliczny = new PanelPolikrystaliczny(Panel.createPanelDachowy(1,1,1),false);
            PanelPolikrystaliczny panelPolikrystaliczny1= new PanelPolikrystaliczny(Panel.createPanelZiemny(1,1,"stalowy"),false);
            PanelPolikrystaliczny panelPolikrystaliczny2= new PanelPolikrystaliczny(Panel.createPanelDachowy(1,1,1),false);
            PanelPolikrystaliczny panelPolikrystaliczny3= new PanelPolikrystaliczny(Panel.createPanelDachowy(1,1,1),false);
            PanelPolikrystaliczny panelPolikrystaliczny4= new PanelPolikrystaliczny(Panel.createPanelDachowy(1,1,1),false);
            PanelPolikrystaliczny panelPolikrystaliczny5= new PanelPolikrystaliczny(Panel.createPanelDachowy(1,1,1),false);
            PanelPolikrystaliczny panelPolikrystaliczny6= new PanelPolikrystaliczny(Panel.createPanelDachowy(1,1,1),false);
            PanelMonokrystaliczny panelMonokrystaliczny= new PanelMonokrystaliczny(Panel.createPanelDachowy(2,2,12), PanelMonokrystaliczny.BarwaEnum.Czarny);
            PanelMonokrystaliczny panelMonokrystaliczny1= new PanelMonokrystaliczny(Panel.createPanelDachowy(2,2,12), PanelMonokrystaliczny.BarwaEnum.Czarny);
            PanelMonokrystaliczny panelMonokrystaliczny2= new PanelMonokrystaliczny(Panel.createPanelDachowy(2,2,12), PanelMonokrystaliczny.BarwaEnum.Czarny);
            PanelMonokrystaliczny panelMonokrystaliczny3= new PanelMonokrystaliczny(Panel.createPanelZiemny(2,2,"ALUMINIUM"), PanelMonokrystaliczny.BarwaEnum.Czarny);
            PanelMonokrystaliczny panelMonokrystaliczny4= new PanelMonokrystaliczny(Panel.createPanelZiemny(2,2,"ALUMINIUM"), PanelMonokrystaliczny.BarwaEnum.Czarny);
            PanelMonokrystaliczny panelMonokrystaliczny5= new PanelMonokrystaliczny(Panel.createPanelZiemny(2,2,"ALUMINIUM"), PanelMonokrystaliczny.BarwaEnum.Czarny);

            Sprzedawca sprzedawca1 = new Sprzedawca("sMarcin", "sprzedawca1", "sprzedawca@test.com", "123123123", LocalDate.now(),3000, 0, "mazowieckie");
            Sprzedawca sprzedawca2 = new Sprzedawca("sMarcin", "sprzedawca2", "sprzedawca@test.com", "123123123", LocalDate.now(),3000, 0, "mazowieckie");
            Sprzedawca sprzedawca3 = new Sprzedawca("sMarcin", "sprzedawca3", "sprzedawca@test.com", "123123123", LocalDate.now(),3000, 0, "mazowieckie");

            List<String> technik1Specjalizacje = new ArrayList<>();
            technik1Specjalizacje.add("Montaz");
            technik1Specjalizacje.add("Pomiary");

            Technik technik1 = new Technik("tMikolaj", "Malinowski", "malina@test.com", "45678786", LocalDate.of(2005,1,1),3500, technik1Specjalizacje);
            Technik technik2 = new Technik("tMARCIN", "Technicki", "mt@test.com", "2313123", LocalDate.now(),3500, technik1Specjalizacje);

            Wykonanie wykonanie1 = new Wykonanie(LocalDate.of(2022,10,10), LocalDate.of(2022,10,11));
            Wykonanie wykonanie2 = new Wykonanie(LocalDate.of(2021,1,11), LocalDate.of(2021,2,1));
            Wykonanie wykonanie3 = new Wykonanie(LocalDate.of(2020,12,12), LocalDate.of(2020,12,12));
            Wykonanie wykonanie4 = new Wykonanie(LocalDate.of(2022,5,5), LocalDate.of(2022,6,5));
            Wykonanie wykonanie5 = new Wykonanie(LocalDate.of(2022,5,5), LocalDate.of(2022,6,5));
            Wykonanie wykonanie6 = new Wykonanie(LocalDate.of(2022,5,5), LocalDate.of(2022,6,5));

            zamowienie1.addPanel(panelMonokrystaliczny);
            zamowienie1.addPanel(panelMonokrystaliczny2);
            zamowienie1.addPanel(panelMonokrystaliczny3);
            zamowienie1.addPanel(panelPolikrystaliczny);
            zamowienie1.addPanel(panelPolikrystaliczny1);
            zamowienie2.addPanel(panelMonokrystaliczny4);
            zamowienie2.addPanel(panelMonokrystaliczny5);
            zamowienie2.addPanel(panelPolikrystaliczny6);
            zamowienie2.addPanel(panelPolikrystaliczny3);
            zamowienie3.addPanel(panelPolikrystaliczny5);
            zamowienie3.addPanel(panelPolikrystaliczny4);
            zamowienie4.addPanel(panelMonokrystaliczny1);
            zamowienie5.addPanel(panelPolikrystaliczny2);

            wykonanie1.setZamowienie(zamowienie1);
            wykonanie2.setZamowienie(zamowienie1);
            wykonanie4.setZamowienie(zamowienie2);
            wykonanie4.setZamowienie(zamowienie3);
            wykonanie5.setZamowienie(zamowienie4);
            wykonanie6.setZamowienie(zamowienie5);

            wykonanie1.setTechnik(technik1);
            wykonanie2.setTechnik(technik2);
            wykonanie3.setTechnik(technik1);
            wykonanie4.setTechnik(technik2);
            wykonanie5.setTechnik(technik1);
            wykonanie6.setTechnik(technik2);

            zamowienie1.setSprzedawca(sprzedawca1);
            zamowienie2.setSprzedawca(sprzedawca2);
            zamowienie3.setSprzedawca(sprzedawca3);
            zamowienie4.setSprzedawca(sprzedawca3);
            zamowienie5.setSprzedawca(sprzedawca2);

            zamowienie1.setKlient(klient1);
            zamowienie2.setKlient(klient1);
            zamowienie3.setKlient(klient2);
            zamowienie4.setKlient(klient3);
            zamowienie5.setKlient(klient4);

            System.out.println("Staz: "+technik1.obliczStazPracy());

            session.save(zamowienie1);
            session.save(zamowienie2);
            session.save(zamowienie3);
            session.save(zamowienie4);
            session.save(zamowienie5);
            session.save(raport1);
            session.save(raport2);
            session.save(raport3);
            session.save(raport4);
            session.save(adres1);
            session.save(adres2);
            session.save(adres3);
            session.save(adres4);
            session.save(panelMonokrystaliczny);
            session.save(panelMonokrystaliczny1);
            session.save(panelMonokrystaliczny2);
            session.save(panelMonokrystaliczny3);
            session.save(panelMonokrystaliczny4);
            session.save(panelMonokrystaliczny5);
            session.save(panelPolikrystaliczny);
            session.save(panelPolikrystaliczny1);
            session.save(panelPolikrystaliczny2);
            session.save(panelPolikrystaliczny3);
            session.save(panelPolikrystaliczny4);
            session.save(panelPolikrystaliczny5);
            session.save(klient1);
            session.save(klient2);
            session.save(klient3);
            session.save(klient4);
            session.save(technik1);
            session.save(technik2);
            session.save(sprzedawca1);
            session.save(sprzedawca2);
            session.save(sprzedawca3);
            session.save(wykonanie1);
            session.save(wykonanie2);
            session.save(wykonanie3);
            session.save(wykonanie4);
            session.save(wykonanie5);
            session.save(wykonanie6);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
