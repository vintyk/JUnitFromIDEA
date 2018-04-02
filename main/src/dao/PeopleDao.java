package dao;

import by.vinty.entity.People;
import connectManager.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class PeopleDao {
    private static final Object LOCK = new Object();
    private static PeopleDao INSTANCE = null;

    public static PeopleDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PeopleDao();
                }
            }
        }
        return INSTANCE;
    }
    
    public Long save(People people) {
        Long peopleId = null;
        String sql = "INSERT INTO people (name) values (?);";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, people.getName());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    peopleId = generatedKeys.getLong(1);
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleId;
    }
    
    public Optional<People> findById(Long id) {
        String sql = "select * from people where id =?;";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    return Optional.of(new People(
                            resultSet.getInt("id"),
                            resultSet.getString("name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return Optional.empty();
    }
}
