import java.util.Map;

public record Person(String name, int age, String city) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }


    public static Person fromMap(Map<String, String> map) {
        int age;
        try {
            if (map.get("name") == null || map.get("age") == null || map.get("city") == null) {
                throw new IllegalArgumentException("Map must contain name, age, and city");
            }
            try {
                age = Integer.parseInt(map.get("age"));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Age must be an integer");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Map must contain name, age, and city");
        }

        return new Person(map.get("name"), age, map.get("city"));
    }
}
