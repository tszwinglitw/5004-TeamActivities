public class Fox extends Canidae {

    private static final String GENUS = "Vulpes";
    private static final String SPECIES = "vulpes";

    private static final int MAX_TRICKS_DEFAULT = 0; // foxes can do them, but don't want to do
                                                     // them.

    private final int maxTricks;

    public Fox(String name) {
        this(name, MAX_TRICKS_DEFAULT);
    }

    public Fox(String name, int maxTricks) {
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
        return "What does the fox say?";
    }

    @Override
    public String getSpecies() {
        return SPECIES;
    }


}
