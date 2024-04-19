import java.util.ArrayList;
import java.util.List;

public class Companion extends Animal {
    private List<Trick> tricks;
    private String name;
    private int maxTricks;

    private static final int DEFAULT_MAX_TRICKS = 10;

    public Companion(Taxonomy taxonomy, String sound, String name) {
        this(taxonomy, sound, name, DEFAULT_MAX_TRICKS);
    }

    public Companion(Taxonomy taxonomy, String sound, String name, int maxTricks) {
        super(taxonomy, sound);
        this.name = name;
        this.tricks = new ArrayList<>();
        this.maxTricks = maxTricks;
    }

    public boolean addTrick(Trick trick) {
        if (tricks.size() < maxTricks) {
            tricks.add(trick);
            return true;
        }
        return false;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTricks() {
        return maxTricks;
    }

    public void setMaxTricks(int maxTricks) {
        this.maxTricks = maxTricks;
    }

    public int getTrickCount() {
        return tricks.size();
    }

    @Override
    public String toString() {
        return String.format("Companion{%s says %s, and knows %s tricks.}", getName(), getSound(),
                getTrickCount());
    }


    // statics
    // This is a common design / use of statics in a class
    // To create a new instance of the class from an existing instance
    // It is sometimes called a "Factory" method, based on the factory pattern
    public static Companion companionFromAnimal(Animal animal, String name) {
        return new Companion(animal.getTaxonomy(), animal.getSound(), name);
    }

    public static Companion companionFromAnimal(Animal animal, String name, int maxTricks) {
        return new Companion(animal.getTaxonomy(), animal.getSound(), name, maxTricks);
    }
}
