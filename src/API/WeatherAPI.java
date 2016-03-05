package API;

import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;

public class WeatherAPI {

    // API KEY: 342c4be47e8f894c2e0f514f31d93dae
    ForecastIO fio;

    public WeatherAPI(String APIKey) {
        fio = new ForecastIO(APIKey);
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("51.5072", "0.1275");
        System.out.println("Latitude: " + fio.getLatitude());
        System.out.println("Longitude: " + fio.getLongitude());
        System.out.println("Timezone: " + fio.getTimezone());
    }

    public void HourlyReport() {
        FIOHourly hourly = new FIOHourly(fio);
        //In case there is no hourly data available
        if (hourly.hours() < 0) {
            System.out.println("No hourly data.");
        } else {
            System.out.println("\nHourly:\n");
        }
        //Print hourly data
        for (int i = 0; i < hourly.hours(); i++) {
            String[] h = hourly.getHour(i).getFieldsArray();
            System.out.println("Hour #" + (i + 1));
            for (String h1 : h) {
                System.out.println(h1 + ": " + hourly.getHour(i).getByKey(h1));
            }
            System.out.println("\n");
        }
    }

}
