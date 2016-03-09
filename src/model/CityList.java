
package model;

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
        
        City Paris = new City("Paris", "0", "0"); // City Name, Latitude, Longitude
        data.add(Paris); // Add to data
        
        City Warsaw = new City("Warsaw", "0", "0");
        data.add(Warsaw);
        
        //.. and so on..
    }
}
