import java.util.List;
import java.util.ArrayList;

/**
 * Driver program for the menagerie example.
 */
public class Menagerie {

    List<Animal> animals = new ArrayList<>(); // this is similar to a python list - will cover more
                                              // in module 04

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getCount() {
        return animals.size(); // returns the total animals in the list
    }

    // adds some initial animals to the menagerie
    private static void addTestSet(Menagerie menagerie) {
        menagerie.addAnimal(new Dog("Fido"));
        menagerie.addAnimal(new Dog("Roy", 23));
        menagerie.addAnimal(new Cat("Cattivo", 5));
        menagerie.addAnimal(new Fox("Robin"));
        menagerie.addAnimal(new Cat("Gus"));

    }


    public static void main(String[] args) {
        Menagerie fun_times = new Menagerie();
        addTestSet(fun_times); // static add of some test elements

        for (Animal animal : fun_times.getAnimals()) {
            System.out.println(animal);
        }


        System.out.printf("Total in the menagerie: %d\n", fun_times.getCount()); // btw printf is
                                                                                 // the same as in
                                                                                 // C, it allows the
                                                                                 // C standard
                                                                                 // formatting.
    }

}
