package us.siriusteam.uniadmin.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import us.siriusteam.uniadmin.Models.StudentsModel;
import us.siriusteam.uniadmin.UniAdmin;
import us.siriusteam.uniadmin.students.Careers;
import us.siriusteam.uniadmin.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
    void deleteStudent(ActionEvent event) {
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.getStylesheets().add("styles/DialogStyle.css"); //css stylesheet
        layout.setHeading(new Label("Esta seguro de ejecutar esta accion?")); //Title of dialog
        layout.setBody(new Label("Al presionar aceptar eliminara este registro, esta accion no se puede deshacer.\n" +
                "Si no quiere hacerlo, presione cancelar")); // Body of dialog

        JFXDialog dialog = new JFXDialog(pane, layout, JFXDialog.DialogTransition.CENTER);

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

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentData.add(new StudentsModel("100", "Juan", "Zeledon", new Careers(25, "Contabilidad", 5)));
        studentData.add(new StudentsModel("110", "Pedro", "Zeledon", new Careers(25, "IGA", 5)));
        studentData.add(new StudentsModel("120", "Julia", "Zeledon", new Careers(25, "Sistemas", 5)));
        studentData.add(new StudentsModel("130", "Maria", "Zeledon", new Careers(25, "Ingles", 5)));
        studentData.add(new StudentsModel("140", "Jose", "Zeledon", new Careers(25, "Enfermeria", 5)));
studentData.add(new StudentsModel("100", "Juan", "Zeledon", new Careers(25, "Contabilidad", 5)));
        studentData.add(new StudentsModel("110", "Pedro", "Zeledon", new Careers(25, "IGA", 5)));
        studentData.add(new StudentsModel("120", "Julia", "Zeledon", new Careers(25, "Sistemas", 5)));
        studentData.add(new StudentsModel("130", "Maria", "Zeledon", new Careers(25, "Ingles", 5)));
        studentData.add(new StudentsModel("140", "Jose", "Zeledon", new Careers(25, "Enfermeria", 5)));
studentData.add(new StudentsModel("100", "Juan", "Zeledon", new Careers(25, "Contabilidad", 5)));
        studentData.add(new StudentsModel("110", "Pedro", "Zeledon", new Careers(25, "IGA", 5)));
        studentData.add(new StudentsModel("120", "Julia", "Zeledon", new Careers(25, "Sistemas", 5)));
        studentData.add(new StudentsModel("130", "Maria", "Zeledon", new Careers(25, "Ingles", 5)));
        studentData.add(new StudentsModel("140", "Jose", "Zeledon", new Careers(25, "Enfermeria", 5)));
studentData.add(new StudentsModel("100", "Juan", "Zeledon", new Careers(25, "Contabilidad", 5)));
        studentData.add(new StudentsModel("110", "Pedro", "Zeledon", new Careers(25, "IGA", 5)));
        studentData.add(new StudentsModel("120", "Julia", "Zeledon", new Careers(25, "Sistemas", 5)));
        studentData.add(new StudentsModel("130", "Maria", "Zeledon", new Careers(25, "Ingles", 5)));
        studentData.add(new StudentsModel("140", "Jose", "Zeledon", new Careers(25, "Enfermeria", 5)));
studentData.add(new StudentsModel("100", "Juan", "Zeledon", new Careers(25, "Contabilidad", 5)));
        studentData.add(new StudentsModel("110", "Pedro", "Zeledon", new Careers(25, "IGA", 5)));
        studentData.add(new StudentsModel("120", "Julia", "Zeledon", new Careers(25, "Sistemas", 5)));
        studentData.add(new StudentsModel("130", "Maria", "Zeledon", new Careers(25, "Ingles", 5)));
        studentData.add(new StudentsModel("140", "Jose", "Zeledon", new Careers(25, "Enfermeria", 5)));


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
