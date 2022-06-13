package Method;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Demo extends JFrame 
{
  public Demo() 
  {
    //Headers for JTable
    String[] columns = {"Id", "Name", "Address", "Available"};

    //data for JTable in a 2D table
    Object[][] data = {
      {1, "Thomas", "Alaska", true },
      {2, "Jean", "Arizona", true },
      {3, "Yohan", "California", false },
      {4, "Emily", "Florida", false }
    };

    DefaultTableModel model = new DefaultTableModel(data,columns);

    JTable table = new JTable(model) {
      public Class getColumnClass(int column) {
        //return Boolean.class
        return getValueAt(0, column).getClass(); 
      }
    };

    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane);
//
//    JLabel labelHead = new JLabel("List of employees");
//    labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
//    getContentPane().add(labelHead,BorderLayout.PAGE_START);
  }

  public static void main(String[] args) 
  {
    Demo frame = new Demo();  
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setVisible(true);
  }
}