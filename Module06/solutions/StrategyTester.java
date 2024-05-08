package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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


    }
}
