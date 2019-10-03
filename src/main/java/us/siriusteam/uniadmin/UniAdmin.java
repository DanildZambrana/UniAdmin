package us.siriusteam.uniadmin;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import us.siriusteam.uniadmin.Models.User;
import us.siriusteam.uniadmin.database.sql.users.UsersManager;
import us.siriusteam.uniadmin.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Logger;

public class UniAdmin extends Application {

    private static Logger logger = Logger.getLogger(UniAdmin.class.getName());
    private static Stage primaryStage;
    private static String absolutePath;
    private static UniAdmin instance;
    private static ServerSocket SERVER_SOCKET;

    @Override
    public void start(Stage primaryStage) throws Exception {
        UniAdmin.primaryStage = primaryStage;
        UniAdmin.primaryStage.setTitle("Sistema punto de venta.");
        /*this.primaryStage.initStyle(StageStyle.UNDECORATED);*/

        try {
            SERVER_SOCKET = new ServerSocket(9934);
            initLoginLayout();
        } catch (IOException e) {
            //Carga el diseño de la pantalla de inicio de secion.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/OnlyOneInstanceErrorView.fxml"));
            AnchorPane loginLayout = (AnchorPane) loader.load();

            //Mostrar la escena que contiene el diseño del login.
            Scene scene = new Scene(loginLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            /*Platform.exit();*/
        }
       /* initLoginLayout();*/
    }

    public static void main(String[] args) throws SQLException, IOException {
        Utils.loadFont(getAbsolutePath()+File.separator+"Fonts", "Roboto-Medium.ttf");

        /*usersManager.insert(new User("Admin", "admin", "asdsa", "asdas", LocalDate.now(),"asdasdsa", "asdads", Arrays.asList("hola", "asdas"), new UUID(System.nanoTime(), System.currentTimeMillis()), new LocalDate[15]));*/
        setAbsolutePath();
        instance = new UniAdmin();

        UsersManager usersManager = new UsersManager();
        usersManager.registerTable();
        launch(args);
    }

    /**
     * Pantalla de Logeo
     */
    private void initLoginLayout(){
        initLoginLayout(primaryStage);
    }

    /**
     * Mostrar pantalla de logeo desde otro pane.
     * @param primaryStage
     */
    public void initLoginLayout(Stage primaryStage){
        try {
            //Carga el diseño de la pantalla de inicio de secion.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/LoginScreen.fxml"));
            AnchorPane loginLayout = (AnchorPane) loader.load();

            //Mostrar la escena que contiene el diseño del login.
            Scene scene = new Scene(loginLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Singleton method
     * @return
     */
    public static synchronized UniAdmin getInstance(){
        if(instance == null) instance = new UniAdmin();
        return instance;
    }

    //Obtiene el path donde se ejecuta el programa.
    private static void setAbsolutePath(){
        absolutePath = new File("").getAbsolutePath();
    }

    public static String getAbsolutePath(){
        if(absolutePath == null) setAbsolutePath();
        return absolutePath;
    }
    //Fin de metodos para obtener path donde se ejecuta.

    //Inicio metodos logger

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        UniAdmin.logger = logger;
    }

    //Fin metodos logger.


    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
