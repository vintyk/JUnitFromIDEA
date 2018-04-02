package connectManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {

    public static final String URL = "jdbc:h2:mem:kingdom;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
