public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        String filename = "person.ser";

        Person.serialize(person, filename);
        System.out.println("Сериализация завершена.");

        Person deserializedPerson = Person.deserialize(filename);
        if (deserializedPerson != null) {
            System.out.println("Десериализация завершена.");
            System.out.println("Имя: " + deserializedPerson.getName());
            System.out.println("Возраст: " + deserializedPerson.getAge());
        }
    }
}

