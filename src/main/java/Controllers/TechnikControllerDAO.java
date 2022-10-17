package Controllers;

import DAO.DAOGeneric;
import Models.Technik;

import java.util.List;

public class TechnikControllerDAO {

    private DAOGeneric<Technik> technikDAO = new DAOGeneric<Technik>(Technik.class);

    public List<Technik> getAll(){
        return technikDAO.getAll();
    }

    public Technik update(Technik technik){
        return technikDAO.update(technik);
    }

    public void add(Technik technik){
        technikDAO.add(technik);
    }

    public void remove(Technik technik){
        technikDAO.remove(technik);
    }

}
