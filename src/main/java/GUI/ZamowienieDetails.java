package GUI;

import Controllers.ZamowienieControllerDAO;
import Models.Panel;
import Models.Technik;
import Models.Wykonanie;
import Models.Zamowienie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ZamowienieDetails {
    public JPanel DetailsMain;
    private JTable table1;
    private JTextField textField1;
    private JTable table3;
    private JButton zamknijButton;
    private JTable table2;
    private JTextField textField2;
    public Zamowienie zamowienieObject;

    public ZamowienieDetails(Zamowienie zamowienieObject) {
        textField1.setEnabled(false);
        textField2.setEnabled(false);
        table1.setEnabled(false);
        table2.setEnabled(false);
        table3.setEnabled(false);
        this.zamowienieObject=zamowienieObject;

        if(zamowienieObject.getKlient() != null){
            textField1.setText(zamowienieObject.getKlient().getNazwisko());
        }else{
            textField1.setText("BRAK");
        }
        if(zamowienieObject.getSprzedawca() != null){
            textField2.setText(zamowienieObject.getSprzedawca().getNazwisko());
        }else{
            textField2.setText("BRAK");
        }

        tableWykonaniaLoad();
        tableRaportyLoad();
        tablePaneleLoad();
    }

    public void tableWykonaniaLoad(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Data rozpoczęcia");
        tableModel.addColumn("Data zakończenia");
        tableModel.addColumn("Technik");

        for(Wykonanie wykonanie: zamowienieObject.getWykonania()){
            tableModel.addRow(new Object[]{wykonanie.getId(),wykonanie.getDataOd(), wykonanie.getDataDo(), wykonanie.getTechnik().getNazwisko()});
        }
        this.table1.setModel(tableModel);
    }

   public void tableRaportyLoad(){
       DefaultTableModel tableModel = new DefaultTableModel();
       tableModel.addColumn("Id");
       tableModel.addColumn("Opis");
       for(Zamowienie.Raport raport: zamowienieObject.getRaporty()){
           tableModel.addRow(new Object[]{raport.getId(),raport.getOpis()});
       }
       this.table3.setModel(tableModel);
   }

   public void tablePaneleLoad(){
       DefaultTableModel tableModel = new DefaultTableModel();
       tableModel.addColumn("Id");
       tableModel.addColumn("Typ");
       tableModel.addColumn("Rodzaj");
       //System.out.println("OOOOOOOOOOOOOOO:    "+zamowienieObject.getPanele().get(0).getTypPanelu());
       for(Panel panele: zamowienieObject.getPanele()){
           tableModel.addRow(new Object[]{panele.getId(), panele.getTypPanelu(), panele.getClass().getSimpleName()});
       }
       this.table2.setModel(tableModel);
   }



}
