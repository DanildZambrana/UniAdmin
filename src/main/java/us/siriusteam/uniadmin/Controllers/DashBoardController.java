package us.siriusteam.uniadmin.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import us.siriusteam.uniadmin.Models.StudentsModel;
import us.siriusteam.uniadmin.UniAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private ImageView logoImage = new ImageView();

    @FXML
    private Label lblDashBoard = new Label();

    @FXML
    private Label lblStudents = new Label();

    @FXML
    private ImageView userImage ;

    @FXML
    private Label lblUserName = new Label();

    @FXML
    private JFXButton btnConfig;

    @FXML
    private JFXButton btnLogout;


    @FXML
    void logout(ActionEvent event) {
        UniAdmin.getInstance().initLoginLayout(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void showConfig(ActionEvent event) {

    }

    @FXML
    void showDashBoardView(MouseEvent event) {
        selectMenu(lblDashBoard);
        LoginController.setCenter(new AnchorPane());
    }

    @FXML
    void showInfo(MouseEvent event) {

    }

    @FXML
    void showStudentsView(MouseEvent event) {
        try {
            Stage primaryStage = new Stage();
            //Carga el diseño de la pantalla de inicio de secion.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/StudentsView.fxml"));
            AnchorPane studentsLayout = (AnchorPane) loader.load();

            //Mostrar la escena que contiene el diseño del login.
            LoginController.setCenter(studentsLayout);
            selectMenu(lblStudents);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void showUserInfo(MouseEvent event) {

    }


    private ObservableList<StudentsModel> studentData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       selectMenu(lblDashBoard);
        Circle circle = new Circle(20, 20, 19);
        userImage.setClip(circle);
        userImage.setPreserveRatio(false);
    }

    private void selectMenu(Label label){
        List<Label> labels = Arrays.asList(lblDashBoard, lblStudents);
        labels.forEach(l -> l.setStyle("-fx-opacity: 0.5"));
        label.setStyle("-fx-opacity: 1");
    }
}
