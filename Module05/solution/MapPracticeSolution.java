package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPracticeSolution {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("Apple", 3.5);
        map.put("Banana", 2.0);
        map.put("Cherry", 4.0);

        // let's print the map

        System.out.println(map);

        // what happens if we add a duplicate key?
        map.put("Apple", 5.0);
        System.out.println(map);

        // now try it with Person/Student. We will
        // use the person or student as a key and the
        // value will be a set of classes they are taking

        Map<PersonSolution, Set<String>> classes = new HashMap<>();

        PersonSolution p1 = new PersonSolution("Alice");
        PersonSolution p2 = new StudentSolution("Alice", 1);
        PersonSolution p3 = new StudentSolution("Alice", 2);
        PersonSolution p4 = new StudentSolution("Alice", 1); // same as p2?

        classes.put(p1, Set.of());
        classes.put(p2, Set.of("CS5001", "CS5002"));
        classes.put(p3, Set.of("CS5008", "CS5004"));
        classes.put(p4, Set.of("CS5002", "CS5004"));

        System.out.println(classes);


    }
}
