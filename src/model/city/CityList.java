package model.city;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CityList {

    private final ObservableList<City> cityList = FXCollections.observableArrayList(city
            -> new Observable[]{
                city.cityNameProperty(),
                city.cityLonProperty(),
                city.cityLatProperty()});

    public ObservableList<City> getCityList() {
        return cityList;
    }

    public void loadCities() {
        ObservableList<City> data = FXCollections.observableArrayList();

        City London = new City("London", "51.5072", "0.1275");
        data.add(London);

        City Paris = new City("Paris", "48.8567", "2.3508"); // City Name, Latitude, Longitude
        data.add(Paris); // Add to data

        City Warsaw = new City("Warsaw", "52.2333", "21.0167"); // City Name, Latitude, Longitude
        data.add(Warsaw); // Add to data

        City Dublin = new City("Dublin", "53.3478", "6.2597");
        data.add(Dublin);

        City Amsterdam = new City("Amsterdam", "52.3667", "4.9000"); // City Name, Latitude, Longitude
        data.add(Amsterdam); // Add to data

        City Glasgow = new City("Glasgow", "55.8580", "4.2590"); // City Name, Latitude, Longitude
        data.add(Glasgow); // Add to data

        City Manchester = new City("Manchester", "53.4667", "2.2333"); // City Name, Latitude, Longitude
        data.add(Manchester); // Add to data

        City Brussels = new City("Brussels", "50.8500", "4.3500"); // City Name, Latitude, Longitude
        data.add(Brussels); // Add to data

        City Frankfurt = new City("Frankfurt", "50.1167", "8.6833"); // City Name, Latitude, Longitude
        data.add(Frankfurt); // Add to data

        City Hamburg = new City("Hamburg", "53.5653", "10.0014"); // City Name, Latitude, Longitude
        data.add(Hamburg); // Add to data

        City Berlin = new City("Berlin", "52.5167", "13.3833"); // City Name, Latitude, Longitude
        data.add(Berlin); // Add to data

        City Prague = new City("Prague", "50.0833", "14.4167"); // City Name, Latitude, Longitude
        data.add(Prague); // Add to data

        City Munich = new City("Munich", "48.1333", "11.5667"); // City Name, Latitude, Longitude
        data.add(Munich); // Add to data

        City Vienna = new City("Vienna", "48.2000", "16.3667"); // City Name, Latitude, Longitude
        data.add(Vienna); // Add to data

        City Budapest = new City("Budapest", "47.4925", "19.0514"); // City Name, Latitude, Longitude
        data.add(Budapest); // Add to data

        City Vilnius = new City("Vilnius", "54.6833", "25.2833"); // City Name, Latitude, Longitude
        data.add(Vilnius); // Add to data

        cityList.setAll(data);
    }
}
