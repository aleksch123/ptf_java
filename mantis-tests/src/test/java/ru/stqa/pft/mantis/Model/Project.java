package ru.stqa.pft.mantis.Model;

/**
 * Created by Алексей on 10.07.2017.
 */
public class Project {
    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }

    private int id;
    private String name;
}
