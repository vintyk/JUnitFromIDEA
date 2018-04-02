package by.vinty.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WarriorTest {

    @Test
    public void classTest() {
        Warrior warrior = new Warrior();
        warrior.setName("Арагорн");
        warrior.setNum(87);
        warrior.setHealth(250);
        warrior.setForce(50);
        assertTrue(250 == warrior.getHealth());
        Assert.assertEquals(87, warrior.getNum());
    }

    @Test
    public void getsMetods() {
        Warrior warrior = new Warrior("Арагорн", 87, 250, 50);
        System.out.println(warrior);
        Assert.assertEquals("Арагорн", warrior.getName());
    }

    @Test
    public void testWarriorList() {
        List<Warrior> warriorList = new ArrayList<>();

        Warrior warrior = new Warrior();
        warrior.setName("Aragorn");
        warrior.setHealth(255);
        warrior.setNum(87);
        warrior.setForce(90);
        warriorList.add(warrior);

        warriorList
                .stream()
                .collect(Collectors.toList());
        System.out.println(warriorList);
    }
}
