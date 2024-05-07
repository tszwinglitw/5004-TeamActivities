package solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StudentLoaderSolution {



    public static Stream<String> getLines(String filename) {
        try {
            return Files.lines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    public static void main(String[] args) {

        Map<String, Set<String>> students = new HashMap<>();

        getLines("courses.txt").forEach(line -> {
            String[] parts = line.split("\\s+"); // split by whitespace

            String student = parts[0];
            String course = parts[1];

            if (!students.containsKey(student)) {
                Set<String> courses = new HashSet<>();
                courses.add(course);
                students.put(student, courses);
            } else {
                students.get(student).add(course);
            }

        });


        // now lets print it

        for (String student : students.keySet()) {
            System.out.println(student + " has completed "
                    + students.get(student).stream().collect(Collectors.joining(" ")));
        }

    }
}
