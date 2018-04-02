package by.vinty.entity;

import dao.PeopleDaoIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HeroTest.class
        , CalculatorImplTest.class
        , PeopleTest.class
        , WarriorTest.class
        , StringTest.class
        ,PeopleDaoIT.class
})
public class _TestSuite {
}

