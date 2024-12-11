
import java.util.ArrayList;


public class SetOperations
{
    private String days;
    
    public SetOperations() {
        
        
    }
    
    public ArrayList<String> union(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> unionList = new ArrayList<String>();

        for(int i = 0; i < a.size(); i++) {
            unionList.add(a.get(i));
        }
        
        boolean isDuplicate = false;
        for(int i = 0; i < b.size(); i++) {
            String elementToAdd = b.get(i);
            for(int j = 0; j < unionList.size(); j++) {
                if(elementToAdd.equals(unionList.get(j))) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if(isDuplicate != true) {
                unionList.add(elementToAdd);
            }
        }
//        for(int i = 0; i < b.size(); i++) {
//            unionList.add(b.get(i));
//        }
        return unionList;
    }
    
    public ArrayList<String> intersection(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> arraylist = new ArrayList<String>();
        
        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < b.size(); j++) {
                if(a.get(i) == b.get(j)) {
                    arraylist.add(a.get(i));
                }
            }
        }
        return arraylist;
    }
    
    public void runOperations() {
        ArrayList<String> week1 = new ArrayList<String>();
        ArrayList<String> week2 = new ArrayList<String>();
        
        week1.add("Monday");
        week1.add("Tuesday");
        week1.add("Wednesday");
        week1.add("Thursday");
        week1.add("Friday");
        
        week2.add("Saturday");
        week2.add("Sunday");
        week2.add("Monday");
        week2.add("Tuesday");
        
        System.out.println("Union: " + union(week1, week2));
        System.out.println("Intersection: " + intersection(week1, week2));
    } 
}
