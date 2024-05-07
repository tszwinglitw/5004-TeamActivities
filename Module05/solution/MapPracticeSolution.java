package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPracticeSolution {
    public static void main(String[] args) {
        Map<String, Double> food = new HashMap<>();

        food.put("Apple", 3.5);
        food.put("Banana", 2.0);
        food.put("Cherry", 4.0);

        // let's print the map

        System.out.println(food);

        // what happens if we add a duplicate key?
        food.put("Apple", 5.0);
        System.out.println(food);

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

        // what about streams?

        food.entrySet().stream().map(x -> x.getKey() + " costs " + x.getValue())
                .forEach(System.out::println);

        System.out.println("Food that costs more than 3.0");
        food.entrySet().stream().filter(x -> x.getValue() > 3.0)
                .map(x -> x.getKey() + " costs " + x.getValue()).forEach(System.out::println);

        System.out.println("For each loop example");
        for (Map.Entry<String, Double> entry : food.entrySet()) {
            System.out.println(entry.getKey() + " costs " + entry.getValue());
        }

        // or

        System.out.println("For each loop example");
        for (String key : food.keySet()) {
            System.out.println(key + " costs " + food.get(key));
        }

    }
}
