import java.awt.Color;
import java.awt.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.*;
public class addnewgroupbuttonframe extends JFrame {
    JLabel lbl1,lbl2,lbl3,lbl4;
    JPanel pnl;
    JList<group> list;
    DefaultListModel<group> lstmdl;
    JButton savegroupbtn,cancelbtn;
    JTextField field1,field2;
    JTable table;
    DefaultTableModel tblmdl;
    JOptionPane Opane;
    JScrollPane Spane;
    contactApp CA;


    addnewgroupbuttonframe(){
        //super();
        setTitle("add group");
        setSize(600,400);
        
        lbl1=new JLabel("Gestion des contacts");
        lbl1.setFont(new Font("Serif", Font.BOLD, 26));
        lbl1.setForeground(Color.BLUE);

        lbl2=new JLabel("Add new Group");
        lbl2.setFont(new Font("Serif",Font.BOLD,26));
        lbl2.setForeground(Color.RED);

        lbl3=new JLabel("Group name");
        lbl3.setFont(new Font("Serif",Font.BOLD,15));

        lbl4=new JLabel("Description");
        lbl4.setFont(new Font("Serif",Font.BOLD,15));

        
        lstmdl=new DefaultListModel<group>();
        list=new JList<group>(lstmdl);
        list.setBackground(Color.cyan);


        savegroupbtn=new JButton("Save Group");
        cancelbtn=new JButton("cancel");
        field1=new JTextField("");
        field2=new JTextField("");
       String[] column={"contact name","city","Add to group"};
       Object[][] data=new Object[15][3];

        tblmdl=new DefaultTableModel(data,column);
        table=new JTableExtension(tblmdl);

add(new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)).setBounds(245,100,290,300);
	 	
       /* String[] columnNames = {"FirstName","LastName","Sport","#OfYears","Vegetarian"};
Object[][] data = {
{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
{"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
{"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
{"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)} };
final JTable table = new JTable(data, columnNames);
JScrollPane spane = new JScrollPane(table);*/
        pnl=new JPanel();
        pnl.setLayout(null);//hayde bet7ota men ba3ed ma bet7ot el elements ya bhim mesh awal shi
        pnl.add(lbl1).setBounds(190, 5, 300, 30);
        pnl.add(lbl2).setBounds(5, 80, 180, 30);
        pnl.add(list).setBounds(195,38,40,330);
        pnl.add(lbl3).setBounds(245, 40, 100, 30);
        pnl.add(lbl4).setBounds(245,72,100,30);
        pnl.add(field1).setBounds(330, 45, 254, 20);
        pnl.add(field2).setBounds(329,79,255,20);
        pnl.add(savegroupbtn).setBounds(10,120,106,30);
        pnl.add(cancelbtn).setBounds(10,170,77,30);
        //pnl.add(table).setBounds(245,100,290,300);
        //pnl.add(spane);

        
        add(pnl);
        //pnl.add(new JScrollPane(table));//hek bte5tefe kel el table
        cancelbtnListener cbl=new cancelbtnListener();
        cancelbtn.addActionListener(cbl);

    }
    private final class JTableExtension extends JTable {
        private JTableExtension(TableModel dm) {
            super(dm);
        }

        @Override
        public Class getColumnClass(int column) {
        switch (column) {
        case 0: return String.class;
        case 1: return String.class;
        default: return Boolean.class;}
    }
    }
    class cancelbtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           
                    int response =JOptionPane.showConfirmDialog(null, "Vous voulez quittez cette page?","Confirm message", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if (response==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                    else{
                        
                    }
                }
            };
    
    public void update(){
        
    }
    public static void main(String[] args) {
        addnewgroupbuttonframe angbf= new addnewgroupbuttonframe();
        angbf.setVisible(true);
        angbf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
