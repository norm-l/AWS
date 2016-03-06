package controllers;

import API.WeatherAPI;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController implements Initializable {

    @FXML
    private Label timeCheck;
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
    
    @FXML
    private Label artInt;
    
    @FXML private Label day1;
    @FXML private Label day1Temp;
    @FXML private ImageView day1Img;
    
    @FXML private Label day2;
    @FXML private Label day2Temp;
    @FXML private ImageView day2Img;
    
    @FXML private Label day3;
    @FXML private Label day3Temp;
    @FXML private ImageView day3Img;
    
    @FXML private Label day4;
    @FXML private Label day4Temp;
    @FXML private ImageView day4Img;
    
    @FXML private Label day5;
    @FXML private Label day5Temp;
    @FXML private ImageView day5Img;
    
    @FXML private Label day6;
    @FXML private Label day6Temp;
    @FXML private ImageView day6Img;
    
    @FXML private ImageView iconImg;
    
    private final Image CLEAR_DAY = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/clear_day.png"));
    private final Image CLEAR_NIGHT = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/clear_night.png"));
    private final Image RAIN = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/rain.png"));
    private final Image SNOW = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/snow.png"));
    private final Image SLEET = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/sleet.png"));
    private final Image WIND = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/wind.png"));
    private final Image FOG = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/fog.png"));
    private final Image CLOUDY = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/cloudy.png"));
    private final Image PARTLY_CLOUDY_DAY = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/partly_cloudy_day.png"));
    private final Image PARTLY_CLOUDY_NIGHT = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/partly_cloudy_night.png"));
    private final Image UNKNOWN = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/icons/na.png"));
    
    private int currentTime;
    private WeatherAPI weatherAPI;
    private Map hourlyData;
    private Map dailyData;
    private ArrayList<String> alertData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        weatherAPI = new WeatherAPI("342c4be47e8f894c2e0f514f31d93dae");
        setDailyData();
        
        timeSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (timeSlider.isValueChanging()) {
                currentTime = newValue.intValue(); // Set the current time
                updateTime();
            }
        });
    }

    private void updateTime() {
        if(currentTime > 0 && currentTime < 25) {
            hourlyData = weatherAPI.hourlyReport(currentTime);
            setHourlyData();
        } else {
            System.out.println("Error!");
        }
    }

    private void setHourlyData() {
        hourlyTemp.setText(hourlyData.get("Temp").toString() + "c");
        hourlyFeelTemp.setText(hourlyData.get("TempFeel").toString() + "c");
        hourlyHumidity.setText(hourlyData.get("Humidity").toString());
        hourlyWindSpeed.setText(hourlyData.get("WindSpeed").toString());
        hourlyPrecip.setText(hourlyData.get("Precip").toString());
        timeCheck.setText(hourlyData.get("TimeStamp").toString());
        artInt.setText(hourlyData.get("Summary").toString());
        
        switch (hourlyData.get("Icon").toString()) {
            case "\"clear-day\"":
                iconImg.setImage(CLEAR_DAY);
                break;
            case "\"clear-night\"":
                iconImg.setImage(CLEAR_NIGHT);
                break;
            case "\"rain\"":
                iconImg.setImage(RAIN);
                break;
            case "\"snow\"":
                iconImg.setImage(SNOW);
                break;
            case "\"sleet\"":
                iconImg.setImage(SLEET);
                break;
            case "\"wind\"":
                iconImg.setImage(WIND);
                break;
            case "\"fog\"":
                iconImg.setImage(FOG);
                break;
            case "\"cloudy\"":
                iconImg.setImage(CLOUDY);
                break;
            case "\"partly-cloudy-day\"":
                iconImg.setImage(PARTLY_CLOUDY_DAY);
                break;
            case "\"partly-cloudy-night\"":
                iconImg.setImage(PARTLY_CLOUDY_NIGHT);
                break;
            default:
                iconImg.setImage(UNKNOWN);
                break;
        }
        
    }
    
    private void setDailyData() {
       // weatherAPI.dailyReport(1);
        //System.out.println("IT FUCKING WORKS...:" + dailyData.get("Temp").toString());
        //day1.setText(dailyData.get(""));
        //day1Temp.setText(dailyData.get("Temp").toString() + "c");
        //day1Temp.setText("Test");
        /*
       dailyData = weatherAPI.DailyReport(2);
        //day2.setText("");
     day2Temp.setText(dailyData.get("Temp").toString() + "c");
        
        dailyData = weatherAPI.DailyReport(3);
        //day3.setText("");
        day3Temp.setText(dailyData.get("Temp").toString() + "c");
        
        dailyData = weatherAPI.DailyReport(4);
        //day4.setText("");
        day4Temp.setText(dailyData.get("Temp").toString() + "c");
        
        dailyData = weatherAPI.DailyReport(5);
        //day5.setText("");
        day5Temp.setText(dailyData.get("Temp").toString() + "c");
        
        dailyData = weatherAPI.DailyReport(6);
        //day6.setText("");
        day6Temp.setText(dailyData.get("Temp").toString() + "c");*/
    }

}
