package solutions;

import java.util.Comparator;

public class IntegerSortStrategy {

    public static class reverseSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static class standardSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }


    public static class absoluteValueSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o1) - Math.abs(o2);
        }
    }


    // first sort by length, then by value
    public static class lengthSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int length = String.valueOf(o1).length() - String.valueOf(o2).length();
            if (length == 0) {
                return o1.compareTo(o2);
            }
            return length;
        }
    }


}
