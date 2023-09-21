import java.io.Serializable;

public class group implements Comparable<group>,Serializable{
String groupName;
int groupmembernum;

public group(String g,int n ){
    g="groupName";
    n=groupmembernum;

}
    @Override
    public int compareTo(group o) {
        
        return 0;
    }
    
}
