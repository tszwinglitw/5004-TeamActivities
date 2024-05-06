package solution;

class PersonSolution {
    private String name;

    public PersonSolution(String theName) {
        this.name = theName;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public String getName() {
        return this.name;
    }
}
