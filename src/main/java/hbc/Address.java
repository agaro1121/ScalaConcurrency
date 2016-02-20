package hbc;


public class Address {
    private String line1;
    private String city;
    private String state;
    private Long zip;
    private String line2;

    public Address(String line1, String city, String state, String line2, Long zip) {
        this.line1 = line1;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.line2 = line2;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
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

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

}
