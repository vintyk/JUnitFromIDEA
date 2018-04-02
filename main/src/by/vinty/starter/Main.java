package by.vinty.starter;

import by.vinty.entity.People;
import by.vinty.entity.Test;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:kingdom;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1");
            
            Statement st = conn.createStatement();
            st.execute("create table paws(name varchar(20))");
            
            Statement st2 = conn.createStatement();
            st2.executeUpdate("insert into paws (name) values ('HELLO!')");
            
            Statement st3 = conn.createStatement();
            ResultSet executeFromDb = st3.executeQuery("select * from paws");
            if (executeFromDb.next()){
                System.out.println(executeFromDb.getString("name"));
            }
            
            System.out.println("Таблица создана успешно!");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

//        List<Integer> list = new ArrayList<>();
//
//        Integer i1 = 5;
//        Integer i2 = 5;
//        Integer i3 = 130;
//        Integer i4 = 130;
//
//        System.out.println(i1 == i2);
//        System.out.println(i1.equals(i2));
//
//        System.out.println(i1 == i3);
//        System.out.println(i3.equals(i4));
//
//        System.out.println(i3 == i4);
//
//        People people = new People();
//        people.setName("sasasasasas");
//        System.out.println(people);
//
//        Test test = new Test();
//        test.setName("Vinty");
//        System.out.println("test");
    }
}
