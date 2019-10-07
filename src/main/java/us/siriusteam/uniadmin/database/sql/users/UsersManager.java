package us.siriusteam.uniadmin.database.sql.users;

import us.siriusteam.uniadmin.database.DataBaseManager;
import us.siriusteam.uniadmin.database.sql.ConnectSQL;
import us.siriusteam.uniadmin.Models.UserModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class UsersManager implements DataBaseManager<UserModel> {

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
    public int insert(UserModel userModel) throws SQLException {
        //Parametros del objeto usuario.
        String userName = userModel.getUserName();
        String password= userModel.getPassword();
        String name = userModel.getName();
        String lastName = userModel.getLastName();
        LocalDate dateOfBirth = userModel.getDateOfBirth();
        String address = userModel.getAddress();
        String profileImageLocation = userModel.getProfileImageLocation();
        UUID uniqueId = userModel.getUniqueId();
        List<String> permissions = userModel.getPermissions();
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
    public int update(UserModel userModel) throws SQLException {
        return 0;
    }

    @Override
    public List<UserModel> selectAll() throws SQLException {
        return null;
    }

    @Override
    public UserModel get(UUID uniqueId) throws SQLException {
        return null;
    }

    @Override
    public UserModel get(String userName) throws SQLException {
        final String QUERY = "SELECT * FROM users WHERE UserName=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        UserModel userModel = null;

        try {
            connection = (sqlConnection != null) ? sqlConnection : connectUsers.getConnection();
            int index = 1;
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(index, userName);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                userModel = new UserModel();

                userModel.setUserName(resultSet.getString("UserName"));
                userModel.setPassword(resultSet.getString("Password"));
                userModel.setName(resultSet.getString("Name"));
                userModel.setLastName(resultSet.getString("LastName"));
                String[] date = resultSet.getString("DateOfBirth").split("-");

                userModel.setDateOfBirth(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                userModel.setAddress(resultSet.getString("Address"));
                userModel.setProfileImageLocation(resultSet.getString("ProfileImageLocation"));
                userModel.setUniqueId(UUID.fromString(resultSet.getString("UUID")));

                String perms = resultSet.getString("Permissions");
                List<String> permissions = (perms.equals("[]") ? new ArrayList<>() : Arrays.asList(perms.substring(1, perms.length() - 1).split(", ")));
                userModel.setPermissions(permissions);
            }else {
                return null;
            }

            return userModel;
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
