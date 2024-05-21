public abstract class Canidae extends Companion {



    private static final String A_CLASS = "Mammalia";
    private static final String PHYLUM = "Chordata";
    private static final String ORDER = "Carnivora";
    private static final String FAMILY = "Canidae";

    public Canidae(String name) {
        super(name);
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
    public String getOrder() {
        return ORDER;
    }

    @Override
    public String getPhylum() {
        return PHYLUM;
    }



}
