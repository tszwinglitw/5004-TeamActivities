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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) { // this is common when it is 'top level'
            return false;
        }

        PersonSolution other = (PersonSolution) obj;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "PersonSolution{" + "name='" + this.name + '\'' + '}';
    }

    public String getName() {
        return this.name;
    }
}
