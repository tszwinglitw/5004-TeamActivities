public class Dog extends Canidae {
    private static final String GENUS = "Canis";
    private static final String SPECIES = "Canis lupus";

    private static final int MAX_TRICKS_DEFAULT = 5;

    private final int maxTricks;

    public Dog(String name) {
        this(name, MAX_TRICKS_DEFAULT);
    }

    public Dog(String name, int maxTricks) {
        super(name);
        this.maxTricks = maxTricks;
    }


    @Override
    public String getGenus() {
        return GENUS;
    }

    @Override
    public int getMaxTricks() {
        return maxTricks;
    }

    @Override
    public String getSound() {
        return "barks";
    }

    @Override
    public String getSpecies() {
        return SPECIES;
    }


    @Override
    public String toString() {
        return String.format("A Dog called %s with %d tricks.", getFriendlyName(), trickCount());
    }

}
