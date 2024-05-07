package solution;

import java.lang.reflect.Method;
import java.util.Objects;

public class StudentSolution extends PersonSolution {
    private int id;

    public StudentSolution(String theName, int id) {
        super(theName);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    // protected hides this method from the public API, and only
    // part of classes that purposely extend StudentSolution can use it
    // which then assumes the public equals method is the one to use
    protected boolean equalsStudent(StudentSolution other) {
        return this.id == other.id && this.getName().equals(other.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        try {
            // getDeclaredMethod works well if we are using protected
            Method method =
                    obj.getClass().getDeclaredMethod("equalsStudent", StudentSolution.class);
            return equalsStudent((StudentSolution) obj);

        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getId());
    }

    @Override
    public String toString() {
        return "StudentSolution{" + "name='" + this.getName() + '\'' + ", id=" + this.getId() + '}';
    }

    public static void main(String[] args) {
        int value = 10;
        PersonSolution e1 = new StudentSolution("Alice", 1);
        PersonSolution e2 = new StudentSolution("Bob", 2);
        PersonSolution e3 = new StudentSolution("Carol", 3);
        PersonSolution e5 = new PersonSolution("Alice");
        PersonSolution arrayOfPeople[] = {e1, e2, e3};

        PersonSolution e4 = new StudentSolution("Alice", 1); // same as e1?

        System.out.println(e1 == arrayOfPeople[0]); // what is printed here?
        System.out.println(e1 == e4); // what is printed here?


        System.out.println(e1.equals(e4)); // and here?
        System.out.println(e1.equals(e5)); // and here?


        System.out.println(e1.hashCode() == e4.hashCode()); // and here?
        System.out.println(e1.hashCode() == e5.hashCode()); // and here?
    }


}
