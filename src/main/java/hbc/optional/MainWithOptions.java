package hbc.optional;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MainWithOptions {

    public static void main(String[] args) {
        Map<String,Optional<PersonWithOptions>> people = generateExample();

        String jayZcity = people.get("Shawn")
                .flatMap(person -> person.getAddress())
                .flatMap(address -> address.getCity())
                .orElse("No City Available");

        System.out.println(jayZcity);

        String city = people.get("Bugs")
                .flatMap(person -> person.getAddress())
                .flatMap(address -> address.getCity())
                .orElse("No City Available");

        System.out.println(city);

    }


    private static Map<String,Optional<PersonWithOptions>> generateExample(){
        Map<String,Optional<PersonWithOptions>> example = new TreeMap<>();


        AddressWithOptions address1 = new AddressWithOptions("111 Main St",Optional.of("Apt 1"),Optional.of("New York"),"NY",10010L);
        AddressWithOptions address2 = new AddressWithOptions("111 Main St",Optional.empty(),Optional.of("New York"),"NY",10010L);
        AddressWithOptions address3 = new AddressWithOptions("111 Main St",Optional.of("Apt 4"),Optional.of("New York"),"NY",10010L);
        AddressWithOptions address4 = new AddressWithOptions("111 Main St",Optional.empty(),Optional.of("Boston"),"NY",10010L);

        PersonWithOptions person1 = new PersonWithOptions("Anthony","Garo",Optional.empty(),Optional.of(address1));
        PersonWithOptions person2 = new PersonWithOptions("Bob","Sanders",Optional.empty(),Optional.of(address2));
        PersonWithOptions person3 = new PersonWithOptions("Michael","Jordan",Optional.empty(),Optional.of(address3));
        PersonWithOptions person4 = new PersonWithOptions("Bugs","Bunny",Optional.empty(),Optional.of(address4));
        PersonWithOptions person5 = new PersonWithOptions("Shawn","Carter",Optional.of("Corey"),Optional.empty());

        example.put(person1.getFirstName(),Optional.of(person1));
        example.put(person2.getFirstName(),Optional.of(person2));
        example.put(person3.getFirstName(),Optional.of(person3));
        example.put(person4.getFirstName(),Optional.of(person4));
        example.put(person5.getFirstName(),Optional.of(person5));

        return example;
    }
}
