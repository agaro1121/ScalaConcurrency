package hbc.optional;


import java.util.Optional;

public class PersonWithOptions {

    private String firstName;
    private String lastName;
    private Optional<String> middleName;
    private Optional<AddressWithOptions> address;

    public PersonWithOptions(String firstName, String lastName, Optional<String> middleName, Optional<AddressWithOptions> address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Optional<String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Optional<String> middleName) {
        this.middleName = middleName;
    }

    public Optional<AddressWithOptions> getAddress() {
        return address;
    }

    public void setAddress(Optional<AddressWithOptions> address) {
        this.address = address;
    }
}
