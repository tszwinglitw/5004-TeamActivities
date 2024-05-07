
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

// yes we used all the above in the solution. You
// may not use them all, that is fine.


/**
 * a few java syntax items to help you out. Depending on how you do it, you may not need them
 * 
 * /
 * 
 * /* String[] parts = line.split("\\s+"); // split by whitespace String student = parts[0]; String
 * course = parts[1];
 */

/**
 * Set.of() creates an immutable set!, So if you want it mutable.
 * 
 * You will need to use a HashSet
 * 
 * Set<String> courses = new HashSet<>();
 * 
 * courses.add(course);
 * 
 * students.put(student, courses);
 */

/*
 * Using a stream to take a list and make it a string of "value value value"
 * 
 * 
 * students.get(student).stream().collect(Collectors.joining(" ")) - This one may be easier to do as
 * a separate loop, but feel free to play with this one.
 *
 */

public class StudentLoader {

    // todo: write a program that reads
    // the courses.txt file, and links
    // all classes with the String (name) of the student
    // outputs then will be "person has completed class1 class2 etc"
    // for each student


}
