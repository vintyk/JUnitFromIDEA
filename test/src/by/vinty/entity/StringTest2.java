package by.vinty.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringTest2 {

    private String str1 = "";
    private String str2 = "";

    @Before
    public void createElements(){
        List<String> listStr = new ArrayList<String>();
        listStr.add("Hello");
        listStr.add("Vinty");
        listStr.add("Masha");
        listStr.add("Vinty");
        listStr.add("Natasha");
        List<Integer> listInt = new ArrayList<Integer>();
        listInt.add(5);
        listInt.add(10);
        listInt.add(20);
        listInt.add(5);
        listInt.add(7);
        listInt.add(5);
        str2 = listStr.get(0);
    }

    @Test
    public void testSubstr(){
        str1="llo";
        Assert.assertEquals(str1, str2.substring(2));
    }

    @After
    public void clear(){
        str1 = "";
        str2 = "";
    }
}
