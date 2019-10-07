package us.siriusteam.uniadmin.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class EditAndNewStudentController {

    @FXML
    private JFXTextField tfNames;

    @FXML
    private JFXTextField tfLastName;

    @FXML
    private JFXComboBox<?> cbCareers;

    @FXML
    private JFXTextField tfYearCursed;

    @FXML
    private ToggleGroup religion;

    @FXML
    private JFXTextField tfOtherReligion;

    @FXML
    private JFXTextField tfIdCard;

    @FXML
    private JFXTextField tfCity;

    @FXML
    private JFXTextField tfDepartment;

    @FXML
    private JFXTextField tfcountry;

    @FXML
    private ToggleGroup zone;

    @FXML
    private JFXTextField tfPhoneNumber;

    @FXML
    private JFXTextField tfEmail;

    @FXML
    private JFXComboBox<?> cbSex;

    @FXML
    private JFXDatePicker dpDateOfBirth;

    @FXML
    private JFXTextField tfId;

    @FXML
    private ToggleGroup civilStatus;

    @FXML
    private JFXButton btnAccept;

    @FXML
    private JFXButton btnCancel;

    @FXML
    void accept(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    public void setName(String name){
        this.tfNames.setText(name);
    }

}