package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collectAdrFromProfs() {
        Address adr1 = Address.of("Moscow", "Kutuzov str.",
                                        130, 10);
        Address adr2 = Address.of("St. Petersburg", "Gorohovaya str.",
                                        43, 5);
        Profile pr1 = Profile.of(adr1);
        Profile pr2 = Profile.of(adr2);
        List<Profile> prs = List.of(pr1, pr2);
        List<Address> expected = new ArrayList<>();
        expected.add(adr1);
        expected.add(adr2);
        assertThat(new Profiles().collect(prs), is(expected));
    }
}