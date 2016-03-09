package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class City {

    public City(String name, String lat, String lon) {
        setCityName(name);
        setCityLat(lat);
        setCityLon(lon);
    }

    private final StringProperty cityName = new SimpleStringProperty();

    public final StringProperty cityNameProperty() {
        return this.cityName;
    }

    public final String getCityName() {
        return this.cityNameProperty().get();
    }

    public final void setCityName(final String cityName) {
        this.cityNameProperty().set(cityName);
    }

    // -----------------------------------------------------
    private final StringProperty cityLat = new SimpleStringProperty();

    public final StringProperty cityLatProperty() {
        return this.cityLat;
    }

    public final String getCityLat() {
        return this.cityLatProperty().get();
    }

    public final void setCityLat(final String cityLat) {
        this.cityLatProperty().set(cityLat);
    }

    // -----------------------------------------------------
    private final StringProperty cityLon = new SimpleStringProperty();

    public final StringProperty cityLonProperty() {
        return this.cityLon;
    }

    public final String getCityLon() {
        return this.cityLonProperty().get();
    }

    public final void setCityLon(final String cityLon) {
        this.cityLonProperty().set(cityLon);
    }

}
