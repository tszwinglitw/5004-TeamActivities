public class Animal {
    private Taxonomy taxonomy;
    private String sound;

    public Animal(Taxonomy taxonomy, String sound) {
        this.taxonomy = taxonomy;
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    @Override
    public String toString() {
        return "Animal{" + taxonomy.getCommonName() + " says " + sound + '}';
    }
}
