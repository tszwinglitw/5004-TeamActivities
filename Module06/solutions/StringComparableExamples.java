package solutions;

public class StringComparableExamples {


    public static void main(String[] args) {

        String s1 = "aloha";
        String s2 = "world";


        System.out.println(s1.compareTo(s2));

        System.out.println("And now a few more examples");

        String a = "a";
        String b = "b";
        String A = "A";
        String B = "B";

        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(a));
        System.out.println(b.compareTo(a));
        System.out.println();
        System.out.println(A.compareTo(B));
        System.out.println(B.compareTo(A));

        System.out.println();
        System.out.println(a.compareTo(A));
        System.out.println(A.compareTo(a));

    }



}
