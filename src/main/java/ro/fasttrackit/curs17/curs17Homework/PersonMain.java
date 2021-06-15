package ro.fasttrackit.curs17.curs17Homework;

import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        PersonService personService = new PersonService(List.of(
                new Person("Barea", "Catalin",12,"Oradea"),
                new Person("Anca", "Anca",19,"Stei"),
                new Person("Corbu", "Gabi",21,"Beius"),
                new Person("Teodoroiu", "Iulian",55,"Oradea"),
                new Person("Anca", "Parva",34,"Stei"),
                new Person("Baba", "Ale",18,"Cluj"),
                new Person("Bendeac", "Mihai",33,"Bucuresti"),
                new Person("Anca", "Anca",34,"Stei")
        ));

        System.out.println(personService.major());
        System.out.println(personService.lastNameFirstName());
        System.out.println(personService.fromCity("Oradea"));
        System.out.println(personService.fromCityOrCity("Oradea","Cluj"));
        System.out.println(personService.firstNameCapitalized());
        System.out.println(personService.ageB());
        System.out.println(personService.firstLetterA());
        System.out.println(personService.firstNameUnique());
        System.out.println(personService.sortFirstName());
        System.out.println(personService.sortLastName());
        System.out.println(personService.sortFirstLastAge());
    }

}
