import java.util.List;
import java.util.ArrayList;

/**
 * Driver program for the menagerie example.
 */
public class Menagerie {

    List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }


    public int getCount() {
        return animals.size(); // returns the total animals in the list
    }

    // adds some initial animals to the menagerie
    private static void addTestSet(Menagerie menagerie) {
        menagerie.addAnimal(new Dog("Fido"));


    }


    public static void main(String[] args) {
        Menagerie fun_times = new Menagerie();


        System.out.printf("Total in the menagerie: %d\n", fun_times.getCount()); // btw printf is
                                                                                 // the same as in
                                                                                 // C, it allows the
                                                                                 // C standard
                                                                                 // formatting.
    }

}
