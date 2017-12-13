package by.vinty.entity;

public class Hero {
    protected String name;
    protected int num;

    public Hero() {
    }

    public Hero(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
