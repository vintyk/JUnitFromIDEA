package dao;

import by.vinty.entity.People;
import by.vinty.starter.MainWithConnectManager;
import connectManager.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PeopleDaoIT extends TestCase {
    
    private Connection connection;

    public PeopleDaoIT() throws SQLException {
        this.connection = ConnectionManager.getConnection();
    }

    @Before
    public void setUp() {
        String createTable = "create table if not exists people(id int auto_increment primary key, name varchar(255))";
        String insertTable2
                = "insert into people (name) values ('Gimly'); "
                + "insert into people (name) values ('Aragorn');"
                + "insert into people (name) values ('Frodo');"
                + "insert into people (name) values ('Gendalf');"
                + "insert into people (name) values ('Peepen');"
                + "insert into people (name) values ('Legolas');";
        String selectTable = "select * from people";

            try (PreparedStatement preparedStatement = connection.prepareStatement(createTable)) {
                preparedStatement.execute();
                System.out.println("Таблица в памяти создана.");
            } catch (SQLException ex) {
                System.out.println("Ошибка при создании таблицы!");
            Logger.getLogger(PeopleDaoIT.class.getName()).log(Level.SEVERE, null, ex);
        }
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(insertTable2)) {
                preparedStatement2.executeUpdate();
                System.out.println("В Таблицу записаны данные.");
            } catch (SQLException ex) {
                System.out.println("Ошибка при записи данных в таблицу!");
            Logger.getLogger(PeopleDaoIT.class.getName()).log(Level.SEVERE, null, ex);
        }
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectTable)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("Читаем виртуальную таблицу...");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
                }
            } catch (SQLException ex) {
                System.out.println("Ошибка при чтении списка из БД!");
            Logger.getLogger(PeopleDaoIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSave() {
        People hero = new People();
        hero.setId(5);
        hero.setName("Zuza");
        Long tempId = PeopleDao.getInstance().save(hero);
        
        System.out.println(PeopleDao.getInstance().findById(1L).get());
        System.out.println(PeopleDao.getInstance().findById(2L).get());
        System.out.println(PeopleDao.getInstance().findById(tempId).get());
        Assert.assertEquals((long) tempId, (long) PeopleDao.getInstance().findById(tempId).get().getId());
        Assert.assertEquals(hero.getName(), PeopleDao.getInstance().findById(tempId).get().getName());
    }
    
    @After
    public void enfOfTest(){
        String selectTableInTheEnd = "select * from people";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectTableInTheEnd)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("Тесты пройдены... Читаем таблицу.");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
                }
            } catch (SQLException ex) {
                System.out.println("Ошибка при чтении списка из БД!");
            Logger.getLogger(PeopleDaoIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeopleDaoIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
