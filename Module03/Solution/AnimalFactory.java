public final class AnimalFactory {

    private static final Taxonomy CAT_TAXONOMY = new Taxonomy("Cat", "Felis catus", "Felis",
            "Felidae", "Carnivora", "Mammalia", "Chordata", "Animalia");

    private static final Taxonomy DOG_TAXONOMY = new Taxonomy("Dog", "Canis lupus familiaris",
            "Canis", "Canidae", "Carnivora", "Mammalia", "Chordata", "Animalia");

    private static final Taxonomy FOX_TAXONOMY = new Taxonomy("Fox", "Vulpes vulpes", "Vulpes",
            "Canidae", "Carnivora", "Mammalia", "Chordata", "Animalia");

    private static final String CAT_SOUND = "Meow";
    private static final String DOG_SOUND = "Woof";
    private static final String FOX_SOUND = "No one knows what the fox says.";


    // prevents the factory from being instantiated at this point, maybe added later
    // if we need to use objects like reading from files or databases
    private AnimalFactory() {}

    public static Animal getAnimal(AnimalOption animalOption) {
        switch (animalOption) {
            case CAT:
                return new Animal(CAT_TAXONOMY, CAT_SOUND);
            case DOG:
                return new Animal(DOG_TAXONOMY, DOG_SOUND);
            case FOX:
                return new Animal(FOX_TAXONOMY, FOX_SOUND);
            default:
                throw new IllegalArgumentException("Invalid animal option");
        }
    }


}
