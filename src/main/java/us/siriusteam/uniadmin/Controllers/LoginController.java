package us.siriusteam.uniadmin.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import us.siriusteam.uniadmin.UniAdmin;
import us.siriusteam.uniadmin.database.sql.users.UsersManager;
import us.siriusteam.uniadmin.Models.UserModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField tfUserName;

    @FXML
    private JFXPasswordField pfPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnForgotPassword;

    @FXML
    private Label lblInformation;

    @FXML
    private JFXSpinner spinnerLoading;

    @FXML
    private Label lblLoading;

    @FXML
    void login(ActionEvent event) throws SQLException {
        if(tfUserName.getText().equals("")){
            lblInformation.setText("Ingrese su nombre de usuario por favor.");
            tfUserName.setUnFocusColor(new Color(1, 0, 0, 1));
        }else {
            if(pfPassword.getText().equals("")){
                lblInformation.setText("Ingrese su nombre de contraseña por favor.");
                pfPassword.setUnFocusColor(new Color(1, 0, 0, 1));
            }else {
                spinnerLoading.setOpacity(1);
                if(login(tfUserName.getText(), pfPassword.getText())) {
                    showDashBoard(event);
                }else {
                    lblInformation.setText("Nombre de usuario o contraseña incorrecta.");
                    spinnerLoading.setOpacity(0);
                }
            }
        }
    }

    @FXML
    void recoverPass(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private boolean login(String userName, String pass) throws SQLException {
        UsersManager usersManager = new UsersManager();

        UserModel userModel = null;
        try {
            userModel = usersManager.get(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(userModel == null){
            return false;
        }
        return pass.equals(userModel.getPassword());
    }

    private static BorderPane rootLayout;

    private static Stage dashBoardStage = new Stage();
    private void showDashBoard(ActionEvent event){
        try{
            // Carga el diseño raiz del archivo fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/DashBoardScreen.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostrar la escena que contiene el diseño de la raiz.
            Scene scene = new Scene(rootLayout);
            dashBoardStage.setScene(scene);
            dashBoardStage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Stage getDashBoardStage() {
        return dashBoardStage;
    }

    public static void setCenter(AnchorPane pane){
        rootLayout.setCenter(pane);
    }
}
