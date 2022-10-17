package Controllers;

import DAO.DAOGeneric;
import Models.Zamowienie;

import java.util.List;

public class ZamowienieControllerDAO {
    private DAOGeneric<Zamowienie> zamowienieDAO = new DAOGeneric<Zamowienie>(Zamowienie.class);

    public List<Zamowienie> getAll(){
        return zamowienieDAO.getAll();
    }
    public Zamowienie update(Zamowienie zamowienie){
        return zamowienieDAO.update(zamowienie);
    }

    public void add(Zamowienie zamowienie){
        zamowienieDAO.add(zamowienie);
    }

    public void remove(Zamowienie zamowienie){
        zamowienieDAO.remove(zamowienie);
    }

}
