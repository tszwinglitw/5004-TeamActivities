import java.util.List;
import java.util.ArrayList;

public abstract class Animal {
    private static final String BIO_NAME = "Animalia"; // since this doesn't change

    private List<Trick> tricks = new ArrayList<>();


    public abstract String getPhylum();

    public abstract String getAnimalClass();

    public abstract String getOrder();

    public abstract String getFamily();

    public abstract String getGenus();

    public abstract String getSpecies();

    public abstract String getSound();

    public abstract int getMaxTricks();


    public String getKingdom() {
        return BIO_NAME;
    }

    public int trickCount() {
        return tricks.size();

    }

    public boolean addTrick(Trick trick) {
        if (getMaxTricks() - 1 > tricks.size()) {
            tricks.add(trick);
            return true; // able to add a trick
        }
        return false; // not able to add a trick
    }



}
