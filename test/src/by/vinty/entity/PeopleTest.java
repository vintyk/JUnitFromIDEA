package by.vinty.entity;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.entry;

public class PeopleTest {

    @Before
    public void setUp() {
    }

    @Test
    public void exeptionIsTrue() {
        List peopleList = new ArrayList();
        peopleList.add(new People(1, "Vinty"));
        Assertions.assertThat(peopleList).isNotEmpty();
    }

    @Test
    public void defaultConstructorMap(){
        Map<String, People> map = new HashMap<>();
        Assertions.assertThat(map).isEmpty();
        Assertions.assertThat(map).hasSize(0);
        Assertions.assertThat(map).doesNotContainKey("x");
        assertThat(map.entrySet().iterator().hasNext()).isFalse();
        // или
        Assertions.assertThat(map)
                .hasSize(0)
                .doesNotContainKey("x")
                .isEmpty();
    }

    @Test
    public void mapCopy(){
        Map<String, People> map = new HashMap<>();
        map.put("a", new People(39, "Nikolya"));
        map.put("b", new People(38, "Serge"));

        Map<String, People> copiedMap = new HashMap<>(map);

        Assertions.assertThat(copiedMap)
                .describedAs("copiedMap")
                .hasSize(2)
                // скопированный map равен оригинальному
                .isEqualTo(map)
                // но это не тот же самый объект! Это ссылки на разные объекты!
                .isNotSameAs(map);

        People people = new People();
        people.setId(41);
        people.setName("Dima");
        map.put("d", people);
        Assertions.assertThat(map).containsKey("d");
        Assertions.assertThat(map).contains(entry("d", people));
        Assertions.assertThat(map).containsKey("Виталик");
        Assertions.assertThat(map).containsKey("Виталик");

        Assertions.assertThat(copiedMap)
                .hasSize(2)
                .doesNotContain(entry("d", new People()))
                .isNotEqualTo(map);

    }
}