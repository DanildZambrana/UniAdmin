package us.siriusteam.uniadmin.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class OnlyOneInstanceErrorController {

    @FXML
    private JFXButton btn;

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

}
