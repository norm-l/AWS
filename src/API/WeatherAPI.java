package API;

import com.github.dvdme.ForecastIOLib.FIOAlerts;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherAPI {

    // API KEY: 342c4be47e8f894c2e0f514f31d93dae
    ForecastIO fio;
    Map hourlyData = new HashMap();
    Map dailyData = new HashMap();

    public WeatherAPI(String APIKey) {
        fio = new ForecastIO(APIKey);
        fio.setUnits(ForecastIO.UNITS_UK);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("51.5072", "0.1275");
        System.out.println("Timezone: " + fio.getTimezone());
    }

    public Map hourlyReport(int hour) {
        FIOHourly hourly = new FIOHourly(fio);
        //In case there is no hourly data available
        if (hourly.hours() < 0) {
            System.out.println("No hourly data.");
        } else {
            hourlyData.put("Temp", hourly.getHour(hour).temperature()); // Temperature
            hourlyData.put("TempFeel", hourly.getHour(hour).apparentTemperature()); // Feel Temperature
            hourlyData.put("Humidity", hourly.getHour(hour).humidity()); // Humidity
            hourlyData.put("WindSpeed", hourly.getHour(hour).windSpeed()); // Wind Speed
            hourlyData.put("Precip", hourly.getHour(hour).precipProbability()); // Precipitation
            hourlyData.put("TimeStamp", hourly.getHour(hour).time());// TimeStamp
            hourlyData.put("Summary", hourly.getHour(hour).summary()); // Summary
            hourlyData.put("Icon", hourly.getHour(hour).icon());
        }
        return hourlyData;
    }

    public Map dailyReport(int day) {
        FIODaily daily = new FIODaily(fio);
        //In case there is no daily data available
        if (daily.days() < 0) {
            System.out.println("No daily data.");
        } else {
            System.out.println("Data for day " + day);
            Double temp1 = daily.getDay(day).temperatureMax();
            System.out.println(temp1);
            Double temp2 = daily.getDay(day).temperatureMin();
            System.out.println(temp2);
            Double result = temp1 + temp2;
            dailyData.put("Temp", result); // Temperature
            dailyData.put("Icon", daily.getDay(day).icon()); // Icon
        }
        return dailyData;
    }

}
