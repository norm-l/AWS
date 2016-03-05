package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MainController implements Initializable {

    @FXML
    private Label labelTest;
    @FXML
    private Slider timeSlider;

    private final int HOURS = 23;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        timeSlider.setMax(HOURS);

        timeSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (timeSlider.isValueChanging()) {
                if (newValue.intValue() < 12) {
                    labelTest.textProperty().bind(Bindings.format("%.0f:00am", timeSlider.valueProperty()));
                } else {
                    labelTest.textProperty().bind(Bindings.format("%.0f:00pm", timeSlider.valueProperty()));
                }
            }
        });
    }

}
