import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfacePractice {
    public void simplePredicate(){
        Predicate<Integer> testEven = a -> a % 2 == 0; // Simple Predicate
        Predicate<Integer> testOdd = testEven.negate();
        List<Integer> alist = Arrays.asList(1,2,3,4,5,6,7,8,9);
        alist.forEach(a-> System.out.println(a+" testEven --> "+testEven.test(a)));
        alist.forEach(a-> System.out.println(a+" testOdd --> "+testOdd.test(a)));
        List<Integer> evenList = alist.stream().filter(a-> testEven.test(a)).collect(Collectors.toList());
        System.out.println(evenList);
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


}
