package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> inName = k -> k.getName().contains(key);
        Predicate<Person> inSurname = k -> k.getSurname().contains(key);
        Predicate<Person> inAddress = k -> k.getAddress().contains(key);
        Predicate<Person> inPhone = k -> k.getPhone().contains(key);
        Predicate<Person> combine = inName.or(inSurname.or(inAddress.or(inPhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
         /*   if (p.getPhone().contains(key)
                    || p.getAddress().contains(key)
                    || p.getName().contains(key)
                    || p.getSurname().contains(key)) {
                result.add(p);
            }*/
            if (combine.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
