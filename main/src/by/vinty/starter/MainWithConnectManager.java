package by.vinty.starter;
import connectManager.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWithConnectManager {
    public static void main(String[] args) {
        String createTable = "create table if not exists myTable(id int(10) auto_increment primary key, name varchar(255))";
        String insertTable = "insert into myTable (name) values ('HELLO')";
        String insertTable2 = 
                "insert into myTable (name) values ('from H2-DB!'); " +
                "insert into myTable (name) values ('вот так вот...');" +
                "insert into myTable (name) values (' И insert-ов таких ');" +
                "insert into myTable (name) values (' можно вставить строкой достаточно много.');" +
                "insert into myTable (name) values (' Пока хватит длинны VARCHAR в базе данных ');" +
                "insert into myTable (name) values (' Или String-а в Java. ');"
                ;
        String selectTable = "select * from myTable";

        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTable)) {
                preparedStatement.execute();
                System.out.println("Таблица в памяти создана.");
            }
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(insertTable)) {
                preparedStatement2.executeUpdate();
                System.out.println("В Таблицу записаны данные.");
            }
            try (PreparedStatement preparedStatement3 = connection.prepareStatement(insertTable2)) {
                preparedStatement3.executeUpdate();
                System.out.println("В Таблицу записаны данные.");
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectTable)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("Читаем виртуальную таблицу...");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name"));
                }
            }
//            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(MainWithConnectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
