package models;

import java.io.Serializable;

public class Cat implements Serializable {
    private static final long serialVersionUID = 12345L;
    String name;
    String bread;
    String color;
    int age;

    public Cat(String name, String bread, String color, int age) {
        this.name = name;
        this.bread = bread;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", bread='" + bread + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
