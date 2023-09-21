import java.util.*;

public abstract class Myobservable {
    boolean changed;
    List<Myobserver> observers;

    public Myobservable(){
        changed=false;
        observers=new ArrayList<Myobserver>();
    }
    public void setChanged(){changed=true;}
    public void addobserver(Myobserver ob){
        observers.add(ob);
    }
    public void notifyObservers(){
        for(Iterator <Myobserver> it=observers.iterator();it.hasNext();)
        ((Myobserver) it.next()).update();
        changed=false;
    }
    }

