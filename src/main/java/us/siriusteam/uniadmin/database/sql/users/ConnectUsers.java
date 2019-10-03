package us.siriusteam.uniadmin.database.sql.users;

import us.siriusteam.uniadmin.UniAdmin;
import us.siriusteam.uniadmin.database.sql.ConnectSQL;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUsers implements ConnectSQL {

    private static String url;

    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;

        try{
            //Parametros de la base de datos.
            File file = new File(UniAdmin.getAbsolutePath() + File.separator + "Data");
            if(!file.exists()) file.mkdir();

            url = "jdbc:sqlite:"+ UniAdmin.getAbsolutePath() + File.separator + "Data" + File.separator + "DataUsers.db";

            //Creando conexion a la base de datos.
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectUsers.url = url;
    }
}
