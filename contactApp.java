import java.util.*;
public class contactApp extends Myobservable {
    static Set<contact> availableContact;
    Set<contact> removeContact;
    boolean changed=false;
    //Set<group> availableGroup,removeGroup;
    
    public contactApp(){
        availableContact=new TreeSet<contact>();
        removeContact=new TreeSet<contact>();
    }

    public void saveContact(contact c){
        availableContact.add(c);
        setChanged();
         notifyObservers();
          changed=false;
    }

    public void deletecontact(contact c){
        availableContact.remove(c);
        notifyObservers();
        changed=false;
    }

    

    
}
