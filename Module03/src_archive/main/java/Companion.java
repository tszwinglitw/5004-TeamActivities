public abstract class Companion extends Animal {
    private String friendlyName;

    public Companion(String name) {
        setFriendlyName(name);

    }

    public void setFriendlyName(String name) {
        this.friendlyName = name;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}
