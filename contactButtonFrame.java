
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class contactButtonFrame extends JFrame implements Myobserver{
private ArrayList<contact> contactsNames=new ArrayList<contact>();
    JLabel lbl1,lbl2,lbl3;
    JPanel pnl1;
    JButton sbfnbtn,sblnbtn,sbcbtn,addcontactbtn,viewbtn,updatebtn,deletebtn;
    JList<contact> contactlst;
    JList<contact> contactlst2;
    Set<contact>contactSET;

    DefaultListModel<contact> contactlstmdl;
    DefaultListModel<contact> contactlstmdl2;
    JTextField textfield;
    JScrollPane scrollpane;
    contact contact;
    boolean changed;
    contactApp CA;
    //contact[] cons;//mariam code 

     public contactButtonFrame(){


        //do not use super here ffs
        super();
        setTitle("contacts");
        setSize(600,400);
        contactSET=new TreeSet<contact>();
        lbl1=new JLabel("Contacts");
        lbl1.setFont(new Font("Serif", Font.BOLD, 20));
        lbl1.setForeground(Color.red);
        lbl2=new JLabel("Gestion des Contacts");
        lbl2.setFont(new Font("Serif", Font.BOLD, 20));
        lbl2.setForeground(Color.blue);
        lbl3=new JLabel("Search");
        lbl3.setFont(new Font("Serif",Font.BOLD,15));
        
        sbfnbtn=new JButton("Sort by First Name");
        sblnbtn=new JButton("Sort by Last Name");
        sbcbtn=new JButton("Sort by City");
        addcontactbtn=new JButton("Add new contact");
        viewbtn=new JButton("View");
        updatebtn=new JButton("Update");
        deletebtn=new JButton("Delete");
       
        textfield=new JTextField("");

        pnl1=new JPanel();
        pnl1.setLayout(null);
        pnl1.add(lbl1).setBounds(10,39,150,30);
        pnl1.add(lbl2).setBounds(220,5,200,30);
        pnl1.add(lbl3).setBounds(278,38,70,30);
        pnl1.add(sbfnbtn).setBounds(10,95,150,25);
        pnl1.add(sblnbtn).setBounds(10,150,150,25);
        pnl1.add(sbcbtn).setBounds(10,205,150,25);
        pnl1.add(addcontactbtn).setBounds(10,260,150,25);
        pnl1.add(viewbtn).setBounds(310,328,70,25);
        pnl1.add(updatebtn).setBounds(390,328,80,25);
        pnl1.add(deletebtn).setBounds(480,328,80,25);
      

        contactlstmdl=new DefaultListModel<contact>();
        contactlstmdl2=new DefaultListModel<contact>();
        
        contactlst=new JList<contact>(contactlstmdl); 
        contactlst2=new JList<contact>(contactlstmdl2);
        contactlst2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//mariam code
        scrollpane=new JScrollPane(contactlst2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//mariam code
        
        contactlst.setBackground(Color.CYAN);
        pnl1.add(contactlst).setBounds(170, 38, 106,328);
        pnl1.add(contactlst2).setBounds(310,80,237,210);
        pnl1.add(textfield).setBounds(325,48,255,17);
        add(pnl1);

        addnewcontactbtnListener ancbl=new addnewcontactbtnListener();
        addcontactbtn.addActionListener(ancbl);
        viewcontactbtnListener vcbl=new viewcontactbtnListener();
        viewbtn.addActionListener(vcbl);
    
    
/*readbtn.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        try {
            File contactFL = new File("contacts.txt");
            if(!contactFL.exists()) contactFL.createNewFile();
                 else {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(contactFL));
                    contactSET = (Set) ois.readObject();
                    populatecontact();
                    ois.close();
                                }
                            }
        catch(IOException ioe) { }
        catch(ClassCastException cce) { }
        catch(ClassNotFoundException cnfe) { }
         
                    
    }

});*/
     }

  
    /*public void populatecontact() {
        //contactlstmdl2.clear();//men mariam
        Iterator<contact> it = contactSET.iterator();
          while(it.hasNext()) contactlstmdl2.addElement(it.next());
         contactlst2.setModel(contactlstmdl2);
                }*/


    public java.util.List <String> readFromFile(){
        try{
            return Files.readAllLines(Paths.get("C:\\Users\\notAhmad\\javaproject\\contacts.txt"));
        }
        catch(Exception IO){
            JOptionPane.showMessageDialog(null, "eror:"+IO);
            return null;
        }

    }
    public void ListPopulation(){
        for(int i=0;i<(readFromFile().toArray()).length;i++){
            contactsNames.add((contact )(readFromFile().toArray()[i]));
            //contactlstmdl2.setListData(contactsNames.toArray());
            //contactlst2.setListData(contactsNames.toArray());
            
            
        }
    }

    //search method 
    /*public void searchlist(KeyEvent e){
        JTextField textField =(JTextField) e.getSource();
        String text=textField.getText().toLowerCase();
        int n=text.length();
        List<Contact
    }*/

   

    class addnewcontactbtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            addnewcontactButtonFrame addnewcontactButtonFrame=new addnewcontactButtonFrame(CA);
            addnewcontactButtonFrame.setBounds( 0, 0, 600, 400 );
            addnewcontactButtonFrame.setVisible( true );

        }
    }

    class viewcontactbtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewcontactButtonFrame viewcontactButtonFrame=new viewcontactButtonFrame(contactlst2.getSelectedValue());
            viewcontactButtonFrame.setBounds(0,0,600,400);
            viewcontactButtonFrame.setVisible(true);
        }
    }

   
    public void update(){
        update();
    }
    public static void main(String[] args) {
    
        contactButtonFrame cbf= new contactButtonFrame();
        cbf.setVisible(true);
        cbf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
