import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Display obj = new Display();
        obj.showString("Start of ArrayList");
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Dhiman");
        stringArrayList.add("Suman");
        stringArrayList.add("Ananya");
        Collections.sort(stringArrayList,Collections.reverseOrder());
        obj.showDetails(stringArrayList);
        stringArrayList.remove("Suman");
        stringArrayList.set(0,"Dhritismita");
        String odvl = obj.redplaced(stringArrayList,1,"Ruma");
        obj.getValue(stringArrayList,1);
        obj.showDetails(stringArrayList);
        System.out.println(odvl);
        obj.showString("End of ArrayList");

        obj.showString("Start of LinkedList");
        LinkedList <String> linkStr = new LinkedList<String>();
        linkStr.add(0,"Dhiman");
        linkStr.add(1,"Susmita");
        linkStr.add(2,"Dhritismita");
        linkStr.addFirst("Suman");
        linkStr.addLast("Ruman");

        System.out.println(linkStr);

        for (String i: linkStr){
            obj.showString(i);
        }

        obj.showString(String.valueOf(linkStr.contains("Dhimana")));
        obj.showString("Get any index value of LinkedList "+linkStr.get(2));
        obj.showString("Get First value of LinkedList "+linkStr.getFirst());
        obj.showString("Get Last value of LinkedList "+linkStr.getLast());

        obj.showString("End of LinkedList");


        obj.showString("End of HashMap");
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        obj.showString(capitalCities.get("USA"));
        System.out.println(capitalCities);
        obj.showString("End of HashMap");


        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        ArrayList<Integer> integersnum = new ArrayList<>(num.stream().filter(x-> x % 2 == 0).map(x -> x * 10).collect(Collectors.toList()));
        System.out.println(integersnum);

        List<Integer> aNum = Arrays.asList(1,3,5,9,7,4,6,5,9,8,6,6,4,6,4,6,6,7);
        List<Integer> newANum = aNum.stream().distinct().sorted((a,b)-> b -a).collect(Collectors.toList());
        System.out.println(newANum);
        Integer sum = newANum.stream().limit(4).skip(1).peek(x -> System.out.println(x)).reduce(0,(a,b)-> a+b);
        System.out.println("Sum is "+sum);
        System.out.println("Min is "+newANum+newANum.stream().peek(a-> System.out.println(a)).min(Integer::compareTo).get());
        System.out.println("Max is "+newANum+newANum.stream().max(Integer::compareTo).get());

        ArrayList<Person> plist = new ArrayList<Person>();
        plist.add(new Person("Sonam",33,"Pune",new BigDecimal(30220.00)));
        plist.add(new Person("Dhiman",36,"Kolkata",new BigDecimal(100000.00)));
        plist.add(new Person("Samita",35,"Malda",new BigDecimal(21100.00)));
        ArrayList<Person> npList = plist.stream().filter(a-> a.getCity().equals("Pune")).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(npList);

        Person oldest = plist.stream()
                .max(Comparator.comparing(Person::getAge))
                .get();

        System.out.println(oldest);

        ArrayList<Person> sortest = new ArrayList<Person>(plist.stream().sorted((a,b)-> b.getAge() - a.getAge()).collect(Collectors.toCollection(ArrayList::new)));
        System.out.println(sortest);

        ArrayList<String> sortestbyname = new ArrayList<String>(plist.stream().map(a-> a.getName()).sorted((a,b)-> b.compareTo(a)).collect(Collectors.toCollection(ArrayList::new)));
        System.out.println(sortestbyname);

        Integer sumAge = plist.stream().map(a-> a.getAge()).reduce(0,(a,b)-> a + b);
        System.out.println("sumAge "+sumAge);


        String str = "I am in love with Java";
        String[] strArray = str.split(" ");
        System.out.println(str);
        String newStr= "";
        for (int i = 0; i < strArray.length; i ++){
            String ne = strArray[i];
            newStr = newStr + ne.substring(0,1).toUpperCase()+ne.substring(1).toLowerCase() + " ";
        }
        String stmStr = Arrays.stream(strArray).map((a)-> a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase()).collect(Collectors.joining(" "));
        System.out.println(newStr);
        System.out.println(stmStr);

        String revStr= "";
        for (int i = strArray.length; i > 0; i --){
            String pStr = "";
            if(i != 1){
                pStr = strArray[i -1]+ " ";
            }else {
                pStr = strArray[i -1];
            }
            revStr = revStr  + pStr;
        }
        System.out.println(revStr);

        List lst = Arrays.asList(str.split(" "));
        Collections.reverse(lst);
        String revStr1 = String.join(" ", lst);

        System.out.println(revStr1);

        FunctionalInterfacePractice fi = new FunctionalInterfacePractice();
        fi.simplePredicate();
        fi.filterPredicate();
        fi.simpleFunction();
        fi.functionChainingEx1();fi.functionChainingEx2();


        CollectionsPractice cp = new CollectionsPractice();
        cp.arryListEx();cp.linkedListEx();cp.setEx();cp.queueEx();cp.mapEx();

        fi.filteWithPadicate(plist);
        fi.nornalShow();
        fi.showAsDefault();
        fi.compaare(plist);
//        fi.sho();


        Book b1 = new Book("Let's C", new BigDecimal(2200.55));
        Book b2 = new Book("Java", new BigDecimal(2200.55));
        System.out.println(b1.price().equals(b2.price()));
        System.out.println(b1.name().equals(b2.name()));

        System.out.println(b1.hashCode());



        List<Integer> numL = List.of(1,12,5,65,6,6,1,7);
        List<Integer> ulist = numL.stream().distinct().sorted().toList();
        Integer total = numL.stream().distinct().reduce((a,b) -> a + b).get();

        System.out.println(ulist +" -> "+ total);

        fi.consumerEx(plist);
        fi.supplierEx(plist);
    }
}