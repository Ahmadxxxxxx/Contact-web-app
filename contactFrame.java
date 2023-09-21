import java.awt.*;
import javax.swing.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class contactFrame extends JFrame {
    JLabel lbl;
    JButton contactbtn,groupbtn;
    JPanel pnl;
    JList<contact> contactlst;
    DefaultListModel<contact> contactlstmdl;

public contactFrame(){
    super();
    setTitle("Projet NFA035");
    setSize(600,400);
    

lbl=new JLabel("Gestions des contacts");
lbl.setForeground(Color.blue);
lbl.setFont(new Font("Serif", Font.BOLD, 20));
contactbtn=new JButton("Contacts");
groupbtn=new JButton("Groups");
pnl=new JPanel();
pnl.setLayout(null);

pnl.add(lbl).setBounds(220,3,220,80);
pnl.add(contactbtn).setBounds(10, 120, 100, 30);
pnl.add(groupbtn).setBounds(10, 200, 100, 30);
add(pnl);

contactlstmdl=new DefaultListModel<contact>();
contactlst=new JList<contact>(contactlstmdl);
contactlst.setBackground(Color.CYAN);
pnl.add(contactlst).setBounds(118, 70, 460,290);


contactbtnLister cbl =new contactbtnLister();
contactbtn.addActionListener(cbl);

groupbtnListener gbl=new groupbtnListener();
groupbtn.addActionListener(gbl);
}

class contactbtnLister implements ActionListener{
    public void actionPerformed(ActionEvent e){
        contactButtonFrame contactButtonFrame = new contactButtonFrame();
        contactButtonFrame.setBounds( 0, 0, 600, 400 );
        contactButtonFrame.setVisible( true );
    }
}
class groupbtnListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        groupButtonFrame groupButtonFrame = new groupButtonFrame();
        groupButtonFrame.setBounds( 0, 0, 600, 400 );
        groupButtonFrame.setVisible( true );
    }
}




public static void main(String[] args) {
    contactFrame cf= new contactFrame();
    cf.setVisible(true);
    cf.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}