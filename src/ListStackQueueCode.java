import java.util.*;

public class ListStackQueueCode {
    //Collection 示例
    void collectionExample() {
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York"); // add
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");
        System.out.println("A list of cities in collection1:");
        System.out.println(collection1);
// the Collection interface’s contains method
        System.out.println("\nIs Dallas in collection1? "
                + collection1.contains("Dallas")); // contains
// the Collection interface’s remove method
        collection1.remove("Dallas"); // remove
// the Collection interface’s size method
        System.out.println("\n" + collection1.size() + // size
                " cities are in collection1 now");
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");
        System.out.println("\nA list of cities in collection2:");
        System.out.println(collection2);
        ArrayList<String> c1 = (ArrayList<String>)
                (collection1.clone()); // clone
        c1.addAll(collection2); // addAll
        System.out.println("\nCities in collection1 or collection2:");
        System.out.println(c1);
        c1 = (ArrayList<String>) (collection1.clone());
        c1.retainAll(collection2); // retainAll
        System.out.print("\nCities in collection1 and collection2:");
        System.out.println(c1);
        c1 = (ArrayList<String>) (collection1.clone());
        c1.removeAll(collection2); // removeAll
        System.out.print("\nCities in collection1, but not in 2: ");
        System.out.println(c1);

    }

    //LinkedList和ArrayList示例
    //linkedlist就是链表的实现 数据结构中的概念一样
    void listExample(){
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1); // 1 is autoboxed to new Integer(1)
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(0, 10);
        arrayList.add(3, 30);
        System.out.println("A list of integers in the array list:");
        System.out.println(arrayList);
        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "red");
        linkedList.removeLast();
        linkedList.addFirst("green");
        System.out.println("Display the linked list backward with index:");
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println("Display the linked list forward:");
        ListIterator<Object> listIterator =
                linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        System.out.println("Display the linked list backward:");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
    void useQueue(){
        Queue<String> queue = new LinkedList<>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");
        while (queue.size() > 0) {
            System.out.print(queue.remove() + " ");
        }
    }
    void usePriorityQueue(){
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");
        System.out.println("Priority queue using Comparable:");
        while (queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }
        PriorityQueue<String> queue2 = new PriorityQueue<>(4,
                Comparator.comparing(String::length));
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");
        System.out.println("\nPriority queue using Comparator:");
        while (queue2.size() > 0) {
            System.out.print(queue2.remove() + " ");
        }
    }
    //set示例
    void useSet(){
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }
        set.remove("London");
        System.out.println("\n" + set);
        System.out.println("Is Miami in the set? " + set.contains("Miami"));
        set.clear();
        System.out.println("Cities in set: " + set);
    }
    //map示例
    void useMap(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(
                Comparator.comparing(String::length));
        treeMap2.put("Smith", 30);
        treeMap2.put("Anderson", 31);
        treeMap2.put("Lewis", 29);
        treeMap2.put("Cook", 29);
        System.out.println("\nDisplay entries in ascending order of key length");
        System.out.println(treeMap2);
    }
    void useStack(){
        Stack<String> stack = new Stack<>();
        stack.push("Oklahoma");
        stack.push("Indiana");
        stack.push("Georgia");
        stack.push("Texas");
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
