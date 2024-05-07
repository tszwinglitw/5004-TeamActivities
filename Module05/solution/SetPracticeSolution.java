package solution;

import java.util.HashSet;
import java.util.Set;


// Practice using sets in Java


public class SetPracticeSolution {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Alice");
        set.add("Bob");
        set.add("Carol");

        System.out.println(set);

        set.add("Alice"); // what will happen?

        System.out.println(set.contains("Alice"));


        Set<PersonSolution> people = new HashSet<>();

        PersonSolution p1 = new PersonSolution("Alice");
        PersonSolution p2 = new StudentSolution("Alice", 1);
        PersonSolution p3 = new StudentSolution("Alice", 2);
        PersonSolution p4 = new StudentSolution("Alice", 1); // same as p2?

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);

        System.out.println(people);

        System.out.println(people.contains(p1));
        System.out.println(people.contains(p4));


        // also we can still use streams

        people.add(new PersonSolution("Bob"));
        people.add(new PersonSolution("Carol"));

        people.stream().filter(p -> p.getName().equals("Alice")).forEach(System.out::println);


    }

}
