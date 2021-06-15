package ro.fasttrackit.curs17.curs17Homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(Collection<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    public List<Person> major() {
        return persons.stream()
                .filter(person -> person.getAge() > 17)
                .collect(Collectors.toList());
    }

    public List<String> lastNameFirstName() {
        return persons.stream()
                .map(Person::getFullName)
                .collect(Collectors.toList());
    }

    public List<Person> fromCity(String city) {
        return persons.stream()
                .filter(person -> person.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Person> fromCityOrCity(String city1, String city2) {
        return persons.stream()
                .filter(person -> person.getCity().equals(city1) || person.getCity().equals(city2))
                .collect(Collectors.toList());
    }

    public List<String> firstNameCapitalized() {
        return persons.stream()
                .map(Person::getFirstName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<Person> ageB() {
        return persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .collect(Collectors.toList());
    }

    public List<String> firstNameFirstLetter() {
        return null;

    }

    public List<Person> firstLetterA() {
        return persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public List<String> firstNameUnique(){
        return persons.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> sortFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Person> sortLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortFirstLastAge() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
}
