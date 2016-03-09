package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.city.City;
import model.city.CityList;

public class SettingsController implements Initializable {

    @FXML
    private ListView<City> cityView;
    
    private CityList cityList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CityList model = new CityList();
        initData(model);

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
