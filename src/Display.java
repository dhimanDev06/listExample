import javax.swing.text.Element;
import java.util.ArrayList;

public class Display {
    public void showDetails(ArrayList stringArrayList){
        System.out.println(stringArrayList);
        count(stringArrayList);
    }
    private void count(ArrayList stringArrayList){
        System.out.println("Size "+stringArrayList.size());
    }
    public void getValue(ArrayList stringArrayList,int index){
        System.out.println("Position "+index+" -> "+stringArrayList.get(index));
    }
    public String redplaced(ArrayList<String> stringArrayList, int index, String value){
         return stringArrayList.set(index,value);
    }
    public void showString(String str){
        System.out.println(str);
    }
}
