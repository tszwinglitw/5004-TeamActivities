package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StrategyTester {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int rnd = (int) (Math.random() * 100);
            rnd = rnd % 2 == 0 ? rnd : -rnd; // make odd numbers negative
            numbers.add(rnd);
        }


        System.out.println("Sorting in natural order");
        Set<Integer> set = new TreeSet<>();
        set.addAll(numbers);
        System.out.println(set);
        System.out.println();

        System.out.println("Sorting in reverse order");
        Set<Integer> set2 = new TreeSet<>(new IntegerSortStrategy.reverseSort());
        set2.addAll(numbers);
        System.out.println(set2);
        System.out.println();

        System.out.println("Sorting by absolute value");
        Set<Integer> set3 = new TreeSet<>(new IntegerSortStrategy.absoluteValueSort());
        set3.addAll(numbers);
        System.out.println(set3);
        System.out.println();

        System.out.println(
                "Sorting by length, note since it is string length, negatives are often longer.");
        Set<Integer> set4 = new TreeSet<>(new IntegerSortStrategy.lengthSort());
        set4.addAll(numbers);
        System.out.println(set4);

        System.out.println();
        // quick question, why would we want to sort on streams and not the original
        // list?
        System.out.println("Now Sorting On Streams");

        System.out.println("Sorting in natural order");
        System.out.println(numbers.stream().sorted().collect(Collectors.toList()));
        System.out.println();

        System.out.println("Sorting in reverse order");
        System.out.println(numbers.stream().sorted(new IntegerSortStrategy.reverseSort())
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println("Sorting by absolute value");
        System.out.println(numbers.stream().sorted(new IntegerSortStrategy.absoluteValueSort())
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(
                "Sorting by length, note since it is string length, negatives are often longer.");
        System.out.println(numbers.stream().sorted(new IntegerSortStrategy.lengthSort())
                .collect(Collectors.toList()));

        System.out.println();

        System.out.println("Now destructive sort on original list");

        System.out.println("Added Order/original list");
        System.out.println(numbers);
        System.out.println();

        System.out.println("Sorting in natural order");
        numbers.sort(null);
        System.out.println(numbers);
        System.out.println();

        System.out.println("Sorting in reverse order");
        numbers.sort(new IntegerSortStrategy.reverseSort());
        System.out.println(numbers);
        System.out.println();

        System.out.println("Sorting by absolute value");
        numbers.sort(new IntegerSortStrategy.absoluteValueSort());
        System.out.println(numbers);
        System.out.println();

        System.out.println(
                "Sorting by length, note since it is string length, negatives are often longer.");
        numbers.sort(new IntegerSortStrategy.lengthSort());
        System.out.println(numbers);



    }
}
