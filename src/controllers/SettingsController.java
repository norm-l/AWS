package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.city.City;
import model.city.CityList;

public class SettingsController implements Initializable {

    @FXML
    private ListView<City> cityView;

    private CityList cityList;
    
    private String currCity;
    private String currLat;
    private String currLon;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CityList model = new CityList();
        initData(model);
        
        setCity("London", "51.5072", "0.1275");

        cityView.setCellFactory(lv -> new ListCell<City>() {
            @Override
            protected void updateItem(City city, boolean empty) {
                super.updateItem(city, empty);
                setText(empty ? null : city.getCityName());
            }
        });

        cityView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                City selected = cityView.getSelectionModel().getSelectedItem();
                System.out.println("clicked on " + cityView.getSelectionModel().getSelectedItem());
                setCity(selected.cityNameProperty().toString(),
                        selected.cityLatProperty().toString(),
                        selected.cityLonProperty().toString());
            }
        });

    }
    
    private void setCity(String city, String lat, String lon) {
        currCity = city;
        currLat = lat;
        currLon = lon;
    }
    
    public String getCity() {
        return currCity;
    }
    
    public String getLat() {
        return currLat;
    }
    
    public String getLon() {
        return currLon;
    }

    private void initData(CityList cityList) {
        if (this.cityList != null) {
            throw new IllegalStateException("Data has already been initialized");
        }
        cityList.loadCities();
        this.cityList = cityList;

        cityView.setItems(cityList.getCityList());
    }

}
