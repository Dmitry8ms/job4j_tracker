package ru.job4j.oop;

public class Builder extends  Engineer {
    private String object;

    public Builder(String company, String object) {
        super.setCompany(company);
        this.object = object;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void build(Project project) { }
}
