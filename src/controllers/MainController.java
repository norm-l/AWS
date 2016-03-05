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
    private final int MIN_CHANGE = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        timeSlider.setMax(HOURS);

        //labelTest.textProperty().bind(Bindings.format("%.0f:00am", timeSlider.valueProperty()));

    timeSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
        if (isChanging) { // If the slider has stopped changing set the new time
            if(timeSlider.getValue() < 12.99) {
                labelTest.textProperty().bind(Bindings.format("%.0f:00am", timeSlider.valueProperty()));
            } else {
                labelTest.textProperty().bind(Bindings.format("%.0f:00pm", timeSlider.valueProperty()));
            }
        }
    });

    /*timeSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
        if (!timeSlider.isValueChanging()) {
            if (Math.abs(newValue.intValue()) > MIN_CHANGE) {
                timeSlider.setValue(newValue.intValue());
            }
        }
    });*/
    }

}
