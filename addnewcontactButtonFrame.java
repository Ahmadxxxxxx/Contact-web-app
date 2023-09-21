import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import java.util.Set;
import java.util.TreeSet;
//import javax.swing.event.*;




public class addnewcontactButtonFrame extends JFrame {//shelet implement my observer
    JLabel lbl1,lbl2,fnlbl,lnlbl,citylbl,phonelbl,addgrouplbl;
    JTextField textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,textField9;
    JPanel pnl1;
    JList<contact> contactlst2;
    DefaultListModel<contact> contactlstmdl2;
    JCheckBox nogroupckb,familyckb,friendsckb,coworkerckb;
    JButton savebtn,cancelbtn;
    JOptionPane optionPane;
    Set<contact> contactSET;
    contact contact;//object men no3 contact lezim ykoun mawjoud be2alb el V men el M V C
    /*DefaultTableModel tblMDL;
    JTable contacttbl;//bye5od kel el types*/
     static contactApp CA;//la2ano hayda controller w controller modifies the view 

    

    public addnewcontactButtonFrame(contactApp A){
        //do not usee super here ffs
        super();
        CA=A;
        setTitle("add contact");
        setSize(600,400);
        contactSET = new TreeSet<contact>();
        lbl1=new JLabel("Gestion des contacts");
        lbl1.setFont(new Font("Serif", Font.BOLD, 26));
        lbl1.setForeground(Color.blue);

        lbl2=new JLabel("New Contact");
        lbl2.setFont(new Font("Serif", Font.BOLD, 20));
        lbl2.setForeground(Color.red);

        fnlbl=new JLabel("First name");
        fnlbl.setFont(new Font("Serif",Font.BOLD,15));

        lnlbl=new JLabel("Last name");
        lnlbl.setFont(new Font("Serif",Font.BOLD,15));

        citylbl=new JLabel("City");
        citylbl.setFont(new Font("Serif",Font.BOLD,15));

        phonelbl=new JLabel("Phone numbers");
        addgrouplbl=new JLabel("Add the contact to Groups");
        

        textField1=new JTextField("");
        textField2=new JTextField("");
        textField3=new JTextField("");
        textField4=new JTextField("                 Region Code");
        textField5=new JTextField("                 Phone number");
        textField6=new JTextField("");
        textField7=new JTextField("");
        textField8=new JTextField("");
        textField9=new JTextField("");

        nogroupckb=new JCheckBox("No Groups");
        familyckb=new JCheckBox("Family");
        friendsckb=new JCheckBox("Friends");
        coworkerckb=new JCheckBox("co-workers");

        savebtn=new JButton("Save");
        cancelbtn=new JButton("Cancel");
      

        /*Object[] columnName={"Region code","Phone number"};
        Object[][] dataRows;
        


        tblMDL=new DefaultTableModel(dataRows,columnName);
        

        contacttbl=new JTable(tblMDL){
            public boolean editCellAt(int row,int column,java.util.EventObject e){
                return false;//mana3na kel el edits 3an el table
            }
        };
        contacttbl.setModel(tblMDL);*/

        pnl1=new JPanel();
        pnl1.setLayout(null);
        pnl1.add(lbl1).setBounds(160, 5, 300,30 );
        pnl1.add(lbl2).setBounds(10,70,300,30);
        pnl1.add(fnlbl).setBounds(207,38,100,30);
        pnl1.add(lnlbl).setBounds(207,60,100,30);
        pnl1.add(citylbl).setBounds(207,83,100,30);
        pnl1.add(textField1).setBounds(280,43,280,20);
        pnl1.add(textField2).setBounds(280,69,280,20);
        pnl1.add(textField3).setBounds(240,95,320,20);
        pnl1.add(phonelbl).setBounds(335,110,120,30);
        pnl1.add(textField4).setBounds(207,135,185,20);
        textField4.setEditable(false);
        pnl1.add(textField5).setBounds(391,135,185,20);
        textField5.setEditable(false);
        pnl1.add(textField6).setBounds(207,154,185,20);
        textField6.setEditable(true);
        pnl1.add(textField7).setBounds(391,154,185,20);
        textField7.setEditable(true);
        pnl1.add(textField8).setBounds(207,173,185,20);
        textField8.setEditable(true);
        pnl1.add(textField9).setBounds(391,173,185,20);
        textField9.setEditable(true);
        pnl1.add(addgrouplbl).setBounds(330,185,185,30);

        pnl1.add(nogroupckb).setBounds(335,208,100,25);
        nogroupckb.setSelected(true);
        pnl1.add(familyckb).setBounds(335,233,100,25);
        pnl1.add(friendsckb).setBounds(335,258,100,25);
        pnl1.add(coworkerckb).setBounds(335,283,100,25);
        pnl1.add(savebtn).setBounds(330,320,70,25);
        pnl1.add(cancelbtn).setBounds(404,320,80,25);
        

        contactlstmdl2=new DefaultListModel<contact>();
        contactlst2=new JList<contact>(contactlstmdl2);
        contactlst2.setBackground(Color.CYAN);
        pnl1.add(contactlst2).setBounds(127,38,70,330);
        //pnl1.add(contacttbl).setBounds(270,200,110,30);
        add(pnl1);
    
        //ButtonHandler bh=new ButtonHandler();
        //cancelbtn.addActionListener(bh);
        //savebtn.addActionListener(bh);

    

        savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if((textField1.getText().equals("")) || (textField2.getText().equals(""))|| textField6.getText().equals("")||textField7.getText().equals("")) {JOptionPane.showMessageDialog(null,"Un contact doit avoir un nom, un prenom et un numero telephone" ,"Error message",JOptionPane.ERROR_MESSAGE);}
                ArrayList<contact[]>h=new ArrayList<contact[]>();
                contact c=new contact(textField1.getText(),textField2.getText(),textField3.getText(),h);
                contactlstmdl2.addElement(c);
                }
			
			}
            
            
		);

        cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int response =JOptionPane.showConfirmDialog(null, "Vous voulez quittez cette page?","Confirm message", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (response==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                else{
                    
                }
            }
        });}
    

       
    
    
       public static void main(String[] args) {
        addnewcontactButtonFrame ancbf= new addnewcontactButtonFrame(CA);
        ancbf.setVisible(true);
        ancbf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
