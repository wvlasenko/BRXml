package by.bsu.xmlstudents;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {
        "name",
        "telephone",
        "address"
})
public class Student {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String login;
    @XmlElement(required = true)
    private String name;
    @XmlAttribute(required = false)
    private String faculty;
    @XmlAttribute(required = true)
    private double telephone;
    @XmlAttribute(required = true)
    private Address address = new Address();

    public Student(String login, String name, String faculty, double telephone, Address address) {
        this.login = login;
        this.name = name;
        this.telephone = telephone;
        this.address = address;

    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {

        return faculty;
    }

    public void setFaculty(String faculty) {

        this.faculty = faculty;
    }

    public double getTelephone() {

        return telephone;
    }

    public void setTelephone(double telephone) {

        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    @Override
    public String toString() {
        return
                "\nLogin: " + login +
                        "\nName:" + name +
                        "\nTelephone:" + telephone +
                        "\nFaculty: " + faculty +
                        address.toString();

    }

    @XmlRootElement
    @XmlType(name = "address", propOrder = {
            "city", "country", "street"})

    public static class Address {
        private String country;
        private String city;
        private String street;

        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public Address() {

        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public String toString() {
            return "\nAddress : " +
                    "\n\tCountry='" + country +
                    "\n\tCity='" + city +
                    "\n\tStreet='" + street + "\n";
        }

    }

}