package controllers;

import API.WeatherAPI;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MainController implements Initializable {

    @FXML
    private Label labelTest;
    @FXML
    private Slider timeSlider;
    @FXML
    private Label hourlyTemp;
    @FXML
    private Label hourlyFeelTemp;
    @FXML
    private Label hourlyHumidity;
    @FXML
    private Label hourlyWindSpeed;
    @FXML
    private Label hourlyPrecip;
    
    private int currentTime;
    private WeatherAPI weatherAPI;
    private Map hourlyData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        weatherAPI = new WeatherAPI("342c4be47e8f894c2e0f514f31d93dae");

        timeSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (timeSlider.isValueChanging()) {
                currentTime = newValue.intValue(); // Set the current time
                updateTime();
            }
        });

        //timeSlider.valueChangingProperty().addListener((obs, wasChanging, isChanging) -> {
        //    if (!isChanging) {
        //        System.out.println(currentTime);
        //    }
        //});
        //weatherAPI.HourlyReport(1);
    }

    private void updateTime() {
        if(currentTime > 0 && currentTime < 25) {
            hourlyData = weatherAPI.HourlyReport(currentTime);
            setHourlyData();
        } else {
            System.out.println("Oops");
        }
    }

    private void setHourlyData() {
        hourlyTemp.setText("Temperature: " + hourlyData.get("Temp").toString() + "c");
        hourlyFeelTemp.setText("Feels Like: " + hourlyData.get("TempFeel").toString() + "c");
        hourlyHumidity.setText("Humidity: " + hourlyData.get("Humidity").toString());
        hourlyWindSpeed.setText("Wind Speed: " + hourlyData.get("WindSpeed").toString());
        hourlyPrecip.setText("Precip: " + hourlyData.get("Precip").toString());
        labelTest.setText(hourlyData.get("TimeStamp").toString());
    }

}
