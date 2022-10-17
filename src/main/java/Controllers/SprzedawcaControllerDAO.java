package Controllers;

import DAO.DAOGeneric;
import Models.Sprzedawca;

import java.util.List;

public class SprzedawcaControllerDAO {
    private DAOGeneric<Sprzedawca> sprzedawcaDAO = new DAOGeneric<Sprzedawca>(Sprzedawca.class);
    public List<Sprzedawca> getAll(){
        return sprzedawcaDAO.getAll();
    }

    public Sprzedawca update(Sprzedawca sprzedawca){
        return sprzedawcaDAO.update(sprzedawca);
    }

    public void add(Sprzedawca sprzedawca){
        sprzedawcaDAO.add(sprzedawca);
    }

    public void remove(Sprzedawca sprzedawca){
        sprzedawcaDAO.remove(sprzedawca);
    }
}
