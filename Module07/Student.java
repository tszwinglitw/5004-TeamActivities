public record Student(String name, int age, String school) {
    public Student {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

}
