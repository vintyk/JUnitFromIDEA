package by.vinty.starter;

import by.vinty.entity.People;
import by.vinty.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Integer i1 = 5;
        Integer i2 = 5;
        Integer i3 = 130;
        Integer i4 = 130;

        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        System.out.println(i1 == i3);
        System.out.println(i3.equals(i4));

        System.out.println(i3 == i4);

        People people = new People();
        people.setName("sasasasasas");
        System.out.println(people);

        Test test = new Test();
        test.setName("Vinty");
        System.out.println("test");
    }
}
