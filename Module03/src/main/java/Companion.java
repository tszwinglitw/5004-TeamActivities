public abstract class Companion extends Animal {
    private String friendlyName;

    public Companion(String commonname, String phylum, String order,
            String Family, String genus, String genus, String species,
            String classType, String kingdom) {
        setFriendlyName(name);

    }

    public void setFriendlyName(String name) {
        this.friendlyName = name;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}
