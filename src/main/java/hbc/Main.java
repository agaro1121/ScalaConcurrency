package hbc;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String,Person> people = generateExample();

        String jayZcity = "";
        Person person = people.get("Shawn");

        if(person != null)
        {
            Address address = person.getAddress();
            if(address != null)
            {
                jayZcity = address.getCity();
            }
        }

        if(jayZcity == null || jayZcity.equals("") || jayZcity.length() == 0 || jayZcity.isEmpty() )
        {
            jayZcity = "No City Available";
        }

        System.out.println(jayZcity);

    }

    private static Map<String,Person> generateExample(){
        Map<String,Person> example = new TreeMap<>();


        Address address1 = new Address("111 Main St","Apt 1","New York","NY",10010L);
        Address address2 = new Address("111 Main St","","New York","NY",10010L);
        Address address3 = new Address("111 Main St","Apt 4","New York","NY",10010L);
        Address address4 = new Address("111 Main St","","Boston","NY",10010L);

        Person person1 = new Person("Anthony","Garo","",  address1);
        Person person2 = new Person("Bob","Sanders","",   address2);
        Person person3 = new Person("Michael","Jordan","",address3);
        Person person4 = new Person("Bugs","Bunny","",    address4);
        Person person5 = new Person("Shawn","Carter","Corey",null);

        example.put(person1.getFirstName(),person1);
        example.put(person2.getFirstName(),person2);
        example.put(person3.getFirstName(),person3);
        example.put(person4.getFirstName(),person4);
        example.put(person5.getFirstName(),person5);

        return example;
    }

}
