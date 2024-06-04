import java.util.HashSet;
import java.util.Set;


// Practice using sets in Java


public class SetPractice {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Alice");
        set.add("Bob");
        set.add("Carol");

        System.out.println(set);

        set.add("Alice"); // what will happen? // nothing..... it will not add it again

        System.out.println(set.contains("Alice"));


        // TODO: add Set<Person>, and see
        // how it behaves with both students and person.
        // Make sure to have a duplicate student or person

        Set<Person> personSet = new HashSet<>();

        Person p1 = new Person("Jack");
        Person s2 = new Student("Wing", 1);
        Person s3 = new Student("Wing", 2);
        Person s4 = new Student("Wing", 1); // same as p2? - yeah, it is the same as p2

        personSet.add(p1);
        personSet.add(s2);
        personSet.add(s3);
        personSet.add(s4);

        System.out.println(personSet);

    }

}
