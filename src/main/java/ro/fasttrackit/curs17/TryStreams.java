package ro.fasttrackit.curs17;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TryStreams {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Ana", 32),
                new Person("Mihai", 22),
                new Person("George", 12),
                new Person("Laurentiu", 52),
                new Person("Ecaterina", 32),
                new Person("Darius", 26),
                new Person("Carol", 33)
        );

        //get all names
        List<String> names = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(names);

        List<Person> major = persons.stream()
                .filter(person -> person.getAge() > 17)
                .collect(Collectors.toList());

        System.out.println(major);

        List<Person> falsePredicate = persons.stream()
                .filter(person -> false)
                .collect(Collectors.toList());

        System.out.println(falsePredicate);

        Optional<Person> anabela = persons.stream()
                .filter(person -> person.getName().equals("Anabela"))
                .findFirst();

        System.out.println(anabela);

        persons.stream()
                .filter(person -> person.getAge() > 10)
                .findAny()
                .map(Person::getName)
                .ifPresent(System.out::println);

        List<Person> containsA = persons.stream()
                .filter(person -> person.getName().contains("a"))
                .collect(Collectors.toList());

        System.out.println(containsA);

        persons.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println(persons.stream()
                .filter(person -> person.getAge() > 20)
                .filter(person -> person.getAge() < 30)
                .map(Person::getName)
                .map(personName -> personName.charAt(2))
                .map(Character::toUpperCase)
                .collect(Collectors.toList()));

        //sorting
        System.out.println(persons.stream()
                .map(Person::getAge)
                .sorted()
                .collect(Collectors.toList()));

        System.out.println(persons.stream()
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList()));

        System.out.println(persons.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList()));

        System.out.println(persons.stream()
                .sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge))
                .collect(Collectors.toList()));

        System.out.println(persons.stream()
                .sorted(Comparator.comparing(Person::getName).reversed()
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList()));

    }
}

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}