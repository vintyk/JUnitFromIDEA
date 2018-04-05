package by.vinty.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class HeroTest {
    private int a,b,expRezult;

    public HeroTest(int a, int b, int expRezult) {
        this.a = a;
        this.b = b;
        this.expRezult = expRezult;
    }

    @Parameterized.Parameters
    public static Collection numbers(){
        return Arrays.asList(new Object[][]{{3,4,7}, {2,9,11},{3,3,6}});
    }

    @Test
    public void sum() {
        Hero hero = new Hero();
        int c = hero.sum(a,b);
        assertThat(c).isNotZero();
        assertThat(c).isEqualTo(expRezult);

    }

}