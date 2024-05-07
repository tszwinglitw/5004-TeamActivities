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

        set.add("Alice"); // what will happen?

        System.out.println(set.contains("Alice"));


        // TODO: add Set<Person>, and see
        // how it behaves with both students and person.
        // Make sure to have a duplicate student or person



    }

}
