package ru.job4j.stream;

import java.util.Objects;

public class Profile {

    private Address address;

    private Profile() { }

    public static Profile of(Address adrs) {
        Profile pr = new Profile();
        pr.address = adrs;
        return pr;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
