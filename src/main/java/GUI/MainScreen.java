package GUI;

import Controllers.ZamowienieControllerDAO;
import Models.Zamowienie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class MainScreen {
    public JPanel Main;
    private JTable tableZamowienia;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton dodajButton;
    private JButton usunButton;
    private JButton edytujButton;
    private JButton szczegolyButton;

    public Zamowienie zamowienieObject;

    public MainScreen() {
        tableLoad();

        tableZamowienia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ZamowienieControllerDAO zamowienieControllerDAO = new ZamowienieControllerDAO();
                int index =tableZamowienia.getSelectedRow();
                zamowienieObject= zamowienieControllerDAO.getAll().get(index);
                textField1.setText(String.valueOf(zamowienieObject.getWartosc()));
                textField2.setText(String.valueOf(zamowienieObject.getDataZlozenia()));
                textField3.setText(String.valueOf(zamowienieObject.getDataRealizacji()));
            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZamowienieControllerDAO zamowienieControllerDAO = new ZamowienieControllerDAO();
                zamowienieControllerDAO.add(new Zamowienie(Float.parseFloat(textField1.getText()), LocalDate.parse(textField2.getText()), LocalDate.parse(textField3.getText())));
                tableLoad();
                setTextsToNull();
            }
        });
        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZamowienieControllerDAO zamowienieControllerDAO = new ZamowienieControllerDAO();
                zamowienieObject.setWartosc(Float.parseFloat(textField1.getText()));
                zamowienieObject.setDataZlozenia(LocalDate.parse(textField2.getText()));
                zamowienieObject.setDataRealizacji(LocalDate.parse(textField3.getText()));
                zamowienieControllerDAO.update(zamowienieObject);
                setTextsToNull();
                tableLoad();
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZamowienieControllerDAO zamowienieControllerDAO = new ZamowienieControllerDAO();
                zamowienieControllerDAO.remove(zamowienieObject);
                setTextsToNull();
                tableLoad();
            }
        });
        szczegolyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame2 = new JFrame("Szczegóły zamówienia");
                if(zamowienieObject != null){
                    jFrame2.setContentPane(new ZamowienieDetails(zamowienieObject).DetailsMain);
                    jFrame2.setSize(500,600);
                    //jFrame2.pack();
                    jFrame2.setVisible(true);
                }
            }
        });
    }

    void tableLoad(){
        ZamowienieControllerDAO zamowienieControllerDAO = new ZamowienieControllerDAO();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Wartość");
        tableModel.addColumn("Data zlozenia");
        tableModel.addColumn("Data Realizacji");
        for(Zamowienie zamowienie: zamowienieControllerDAO.getAll()){
            tableModel.addRow(new Object[]{zamowienie.getId(),zamowienie.getWartosc(), zamowienie.getDataZlozenia(), zamowienie.getDataRealizacji()});
        }
        this.tableZamowienia.setModel(tableModel);
    }

    void setTextsToNull(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }


}
