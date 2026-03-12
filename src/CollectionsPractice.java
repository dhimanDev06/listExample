import java.util.*;
import java.util.stream.Collectors;

public class CollectionsPractice {
    public void arryListEx(){
        ArrayList<String> srlist = new ArrayList<>();
        srlist.add("Dhiman");
        srlist.add("Suman");
        srlist.add("Susmita");
        srlist.add("Dhiman");
//        srlist.remove(2);
        System.out.println(srlist.stream().sorted().collect(Collectors.toList()));
        System.out.println(srlist);
    }
    public void linkedListEx(){
        LinkedList<String> srlist = new LinkedList<>();
        srlist.add("Dhiman");
        srlist.add("Suman");
        srlist.add("Susmita");
        srlist.add("Dhiman");
        System.out.println(srlist.stream().sorted().collect(Collectors.toList()));
        srlist.remove(2);
        System.out.println(srlist);
    }

    /*
    Set Example
     */

    public void setEx(){
        String[] strList = {"Dhiman","Ayan","Suman","Susmita","Dhiman"};
        Set<String> hasSet = new HashSet<>(Arrays.asList(strList));
        System.out.println("HashSet -> "+hasSet + " sorted "+ hasSet.stream().sorted().collect(Collectors.toList()));
        Set<String> linkSet = new LinkedHashSet<>(Arrays.asList(strList));
        System.out.println("LinkedHashSet -> "+linkSet);
        Set<String> treeSet = new TreeSet<>(Arrays.asList(strList));
        System.out.println("TreeSet -> "+treeSet);
    }


    public void queueEx(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(29);
        pq.add(12);
        pq.add(21);
        pq.add(1);
        System.out.println(pq);

        Deque<String> lf = new ArrayDeque<>();
        lf.addLast("DHiman");
        lf.addLast("Suman");
        lf.addLast("Himan");
        lf.addLast("Shiman");
        while (!lf.isEmpty()) {
            System.out.println(lf.pollFirst());
        }

        Deque<String> ff = new ArrayDeque<>();
        lf.addFirst("DHiman gf");
        lf.addFirst("Suman fd");
        lf.addFirst("Himan fg");
        lf.addFirst("Shiman ff");
        System.out.println("Elements in reverse insertion order (LIFO/Stack):");
        while (!ff.isEmpty()) {
            System.out.println(ff.pollFirst());
        }


        Deque<String> stack = new ArrayDeque<>();

        stack.addFirst("First item"); // Push onto the stack (front)
        stack.addFirst("Second item");
        stack.addFirst("Third item");

        System.out.println("Elements in reverse insertion order (LIFO/Stack):");
        // The pollFirst() method retrieves and removes the first element (top of the stack)
        while (!stack.isEmpty()) {
            System.out.println(stack.pollFirst()); // Outputs Third item, then Second item, then First item
        }
    }

    public void mapEx(){
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(3,"Dhiman");
        hm.put(1,"Susmita");
        hm.put(2,"Suman");
        for (Integer i = 0;i< hm.size(); i++) {
            System.out.println(i+hm.get(i + 1));
        }
        System.out.println("HashMap");
        LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
        lm.put(3,"Dhiman");
        lm.put(1,"Susmita");
        lm.put(2,"Suman");
        System.out.println("LinkedHashMap");
        for (Integer i = 0;i< lm.size(); i++) {
            System.out.println(i+lm.get(i + 1));
        }

        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(3,"Dhiman");
        tm.put(1,"Susmita");
        tm.put(2,"Suman");
        System.out.println("TreeMap");
        for (Integer i = 0;i< tm.size(); i++) {
            System.out.println(i+tm.get(i + 1));
        }
    }
}
