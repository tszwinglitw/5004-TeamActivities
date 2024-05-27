
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestMain {

    public static List<Integer> getEvens(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                evens.add(numbers.get(i));
            }
        }
        return evens;
    }
    
    public static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
    
    public static List<Integer> square(List<Integer> numbers) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            squares.add(numbers.get(i) * numbers.get(i));
        }
        return squares;
    }

    public static List<Book> ListOfBooks(List<String> bookStrings) {
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < bookStrings.size(); i++) {
            Book tempBook = Book.createFromString(bookStrings.get(i));
            books.add(tempBook);
        }
        return books;
    }

    

    public static void main(String[] args) {

        /* EVEN NUMBER  */
        // even
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // this function is a quick way to build a list
        List<Integer> evens = getEvens(numbers);
        System.out.println(evens);

        // even2
        // this function is a quick way to build a list
        List<Integer> evens2 = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens2);
        
        /* SUM */
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum1 = integers.stream().reduce(0, (a, b) -> a + b);
        Integer sum2 = sum(integers);
        
        System.out.println("Sum1: " + sum1);
        System.out.println("Sum2: " + sum2);
        
        /* SQUARES */
        List<Integer> squared1 = integers.stream().map(n -> n * n).collect(Collectors.toList());
        List<Integer> squared2 = square(integers);
        System.out.println("Squared1: " + squared1);
        System.out.println("Squared2: " + squared2);

        /* BOOKS  FROM STRINGS*/
        List<String> bookStrings = Arrays.asList("The Great Gatsby,F. Scott Fitzgerald,1925",
        "To Kill a Mockingbird,Harper Lee,1960",
        "1984,George Orwell,1949",
        "The Catcher in the Rye,J.D. Salinger,1951",
        "Beloved,Toni Morrison,1987");
        List<Book> books1 = bookStrings.stream().map(Book::createFromString).collect(Collectors.toList());
        List<Book> books2 = ListOfBooks(bookStrings);
        
        System.out.println("Books1: " + books1);
        System.out.println("Books2: " + books2);
        
        
        /* SORTING BOOKS */
        List<Book> sortedBooks1 = books1.stream().sorted().collect(Collectors.toList());
        System.out.println("SortedBooks1: " + sortedBooks1);
        
     

    }

}
