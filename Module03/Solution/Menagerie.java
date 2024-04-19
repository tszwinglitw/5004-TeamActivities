import java.util.List;
import java.util.ArrayList;


public class Menagerie {
    private List<Animal> animals = new ArrayList<>();

    public int getAnimalCount() {
        return animals.size();
    }

    public int getCompanionCount() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Companion) {
                count++;
            }
        }
        return count;
    }

    public void printAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void printTricks() {
        for (Animal animal : animals) {
            if (animal instanceof Companion) {
                Companion companion = (Companion) animal;
                System.out.print(companion.getName() + " knows the following tricks: ");
                for (Trick trick : companion.getTricks()) {
                    if (trick == companion.getTricks().get(0)) {// first one
                        System.out.print(trick.getName());
                    } else {
                        System.out.print(", " + trick.getName()); // the rest
                    }
                }
                System.out.println();
            }
        }
    }

    public void fillMenagerie() {
        animals.add(AnimalFactory.getAnimal(AnimalOption.CAT));
        animals.add(AnimalFactory.getAnimal(AnimalOption.CAT));
        animals.add(AnimalFactory.getAnimal(AnimalOption.DOG));
        animals.add(AnimalFactory.getAnimal(AnimalOption.FOX));

        Companion whiskers = Companion
                .companionFromAnimal(AnimalFactory.getAnimal(AnimalOption.CAT), "Whiskers");
        whiskers.addTrick(new Trick("Jump"));
        animals.add(whiskers);

        Companion fido =
                Companion.companionFromAnimal(AnimalFactory.getAnimal(AnimalOption.DOG), "Fido");
        fido.addTrick(new Trick("Roll over"));
        fido.addTrick(new Trick("Play dead"));
        animals.add(fido);

        Companion foxy =
                Companion.companionFromAnimal(AnimalFactory.getAnimal(AnimalOption.FOX), "Foxy");
        foxy.addTrick(new Trick("Steal food"));
        animals.add(foxy);

        Companion rover =
                Companion.companionFromAnimal(AnimalFactory.getAnimal(AnimalOption.DOG), "Rover");
        rover.addTrick(new Trick("Fetch"));
        rover.addTrick(new Trick("Shake"));
        animals.add(rover);

        Companion fluffy =
                Companion.companionFromAnimal(AnimalFactory.getAnimal(AnimalOption.CAT), "Fluffy");
        fluffy.addTrick(new Trick("Climb"));
        fluffy.addTrick(new Trick("Hide"));
        animals.add(fluffy);



    }


    public static void main(String[] args) {
        // driver of the program

        Menagerie menagerie = new Menagerie();
        menagerie.fillMenagerie();

        menagerie.printAnimals();

        menagerie.printTricks();



    }
}
