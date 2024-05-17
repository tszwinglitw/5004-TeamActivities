
public class RecordExample {
    public static void main(String[] args) {

        var person = new Person("Alice", 30, "New York");
        var student = new Student("Bob", 20, "XYZ School");
        var student2 = new Student("Bob", 20, "XYZ School");

        System.out.println(person);
        System.out.println(student);

        System.out.println(student.equals(student2));

        System.out.println(person.name());
        System.out.println(person.age());
        System.out.println(person.hashCode());
    }
}
