
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
        
        //City Warsaw = new City("Warsaw", "0", "0");
        //data.add(Warsaw);
        
        //.. and so on..
        
        cityList.setAll(data);
    }
}
