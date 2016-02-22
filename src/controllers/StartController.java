package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import model.Main;


public class StartController implements Initializable {

    @FXML private Button switchBtn;
    @FXML private Label aiLabel;
    @FXML private TextField nameField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aiLabel.setWrapText(true);
        aiLabel.setTextAlignment(TextAlignment.CENTER);
        aiLabel.setText("Hey Stranger, I'm Alice - the Artificial Intelligence of this application."
                + " First things first... what's your name? :)");
    }
    
    @FXML private void switchToMain(ActionEvent event) {
        if(!"".equals(nameField.getText())) {
            try {
                URL smallUrl = getClass()
                        .getResource("/resources/view/small/Main.fxml");
                AnchorPane smallScreen = FXMLLoader.load(smallUrl);

                BorderPane border = Main.getRoot();
                border.setCenter(smallScreen);

                Main.getStage().setWidth(320+16);
                Main.getStage().setHeight(480+74);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            aiLabel.setText("Surely you have a name?..");
        }
    }
}
