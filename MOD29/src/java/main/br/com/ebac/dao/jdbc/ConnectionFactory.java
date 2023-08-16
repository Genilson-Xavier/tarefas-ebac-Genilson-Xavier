/*
 * Desenvolvido por Genilson
 */

public class ConnectionFactory {

    private static Connection conection;

    private ConnectionFactory(Connection conection){

    }

    public static Connection getConection(){
        if (connection == null) {
            connection = initConnection();
            return connection;
        } else if (connection.isClosed()) {
            connection = initConnection();
            return connection;
        } else {
            return connection;
        }
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}