package controllers;

import API.WeatherAPI;
import com.github.dvdme.ForecastIOLib.ForecastIO;
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
    private int currentTime;
    private WeatherAPI weatherAPI;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        timeSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (timeSlider.isValueChanging()) {
                currentTime = newValue.intValue(); // Set the current time
                updateTime();
                if (newValue.intValue() < 12) {
                    labelTest.textProperty().bind(Bindings.format("%.0f:00am", timeSlider.valueProperty())); // Adjust binding
                } else {
                    labelTest.textProperty().bind(Bindings.format("%.0f:00pm", timeSlider.valueProperty())); // Adjust binding
                }
            }
        });
        
        //timeSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
        //    if (!isChanging) {
        //        System.out.println(currentTime);
        //    }
        //});

        weatherAPI = new WeatherAPI("342c4be47e8f894c2e0f514f31d93dae");
        weatherAPI.HourlyReport();
    }

    private void updateTime() {
        switch (currentTime) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            default:
                System.out.println("Don't know");
                break;
        }
    }

}
