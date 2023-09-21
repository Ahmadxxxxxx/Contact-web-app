import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import org.w3c.dom.events.MouseEvent;

import java.awt.event.*;
public class groupButtonFrame extends JFrame implements Myobserver{
    JLabel lbl1,lbl2,lbl3;
    JPanel pnl1;
    JButton addnewgroupbtn,updategroupbtn,deletegroupbtn;
    JList<contact> contactlst;
    DefaultListModel<contact> contactlstmdl;
    DefaultTableModel gtblmdl;
    JTable table;
    JScrollPane pane;
    public groupButtonFrame(){
        super();
        setTitle("groups");
        setSize(600,400);
        lbl1=new JLabel("Groups");
        lbl1.setFont(new Font("Serif", Font.BOLD, 25));
        lbl1.setForeground(Color.red);
        lbl2=new JLabel("Gestion des Contacts");
        lbl2.setFont(new Font("Serif", Font.BOLD, 25));
        lbl2.setForeground(Color.blue);
        lbl3=new JLabel("List of Groups");
        lbl3.setFont(new Font("Serif",Font.BOLD,15));
        addnewgroupbtn=new JButton("Add new Group");
        updategroupbtn=new JButton("Update Group");
        deletegroupbtn=new JButton("Delete");


    
       
        Object[][] data={{"family","2"},{"university","2"},{"co-worker","2"},{"chicks","12"},{"hoes","22"}};
        table=new JTable();
        Object[] columns={"Group Names","Nb of Contacts"};
        
        gtblmdl=new DefaultTableModel(data,columns);
        gtblmdl.setColumnIdentifiers(columns);
        table.setModel(gtblmdl);
       
        table.setRowHeight(30);
        pane=new JScrollPane(table);
        //pane.setBounds(575, 100, 21, 50);

        
        pnl1=new JPanel();
        pnl1.setLayout(null);
        pnl1.add(lbl1).setBounds(10,59,200,30);
        pnl1.add(lbl2).setBounds(210,5,300,30);
        pnl1.add(lbl3).setBounds(415,40,100,25);
        pnl1.add(addnewgroupbtn).setBounds(10,130,180,25);
        pnl1.add(updategroupbtn).setBounds(363,325,127,25);
        pnl1.add(deletegroupbtn).setBounds(495,325,85,25);
        contactlstmdl=new DefaultListModel<contact>();
        contactlst=new JList<contact>(contactlstmdl); 
        contactlst.setBackground(Color.CYAN);
        pnl1.add(contactlst).setBounds(205,36,155,325);
        pnl1.add(table).setBounds(375,100,210,100);//375 100 210 100
        pnl1.add(pane);
        add(pnl1);
        deletebtnlistener dbl=new deletebtnlistener();
        deletegroupbtn.addActionListener(dbl);
        addnewgroupbuttonlistener angbl=new addnewgroupbuttonlistener();
        addnewgroupbtn.addActionListener(angbl);
    }
    class deletebtnlistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int i=table.getSelectedRow();
            int response =JOptionPane.showConfirmDialog(null, "Vous voulez supprimer ce groupe?","Confirm message", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (response==JOptionPane.YES_OPTION){
                
            //if(i>=0){
                gtblmdl.removeRow(i);
            }
            else{

            }
    }
}
    class addnewgroupbuttonlistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            addnewgroupbuttonframe addnewgroupbuttonframe=new addnewgroupbuttonframe();
            addnewgroupbuttonframe.setBounds( 0, 0, 600, 400 );
            addnewgroupbuttonframe.setVisible( true );
        }
    }

   
    




/*public void mouseClicked(MouseEvent e){//in case lal table el tene lamma tekbos 3a item bel table be3alliim bel textfield
        int i=table.getSelectedRow();
        textid.setText(gtblmdl.getValueAt(i,0).toString());
        textFname.setText(gtblmdl.getValueAt(i,0).toString());
        textLname.setText(gtblmdl.getValueAt(i,0).toString());
        textCity.setText(gtblmdl.getValueAt(i,0).toString());
        
    }*/
   
    
    @Override
    public void update() {
        
    }
    public static void main(String[] args) {
        groupButtonFrame gbf= new groupButtonFrame();
        gbf.setVisible(true);
        gbf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
}
