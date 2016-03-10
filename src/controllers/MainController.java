package controllers;

import model.api.WeatherAPI;

import java.net.URL;
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
    @FXML
    private Label cityLbl;
    @FXML
    private ImageView tempView;
    @FXML
    private ImageView windView;
    @FXML
    private ImageView humView;
    @FXML
    private ImageView day1Img;
    @FXML
    private ImageView day2Img;
    @FXML
    private ImageView day3Img;
    @FXML
    private ImageView day4Img;
    @FXML
    private ImageView day5Img;
    @FXML
    private ImageView day6Img;
    @FXML
    private ImageView day7Img;
    @FXML
    private ImageView day8Img;
    @FXML
    private ImageView day9Img;
    @FXML
    private ImageView day10Img;
    @FXML
    private ImageView day11Img;
    @FXML
    private ImageView day12Img;
    @FXML
    private ImageView day13Img;
    @FXML
    private ImageView iconImg;

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
    private final Image TEMPIMG = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/temperature.png"));
    private final Image WINDIMG = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/wind.png"));
    private final Image HUMIMG = new Image(
            getClass().getClassLoader().getResourceAsStream("resources/images/humidity.png"));

    private final String KEY = "342c4be47e8f894c2e0f514f31d93dae";
    private int currentTime;
    private WeatherAPI weatherAPI;
    private Map hourlyData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Default location
        setCity("London", "51.5072", "0.1275");

        timeSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (timeSlider.isValueChanging()) {
                currentTime = newValue.intValue(); // Set the current time
                updateTime();
            }
        });

        tempView.setImage(TEMPIMG);
        windView.setImage(WINDIMG);
        humView.setImage(HUMIMG);

        day1Img.setImage(CLEAR_DAY);
        day2Img.setImage(CLEAR_DAY);
        day3Img.setImage(RAIN);
        day4Img.setImage(WIND);
        day5Img.setImage(CLOUDY);
        day6Img.setImage(CLOUDY);
        day7Img.setImage(RAIN);
        day8Img.setImage(RAIN);
        day9Img.setImage(WIND);
        day10Img.setImage(CLOUDY);
        day11Img.setImage(PARTLY_CLOUDY_DAY);
        day12Img.setImage(CLOUDY);
        day13Img.setImage(RAIN);
    }

    private void updateTime() {
        if (currentTime > 0 && currentTime < 25) {
            hourlyData = weatherAPI.hourlyReport(currentTime);
            setHourlyData();
        } else {
            System.out.println("Error!");
        }
    }

    public void setCity(String city, String lat, String lon) {
        cityLbl.setText(city);
        weatherAPI = new WeatherAPI(KEY, lat, lon);
    }

    private void setHourlyData() {
        hourlyTemp.setText(hourlyData.get("Temp") + "°C");
        hourlyFeelTemp.setText(hourlyData.get("TempFeel") + "°C");
        hourlyHumidity.setText(hourlyData.get("Humidity") + "%");
        hourlyWindSpeed.setText(hourlyData.get("WindSpeed") + " mph");
        hourlyPrecip.setText(hourlyData.get("Precip") + "%");
        timeCheck.setText(hourlyData.get("TimeStamp").toString());

        String text;

        switch (hourlyData.get("Icon").toString()) {
            case "\"clear-day\"":
                iconImg.setImage(CLEAR_DAY);
                text = "Alice: It's a clear day at this time!\n"
                        + " enjoy the weather while you can! :)";
                break;
            case "\"clear-night\"":
                iconImg.setImage(CLEAR_NIGHT);
                text = "Alice: It's going to be a clear night!\n"
                        + " You'll be getting a peaceful nights rest tonight.";
                break;
            case "\"rain\"":
                iconImg.setImage(RAIN);
                text = "Alice: You may want to bring an umbrella\n"
                        + " if you're going out! It's going to be raining.";
                break;
            case "\"snow\"":
                iconImg.setImage(SNOW);
                text = "Alice: Hope you like snow as some will be falling\n"
                        + " at this time!";
                break;
            case "\"sleet\"":
                iconImg.setImage(SLEET);
                text = "Alice: It's going to be raining... \n"
                        + "and snowing at the same time!";
                break;
            case "\"wind\"":
                iconImg.setImage(WIND);
                text = "Alice: Hope you ate today as it's windy today..\n"
                        + " Don't want to be blown away!";
                break;
            case "\"fog\"":
                iconImg.setImage(FOG);
                text = "Alice: Your glasses won't help at this time\n"
                        + " because it's foggy!";
                break;
            case "\"cloudy\"":
                iconImg.setImage(CLOUDY);
                text = "Alice: I don't think you'll see much in the sky\n"
                        + " right now because it's cloudy!";
                break;
            case "\"partly-cloudy-day\"":
                iconImg.setImage(PARTLY_CLOUDY_DAY);
                text = "Alice: A little cloudy right now!";
                break;
            case "\"partly-cloudy-night\"":
                iconImg.setImage(PARTLY_CLOUDY_NIGHT);
                text = "Alice: A cloudy night, can you see the moon?";
                break;
            default:
                iconImg.setImage(UNKNOWN);
                text = "Alice: I don't seem to have any data! Sorry!";
                break;
        }
        artInt.setText(text);
    }
}
