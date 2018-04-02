package by.vinty.entity;

public class People {
    private int id;
    private String name;

    public People() {
    }

    public People(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" + "id=" + id + ", name=" + name + '}';
    }
}
