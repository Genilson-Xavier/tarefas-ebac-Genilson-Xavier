package br.com.ebac.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    Logger logger = Logger.getLogger(ConnectionFactory.class.getName());
    private final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";
    public Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            getConnection(conn);
            logger.log(Level.INFO,"Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return conn;
    }

    public Connection getConnection(Connection connection) throws SQLException {
        if(connection == null){
            connection = connect();
            return connection;
        }else if(connection.isClosed()){
            connection = connect();
            return connection;
        }else{
            return connection;
        }
    }
}
