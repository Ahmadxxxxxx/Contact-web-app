import javax.swing.*;
import java.awt.*;
public class viewcontactButtonFrame extends JFrame {
    JLabel lbl1,lbl2,fnlbl,lnlbl,citylbl,phonelbl,contactgroupslbl;
    JTextField textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,textField9;
    JPanel pnl1;
    JList<contact> contactlst2;
    DefaultListModel<contact> contactlstmdl2;
    JCheckBox nogroupckb,familyckb,friendsckb,coworkerckb;
    static contact c;

    public viewcontactButtonFrame(contact c){
        
        setTitle("view contact");
        setSize(600,400);
        lbl1=new JLabel("Gestion des contacts");
        lbl1.setFont(new Font("Serif", Font.BOLD, 26));
        lbl1.setForeground(Color.blue);

        lbl2=new JLabel("view Contact");
        lbl2.setFont(new Font("Serif", Font.BOLD, 20));
        lbl2.setForeground(Color.red);

        fnlbl=new JLabel("First name");
        fnlbl.setFont(new Font("Serif",Font.BOLD,15));

        lnlbl=new JLabel("Last name");
        lnlbl.setFont(new Font("Serif",Font.BOLD,15));

        citylbl=new JLabel("City");
        citylbl.setFont(new Font("Serif",Font.BOLD,15));

        phonelbl=new JLabel("Phone numbers");
        contactgroupslbl=new JLabel("Contact Groups");

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

        pnl1=new JPanel();
        pnl1.setLayout(null);
        pnl1.add(lbl1).setBounds(160, 5, 300,30 );
        pnl1.add(lbl2).setBounds(10,70,300,30);
        pnl1.add(fnlbl).setBounds(207,38,100,30);
        pnl1.add(lnlbl).setBounds(207,60,100,30);
        pnl1.add(citylbl).setBounds(207,83,100,30);
        pnl1.add(textField1).setBounds(280,43,280,20);
        textField1.setEditable(false);
        pnl1.add(textField2).setBounds(280,69,280,20);
        textField2.setEditable(false);
        pnl1.add(textField3).setBounds(240,95,320,20);
        textField3.setEditable(false);
        pnl1.add(phonelbl).setBounds(335,110,120,30);
        pnl1.add(textField4).setBounds(207,135,185,20);
        
        textField4.setEditable(false);
        pnl1.add(textField5).setBounds(391,135,185,20);
        textField5.setEditable(false);
        pnl1.add(textField6).setBounds(207,154,185,20);
        textField6.setEditable(false);
        pnl1.add(textField7).setBounds(391,154,185,20);
        textField7.setEditable(false);
        pnl1.add(textField8).setBounds(207,173,185,20);
        textField8.setEditable(false);
        pnl1.add(textField9).setBounds(391,173,185,20);
        textField9.setEditable(false);
        pnl1.add(contactgroupslbl).setBounds(330,185,185,30);

        pnl1.add(nogroupckb).setBounds(335,208,100,25);
        
        pnl1.add(familyckb).setBounds(335,233,100,25);
        pnl1.add(friendsckb).setBounds(335,258,100,25);
        pnl1.add(coworkerckb).setBounds(335,283,100,25);

        contactlstmdl2=new DefaultListModel<contact>();
        contactlst2=new JList<contact>(contactlstmdl2);
        contactlst2.setBackground(Color.CYAN);
        pnl1.add(contactlst2).setBounds(127,38,70,330);
        add(pnl1);
        textField1.setText(c.FirstName);
        textField2.setText(c.LastName);
        textField3.setText(c.City);


    }
    public static void main(String[] args) {
        viewcontactButtonFrame vcbf= new viewcontactButtonFrame(c);
        vcbf.setVisible(true);
        vcbf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
