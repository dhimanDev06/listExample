import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfacePractice implements java8staicdefefault {
    public void simplePredicate(){
        Predicate<Integer> testEven = a -> a % 2 == 0; // Simple Predicate
        Predicate<Integer> testOdd = testEven.negate();
        List<Integer> alist = Arrays.asList(1,2,3,4,5,6,7,8,9);
        alist.forEach(a-> System.out.println(a+" testEven --> "+testEven.test(a)));
        alist.forEach(a-> System.out.println(a+" testOdd --> "+testOdd.test(a)));
        List<Integer> evenList = alist.stream().filter(a-> testEven.test(a)).collect(Collectors.toList());
        System.out.println(evenList);
    }
    public void filteWithPadicate(ArrayList<Person> plist){
        Predicate<Person> testPune = a -> a.getCity().equals("Pune");
        ArrayList<Person> newPList = plist.stream().filter(testPune).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(newPList);

        Function<Person, BigDecimal> getSalary= a-> a.getSalary();
        BigDecimal totalSal = plist.stream().map(getSalary).reduce((a,b)-> a.add(b)).get();
        System.out.println(totalSal);
    }

    public void filterPredicate(){
        Predicate<String> startWithD = n -> n.startsWith("D") || n.startsWith("d");
        Predicate<String> endWithA = n -> n.toLowerCase().endsWith("a") || n.toUpperCase().endsWith("A");
        List<String> nameList = Arrays.asList("Dhiman","Suman","Dhritismita","Susmita","Ruma");
        for (String a : nameList) {
            System.out.println(a+" --> "+startWithD.test(a));
        }
        List<String> filterList =nameList.stream().filter(startWithD.or(endWithA)).collect(Collectors.toList());
        System.out.println(filterList);
    }

    public void simpleFunction(){
        Function<Integer, Integer> sqr = a -> a * a;
        System.out.println(sqr.apply(5));


        Function<String, String> to2Uppser = a->a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase();
        List<String> nameList = Arrays.asList("Dhiman","Suman","Dhritismita","Susmita","Ruma");
        List<String> filterList =nameList.stream().map(a-> to2Uppser.apply(a)).collect(Collectors.toList());
        System.out.println(filterList);

    }
    public void functionChainingEx1(){
        Function<Integer, Integer> sqr = a -> a * 2;
        Function<Integer, Integer> dbl = a -> a * a;

        Function<Integer, Integer> one = sqr.andThen(dbl);
        Function<Integer, Integer> two = sqr.compose(dbl);
        System.out.println(one.apply(5));
        System.out.println(sqr.apply(5) * dbl.apply(5));
        System.out.println(two.apply(5));



    }
    public void functionChainingEx2(){
        Function<String, String> timmer = a-> a.trim();
        Function<String, String> uppsercase = String::toUpperCase;
        Function<String,String> addUser = a-> "user_"+a;
        Function<String,String> finalName = timmer.andThen(uppsercase).andThen(addUser);
        System.out.println(finalName.apply("                               Dhiman      "));
    }



    @Override
    public void nornalShow() {
        System.out.println("hi nornalShow "+ java8staicdefefault.showAsStatic("Dhiman "));
    }

    public void compaare(ArrayList<Person> plist){
        Comparator<Person> sortAge = (a,b)-> b.getAge() - a.getAge();
        Comparator<Person> sortSal = (a,b)-> b.getSalary().compareTo(a.getSalary());// - a.getAge();

        System.out.println("before "+plist);
        plist.sort(sortSal);
        System.out.println("after "+plist);

        ArrayList<Person> newPList =  plist.stream().sorted(sortAge).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("then "+newPList);
    }


    public void consumerEx(ArrayList<Person> plist){

        Consumer<Person> ageCheck = p-> {
          if(p.getAge() > 33){
              System.out.println("Name is "+p.getName());
          }
        };
        Consumer<Person> isKolkata = person -> {
          if (person.getCity().equals("Kolkata")){
              System.out.println("Form Kolkata");
          }
        };

        Consumer<Person> combind = ageCheck.andThen(isKolkata);
        plist.forEach(combind);
    }
    public void supplierEx(ArrayList<Person> plist){
        Integer returnCd = 200;
        Supplier<String> checkKolkata = ()->{
            if(returnCd.equals(200)) return "Success";
            else return "Failed";
        };
        Comparator<Person> highestSal = (a,b)-> b.getSalary().compareTo(a.getSalary());
        Supplier<Person> maxSal = () -> plist.stream().peek(System.out::println).min(highestSal).orElse(null);


        System.out.println(checkKolkata.get());
        System.out.println(maxSal.get());

        Predicate<Person> isKol = p-> p.getCity().equals("Kolkata");
        Function<Person,BigDecimal> filterSal = p-> p.getSalary();
        ArrayList<Person> isKolkataList = plist.stream().filter(isKol).collect(Collectors.toCollection(ArrayList::new));
        BigDecimal totalSal = plist.stream().map(filterSal).reduce((a,b)->a.add(b)).get();
        System.out.println(isKolkataList);
        System.out.println(totalSal);
    }

}
