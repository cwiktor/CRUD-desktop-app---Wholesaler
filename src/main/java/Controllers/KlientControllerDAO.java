package Controllers;

import DAO.DAOGeneric;
import Models.Klient;

import java.util.List;

public class KlientControllerDAO {
    private DAOGeneric<Klient> klientDAO = new DAOGeneric<Klient>(Klient.class);

    public List<Klient> getAll(){
        return klientDAO.getAll();
    }

    public Klient update(Klient klient){
        return klientDAO.update(klient);
    }

    public void add(Klient klient){
        klientDAO.add(klient);
    }

    public void remove(Klient klient){
        klientDAO.remove(klient);
    }

}
