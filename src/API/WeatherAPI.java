package API;

import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class WeatherAPI {

    // API KEY: 342c4be47e8f894c2e0f514f31d93dae
    ForecastIO fio;
    Map hourlyData = new HashMap();

    public WeatherAPI(String APIKey) {
        fio = new ForecastIO(APIKey);
        fio.setUnits(ForecastIO.UNITS_UK);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("51.5072", "0.1275");
        System.out.println("Latitude: " + fio.getLatitude());
        System.out.println("Longitude: " + fio.getLongitude());
        System.out.println("Timezone: " + fio.getTimezone());
    }

    public Map HourlyReport(int hour) {
        FIOHourly hourly = new FIOHourly(fio);
        //In case there is no hourly data available
        if (hourly.hours() < 0) {
            System.out.println("No hourly data.");
        } else {
            hourlyData.put("Temp", hourly.getHour(hour).temperature()); // Temperature
            hourlyData.put("TempFeel", hourly.getHour(hour).apparentTemperature()); // Feel Temperature
            hourlyData.put("Humidity", hourly.getHour(hour).humidity()); // Humidity
            hourlyData.put("WindSpeed", hourly.getHour(hour).windSpeed()); // Wind Speed
            hourlyData.put("TimeStamp", hourly.getHour(hour).time());// TimeStamp
        }
        return hourlyData;
    }
}
