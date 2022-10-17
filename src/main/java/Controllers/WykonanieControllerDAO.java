package Controllers;

import DAO.DAOGeneric;
import Models.Wykonanie;

import java.util.List;

public class WykonanieControllerDAO {

    private DAOGeneric<Wykonanie> wykonanieDAO = new DAOGeneric<Wykonanie>(Wykonanie.class);
    public List<Wykonanie> getAll(){
        return wykonanieDAO.getAll();
    }

    public Wykonanie update(Wykonanie wykonanie){
        return wykonanieDAO.update(wykonanie);
    }

    public void add(Wykonanie wykonanie){
        wykonanieDAO.add(wykonanie);
    }

    public void remove(Wykonanie wykonanie){
        wykonanieDAO.remove(wykonanie);
    }

}
