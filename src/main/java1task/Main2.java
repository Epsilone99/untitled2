import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();

        // Добавление
        PersonEntity person = new PersonEntity();
        person.setName("Bob");
        person.setAge(25);
        repository.addPerson(person);


        List<PersonEntity> persons = repository.getAllPersons();
        for (PersonEntity p : persons) {
            System.out.println("Имя: " + p.getName() + ", Возраст: " + p.getAge());
        }


        person.setAge(26);
        repository.updatePerson(person);


        repository.deletePerson(person.getId());
    }
}
