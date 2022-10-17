package Controllers;

import DAO.DAOGeneric;
import Models.Panel;

import java.util.List;

public class PanelControllerDAO {
    private DAOGeneric<Panel> panelDAO = new DAOGeneric<Panel>(Panel.class);

    public List<Panel> getAll(){
        return panelDAO.getAll();
    }

    public Panel update(Panel panel){
        return panelDAO.update(panel);
    }

    public void add(Panel panel){
        panelDAO.add(panel);
    }

    public void remove(Panel panel){
        panelDAO.remove(panel);
    }

}
