package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> cutDups(List<Profile> profiles) {
        List<Address> adrs = collect(profiles);
        return adrs.stream()
                .sorted((a, b) -> a.getCity().compareTo(b.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
