package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    private Address() { }

    public static Address of(String city, String street, int home, int apartment) {
        Address adr = new Address();
        adr.city = city;
        adr.street = street;
        adr.home = home;
        adr.apartment = apartment;
        return adr;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
