package us.siriusteam.uniadmin.database.sql.users;

import us.siriusteam.uniadmin.database.DataBaseManager;
import us.siriusteam.uniadmin.database.sql.ConnectSQL;
import us.siriusteam.uniadmin.Models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class UsersManager implements DataBaseManager {

    private ConnectUsers connectUsers = null;
    private Connection sqlConnection = null;

    {
        connectUsers = new ConnectUsers();
    }

    @Override
    public void registerTable() {
        Connection conn = null;

        String query = "CREATE TABLE IF NOT EXISTS users\n" +
                "(\n" +
                "\tID INTEGER not null\n" +
                "\t\tconstraint users_pk\n" +
                "\t\t\tprimary key autoincrement,\n" +
                "\tUUID TEXT not null,\n" +
                "\tUserName TEXT,\n" +
                "\tPassword TEXT,\n" +
                "\tName TEXT,\n" +
                "\tLastName TEXT,\n" +
                "\tDateOfBirth TEXT,\n" +
                "\tAddress TEXT,\n" +
                "\tProfileImageLocation TEXT,\n" +
                "\tPermissions TEXT\n" +
                ");\n";
        //Ejecutando consulta
        try{
            conn = connectUsers.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null) ConnectSQL.close(conn);
        }
    }

    @Override
    public int insert(User user) throws SQLException {
        //Parametros del objeto usuario.
        String userName = user.getUserName();
        String password= user.getPassword();
        String name = user.getName();
        String lastName = user.getLastName();
        LocalDate dateOfBirth = user.getDateOfBirth();
        String address = user.getAddress();
        String profileImageLocation = user.getProfileImageLocation();
        UUID uniqueId = user.getUniqueId();
        List<String> permissions = user.getPermissions();
        //Fin de los parametros del objeto usuario.

        final String QUERY = "INSERT INTO users(UUID, UserName, Password, Name, LastName, DateOfBirth, Address, ProfileImageLocation, Permissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int rows;

        try {
            connection = (sqlConnection != null) ? sqlConnection : connectUsers.getConnection();
            int index = 1;
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(index++, uniqueId.toString());
            preparedStatement.setString(index++, userName);
            preparedStatement.setString(index++, password);
            preparedStatement.setString(index++, name);
            preparedStatement.setString(index++, lastName);
            preparedStatement.setString(index++, dateOfBirth.toString());
            preparedStatement.setString(index++, address);
            preparedStatement.setString(index++, profileImageLocation);
            preparedStatement.setString(index, permissions.toString());

            rows = preparedStatement.executeUpdate();
        }finally {
            ConnectSQL.close(preparedStatement);
            if(connection != null) ConnectSQL.close(connection);
        }
        return rows;
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public List<User> selectAll() throws SQLException {
        return null;
    }

    @Override
    public User getUser(UUID uniqueId) throws SQLException {
        return null;
    }

    @Override
    public User getUser(String userName) throws SQLException {
        final String QUERY = "SELECT * FROM users WHERE UserName=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        User user = null;

        try {
            connection = (sqlConnection != null) ? sqlConnection : connectUsers.getConnection();
            int index = 1;
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(index, userName);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();

                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setName(resultSet.getString("Name"));
                user.setLastName(resultSet.getString("LastName"));
                String[] date = resultSet.getString("DateOfBirth").split("-");

                user.setDateOfBirth(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                user.setAddress(resultSet.getString("Address"));
                user.setProfileImageLocation(resultSet.getString("ProfileImageLocation"));
                user.setUniqueId(UUID.fromString(resultSet.getString("UUID")));

                String perms = resultSet.getString("Permissions");
                List<String> permissions = (perms.equals("[]") ? new ArrayList<>() : Arrays.asList(perms.substring(1, perms.length() - 1).split(", ")));
                user.setPermissions(permissions);
            }else {
                return null;
            }

            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectSQL.close(preparedStatement);
            ConnectSQL.close(resultSet);
            if(connection != null) ConnectSQL.close(connection);
        }
        return null;
    }

    /**
     * Comprueba si se obtuvo un dato al ejecutar la sentencia sql.
     * @param rs
     * @return false si la encontro, retorna true si no encontro datos.
     */
    public static boolean isFilled(ResultSet rs){
        boolean isEmpty = true;
        try {
            while(rs.next()){
                isEmpty = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !isEmpty;
    }
}
