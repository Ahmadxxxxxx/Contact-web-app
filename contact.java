import java.io.Serializable;
import java.util.*;
//import java.util.TreeSet;

public class contact implements Comparable<contact>,Serializable{//mainly used to sort the arrays (or lists) of custom objects.
    String FirstName;
    String LastName;
    String City;
    ArrayList<contact[]> numbers;
    //private Set <String> number;
    //int regionCode;


public contact(String F,String L,String C ,ArrayList<contact[]>h){
    F=FirstName;
    L=LastName;
    C=City;
    //n=number;
    //r=regionCode;
}
public String toString(){
    
    return FirstName+ " " + LastName + " - " + City ;
}
@Override
public int compareTo(contact c) {// 3am bet2ello 3a ayya ases beddo ysof el objects
    
    return this.FirstName.compareTo(c.FirstName);// ma 7a ta3te shi bas ekbos save
   //return 0;// 7a ta3te null null null 3al lst 2
}

}
 /* ArrayList<contact[]>h=new ArrayList<contact[]>();


				if(textField1.getText().equals("")|| textField2.getText().equals("")||textField6.getText().equals("")|| textField7.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Un contact doit avoir un nom,un prenom et un numero de telephone");
                }
                else {
                    contact c=new contact(textField1.getText(),textField2.getText(),textField3.getText(),h);
                    contactSET.add(c);
                    
                    try {
                        File contactFL = new File("contacts.txt");
                       
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(contactFL));
                        oos.writeObject(contactSET);
                        oos.flush();
                        oos.close();
            
                        
                    }
                    catch(IOException ioe) { }
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");*/
                    /*contactlst2.setModel(contactlstmdl2);
				contact c = new contact(textField1.getText(),textField2.getText(),textField3.getText());

				 contactlstmdl2.addElement(c);
                 String FirstName=textField1.getText();
                 String LastName=textField2.getText();
                 String City=textField3.getText();

                 contact c=new contact(FirstName,LastName,City);

                int n=contactlstmdl2.getSize();
                for (int j=0;j<n;j++){
                    ((Object) contactlstmdl2.getElementAt(j)).savebtn(c);
                }*/