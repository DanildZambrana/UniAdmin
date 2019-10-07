package us.siriusteam.uniadmin.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import us.siriusteam.uniadmin.Models.StudentsModel;
import us.siriusteam.uniadmin.UniAdmin;
import us.siriusteam.uniadmin.students.Careers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {

    @FXML
    private TableView<StudentsModel> studentsTable;

    @FXML
    private StackPane pane;

    @FXML
    private TableColumn<StudentsModel, String> studentIdColumn;

    @FXML
    private TableColumn<StudentsModel, String> studentNameColumn;

    @FXML
    private TableColumn<StudentsModel, String> studentLastNameColumn;

    @FXML
    private TableColumn<StudentsModel, String> studentCareerColumn;

    private ObservableList<StudentsModel> studentData = FXCollections.observableArrayList();

    @FXML
    private ImageView ivStudentAvatar;

    @FXML
    private JFXTextField tfID;

    @FXML
    private JFXTextField tfName;

    @FXML
    private JFXTextField tfLastName;

    @FXML
    private JFXTextField tfIdCard;

    @FXML
    private JFXTextField tfDateOfBirth;

    @FXML
    private JFXTextField tfSex;

    @FXML
    private JFXTextField tfReligion;

    @FXML
    private JFXTextField tfDirecction;

    @FXML
    private JFXTextField tfCareer;

    @FXML
    private JFXTextField tfYearCursed;

    @FXML
    private JFXTextField tfCivilStatus;

    @FXML
    private JFXTextField tfZone;

    @FXML
    private JFXTextField tfPhoneNumber;

    @FXML
    private JFXTextField tfEmail;

    @FXML
    private JFXButton btnNewStudent;

    @FXML
    private JFXButton btnShowScore;

    @FXML
    private JFXButton btnShowEditStudent;

    @FXML
    private JFXButton btnDeleteStudent;

    @FXML
    void deleteStudent(ActionEvent event) {
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.getStylesheets().add("styles/DialogStyle.css"); //css stylesheet
        layout.setHeading(new Label("Esta seguro de ejecutar esta accion?")); //Title of dialog
        layout.setBody(new Label("Al presionar aceptar eliminara este registro, esta accion no se puede deshacer.\n" +
                "Si no quiere hacerlo, presione cancelar")); // Body of dialog

        JFXDialog dialog = new JFXDialog(pane, layout, JFXDialog.DialogTransition.CENTER, false);

        //Buttons
        JFXButton accept = new JFXButton("Aceptar"); //Accept button
        accept.setOnAction(event1 -> dialog.close());
        accept.setId("options");

        JFXButton cancel = new JFXButton("Cancelar"); //Cancel button
        cancel.setOnAction(event1 -> dialog.close());
        cancel.setId("options");

        layout.setActions(accept, cancel); //Actions of dialog
        dialog.show(); //Show dialog
    }

    @FXML
    void showEditStudent(ActionEvent event) {
        try{
            // Carga el diseño raiz del archivo fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/Edit&NewStudentView.fxml"));
            StackPane studentLayout = (StackPane) loader.load();
            EditAndNewStudentController controller = loader.getController();

            // Mostrar la escena que contiene el diseño de la raiz.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Notas");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(LoginController.getDashBoardStage());
            Scene scene = new Scene(studentLayout);
            dialogStage.setScene(scene);
            controller.setName("Juan Zeledon");

            dialogStage.showAndWait();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    void showScore(ActionEvent event) {
        try{
            // Carga el diseño raiz del archivo fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/ShowScoreView.fxml"));
            StackPane studentLayout = (StackPane) loader.load();

            // Mostrar la escena que contiene el diseño de la raiz.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Notas");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(LoginController.getDashBoardStage());
            Scene scene = new Scene(studentLayout);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void showNewStudent(ActionEvent event) {
        try{
            // Carga el diseño raiz del archivo fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UniAdmin.class.getClassLoader().getResource("views/Edit&NewStudentView.fxml"));
            StackPane studentLayout = (StackPane) loader.load();

            // Mostrar la escena que contiene el diseño de la raiz.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Notas");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(LoginController.getDashBoardStage());
            Scene scene = new Scene(studentLayout);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*studentData.add(new StudentsModel("100", "Juan", "Zeledon", new Careers(25, "Contabilidad", 5)));*/


        studentIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        studentLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        studentCareerColumn.setCellValueFactory(cellData -> cellData.getValue().getCareer().getCareer_name());

        studentsTable.setItems(studentData);
    }


    public ObservableList<StudentsModel> getStudentsData() {
        return studentData;
    }



}
