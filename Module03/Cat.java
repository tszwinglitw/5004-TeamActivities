public class Cat extends Companion {
    private static final String FAMILY = "Felidae";
    private static final String GENUS = "Felis";
    private static final String SPECIES = "catus";
    private static final String A_CLASS = "Mammalia";
    private static final String PHYLUM = "Chordata";
    private static final String ORDER = "Carnivora";

    private static final int DEFAULT_MAX_TRICKS = 1;

    private final int maxTricks;


    public Cat(String name) {
        this(name, DEFAULT_MAX_TRICKS);
    }

    public Cat(String name, int maxTricks) {
        super(name);
        this.maxTricks = maxTricks;
    }


    @Override
    public String getAnimalClass() {
        return A_CLASS;
    }

    @Override
    public String getFamily() {
        return FAMILY;
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
    public String getOrder() {
        return ORDER;
    }

    @Override
    public String getPhylum() {
        return PHYLUM;
    }

    @Override
    public String getSound() {
        return "meow";
    }

    @Override
    public String getSpecies() {
        return SPECIES;
    }

}
