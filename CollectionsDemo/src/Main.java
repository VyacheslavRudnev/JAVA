import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //demoArrayList();
        //demoLinkedList();
        //demoHashSet();
        //demoTreeSet();
        demoHashMap();

        //пояснення для хешкодів
        //Object o1 = new Object();
        //Integer a = 10;
        //Double d = 2.71828;
        //String s = "Hello";
        //System.out.println("Hash of a = " + a.hashCode());
        //System.out.println("Hash of d = " + d.hashCode());
        //System.out.println("Hash of s = " + s.hashCode());
        //System.out.println("Hash of o1 = " + o1.hashCode());
    }

    private static void demoHashMap() {
        HashMap<Fish, Integer> map = new HashMap<>();

        Fish f1 = new Fish("tuna",20,550);
        Fish f2 = new Fish("salmon",4,110);
        Fish f3 = new Fish("carp",5,90);
        Fish f4 = new Fish("eel",3,130);
        Fish f5 = new Fish("trout",4,120);

        map.put(f1, f1.getPrice());
        map.put(f2, f2.getPrice());
        map.put(f3, f3.getPrice());
        map.put(f4, f4.getPrice());
        map.put(f5, f5.getPrice());

        for (Map.Entry<Fish, Integer> item : map.entrySet()) {
            Fish key = item.getKey();
            Integer value = item.getValue();
            System.out.println(key + " -> " + value);
        }

    }


    private static void demoTreeSet() {
        TreeSet<Fish> ts = new TreeSet<>();

        Fish f1 = new Fish("tuna",20,550);
        Fish f2 = new Fish("salmon",4,110);
        Fish f3 = new Fish("carp",5,90);
        Fish f4 = new Fish("eel",3,130);
        Fish f5 = new Fish("trout",4,120);

        ts.add(f1);
        ts.add(f2);
        ts.add(f3);
        ts.add(f4);
        ts.add(f5);

        System.out.println(System.getProperty("line.separator") + "----------------for--------------");
        for (Fish item : ts) {
            System.out.println(item);
        }


        Comparator<FishEx> fishWeitComparator = new Comparator<FishEx>() {
            @Override
            public int compare(FishEx o1, FishEx o2) {
                return (int) (o1.getWeight() - o2.getWeight());
            }
        };

        TreeSet<FishEx> ts1 = new TreeSet<>(fishWeitComparator);

        FishEx f11 = new FishEx("tuna",20,550);
        FishEx f21 = new FishEx("salmon",4,110);
        FishEx f31 = new FishEx("carp",5,90);
        FishEx f41 = new FishEx("eel",3,130);
        FishEx f51 = new FishEx("trout",4,120);

        ts1.add(f11);
        ts1.add(f21);
        ts1.add(f31);
        ts1.add(f41);
        ts1.add(f51);

        System.out.println(System.getProperty("line.separator") + "----------------for--------------");
        for (FishEx item : ts1) {
            System.out.println(item);
        }
    }

    private static void demoHashSet() {
        HashSet<Fish> hs = new HashSet<>();

        Fish f1 = new Fish("tuna",20,550);
        hs.add(new Fish("salmon",4,110));
        hs.add(new Fish("carp",5,90));
        hs.add(new Fish("eel",3,130));
        hs.add(new Fish("trout",4,120));
        hs.add(new Fish("trout",4,120));
        hs.add(f1);
        hs.add(f1);

        System.out.println(System.getProperty("line.separator") + "----------------for--------------");
        for (Fish item : hs) {
            System.out.println(item);
        }
        System.out.println(System.getProperty("line.separator") + "----------------contains--------------");
        f1.setPrice(600);
        System.out.println("does collection contains element f1: " + hs.contains(f1));
    }

    private static void demoLinkedList() {
    LinkedList<String> list1 = new LinkedList<>();
        list1.add("Ukraine");
        list1.add("Canada");
        list1.add("Canada");
        list1.add("France");
        list1.add("Sweden");
        list1.add("Sweden");
        list1.add("Italy");

        System.out.println(System.getProperty("line.separator") + "----------------iterator--------------");
        ListIterator<String> lit = list1.listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next()+", ");
        }

        System.out.println(System.getProperty("line.separator") + "----------------iterator--------------");
        Iterator<String> rit = list1.descendingIterator();
        while (rit.hasNext()) {
            System.out.print(rit.next()+", ");
        }

        System.out.println(System.getProperty("line.separator") + "----------------iterator--------------");
        int index = list1.indexOf("Sweden");
        System.out.println("index="+index);
        System.out.println("Max element=" + Collections.max(list1));
        System.out.println("Min element=" + Collections.min(list1));

    }

    private static void demoArrayList() {
        ArrayList a1 = new ArrayList(100);
        a1.add(1);
        a1.add("Hello");
        a1.add(1000);
        a1.add(false);

        System.out.println("Size:" + a1.size());

        ArrayList<String> a2 = new ArrayList<>(200);
        a2.add("Ukraine");
        a2.add("Canada");
        a2.add("France");
        a2.add("Sweden");
        a2.add("Italy");
        System.out.println(a2);
        System.out.println("----------------for--------------");
        for (int i = 0; i < a2.size(); i++)
        {
            System.out.print(a2.get(i)+", ");
        }
        a2.add("Japan");
        a2.trimToSize();    //зменшення розміру колекції до актуального розміру
        a2.ensureCapacity(200);//збільшення розміру колекції до заданого розміру
        Iterator<String> it = a2.iterator();

        System.out.println(System.getProperty("line.separator") + "----------------iterator--------------");
        while (it.hasNext()){
            System.out.print(it.next()+", ");
        }

        System.out.println("----------------sort--------------");
        a2.sort(null);
        for (String item : a2){
            System.out.print(item+", ");
        }
    }
}