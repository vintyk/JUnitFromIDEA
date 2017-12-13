package by.vinty.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Warrior extends Hero {
    private int health;
    private int force;

    public Warrior(String name, int num, int health, int force) {
        super(name, num);
        this.health = health;
        this.force = force;
    }
}
