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

        City London = new City("London", "51.5072", "0.1275"); // City Name, Latitude, Longitude
        data.add(London);  // Add to data

        City Paris = new City("Paris", "48.8567", "2.3508"); 
        data.add(Paris);

        City Warsaw = new City("Warsaw", "52.2333", "21.0167");
        data.add(Warsaw);

        City Dublin = new City("Dublin", "53.3478", "6.2597");
        data.add(Dublin);

        City Amsterdam = new City("Amsterdam", "52.3667", "4.9000");
        data.add(Amsterdam);

        City Glasgow = new City("Glasgow", "55.8580", "4.2590");
        data.add(Glasgow);

        City Manchester = new City("Manchester", "53.4667", "2.2333");
        data.add(Manchester);

        City Brussels = new City("Brussels", "50.8500", "4.3500");
        data.add(Brussels);

        City Frankfurt = new City("Frankfurt", "50.1167", "8.6833");
        data.add(Frankfurt);

        City Hamburg = new City("Hamburg", "53.5653", "10.0014");
        data.add(Hamburg);

        City Berlin = new City("Berlin", "52.5167", "13.3833");
        data.add(Berlin);

        City Prague = new City("Prague", "50.0833", "14.4167");
        data.add(Prague);

        City Munich = new City("Munich", "48.1333", "11.5667");
        data.add(Munich);

        City Vienna = new City("Vienna", "48.2000", "16.3667");
        data.add(Vienna);

        City Budapest = new City("Budapest", "47.4925", "19.0514");
        data.add(Budapest);

        City Vilnius = new City("Vilnius", "54.6833", "25.2833");
        data.add(Vilnius);

        cityList.setAll(data);
    }
}
