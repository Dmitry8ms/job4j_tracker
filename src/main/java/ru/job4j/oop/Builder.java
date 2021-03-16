package ru.job4j.oop;

public class Builder {
    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void build(Project project) { }
}
