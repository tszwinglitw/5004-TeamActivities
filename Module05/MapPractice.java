import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("Apple", 3.5);
        map.put("Banana", 2.0);
        map.put("Cherry", 4.0);

        // let's print the map

        System.out.println(map);

        // what happens if we add a duplicate key?
        // your code here
        map.put("Apple", 1.99);

        // SO - it will replace the value of the key "Apple" with 1.99


        // now try it with Person/Student. We will
        // use the person or student as a key and the
        // value will be a set of classes they are taking



        Person p1 = new Person("Jack");
        Person s2 = new Student("Wing", 1);
        Person s3 = new Student("Sebastian", 2);
        Person s4 = new Student("Wing", 1); // same as p2? - yeah, it is the same as p2
        Person s5 = new Student("Bob", 3);
        Person s6 = new Student("Mallory", 5);

        Map<Person, Set<String>> classes = new HashMap<>();
        classes.put(p1, Set.of("CS5008", "CS5004"));
        classes.put(s2, Set.of("CS5008", "CS5004"));
        classes.put(s3, Set.of("CS5008", "CS5004"));

        classes.put(s5, Set.of("CS5008", "CS5004"));
        classes.put(s6, Set.of("CS5008", "CS5004"));

        System.out.println("Before adding a duplicate: \n" + classes);
        classes.put(s4, Set.of("CS6983", "CS5008")); // this will replace Wing with id=1, aka s2

        System.out.println("After adding a duplicate: \n" + classes);

        System.out.println(p1.getName() + " " + p1.hashCode());
        System.out.println(s2.getName() + " " + s2.hashCode());
        System.out.println(s3.getName() + " " +  s3.hashCode());
        System.out.println(s4.getName() + " " +  s4.hashCode());
        System.out.println(s5.getName() + " " +  s5.hashCode());
        System.out.println(s6.getName() + " " +  s6.hashCode());


        // you will find Set.of() useful here
        // for example:
        // classes.put(p2, Set.of("CS5001", "CS5002"));


        Set<Person> people = new HashSet<>();
        Person pp1 = new Person("Alice");
        Person pp2 = new Student("Alice", 1);
        Person pp3 = new Student("Alice", 2);

        people.add(pp1);
        people.add(pp2);
        people.add(pp3);
        people.add(new Person("Bob"));
        people.add(new Person("Carol"));

        people.stream().filter(p -> p.getName().equals("Alice")).forEach(System.out::println);




        // Streams with Maps
        Map<String, Double> food = new HashMap<>();

        food.put("Apple", 3.5);
        food.put("Banana", 2.0);
        food.put("Cherry", 4.0);


        food.entrySet().stream().map(x -> x.getKey() + " costs " + x.getValue())
                .forEach(System.out::println);
        System.out.println("Food that costs more than 3.0");
        food.entrySet().stream().filter(x -> x.getValue() > 3.0)
                .map(x -> x.getKey() + " costs " + x.getValue())
                .forEach(System.out::println);


        // what would happen if I map the hashcode of the entry?
        food.entrySet().stream().map(x -> x.getKey() + x.hashCode())
                .forEach(System.out::println);


        System.out.println("For each loop example");
        for(Map.Entry<String, Double> entry : food.entrySet()) {
            System.out.println(entry.getKey() + " costs " + entry.getValue());
        }

        // or

        System.out.println("For each loop example");
        for(String key : food.keySet()) {
            System.out.println(key + " costs " + food.get(key));
        }

    }

}
