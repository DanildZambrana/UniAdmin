package us.siriusteam.uniadmin.database.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConnectSQL {

    /**
     * Se conecta a la base de datos.
     *
     * @return la conexion con la base de datos.
     * @throws SQLException Error de conexion.
     */
    Connection getConnection() throws SQLException;

    /**
     * Cierra la conexion del resultset.
     *
     * @param resultSet objeto a cerrar.
     */
    static void close(ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cierra la conexion del preparedStatment.
     *
     * @param preparedStatement objeto a cerrar.
     */
    static void close(PreparedStatement preparedStatement){
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cierra la conexion a la base de datos.
     *
     * @param connection objeto a cerrar.
     */
    static void close(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}