package hbc.optional;

import java.util.Optional;

public class AddressWithOptions {

    private String line1;
    private Optional<String> line2;
    private Optional<String> city;
    private String state;
    private Long zip;

    public AddressWithOptions(String line1, Optional<String> line2, Optional<String> city, String state, Long zip) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public Optional<String> getLine2() {
        return line2;
    }

    public void setLine2(Optional<String> line2) {
        this.line2 = line2;
    }

    public Optional<String> getCity() {
        return city;
    }

    public void setCity(Optional<String> city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }
}
