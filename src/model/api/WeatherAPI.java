package model.api;

import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherAPI {

    // API KEY: 342c4be47e8f894c2e0f514f31d93dae
    ForecastIO fio;
    Map hourlyData = new HashMap();
    Map dailyData = new HashMap();

    public WeatherAPI(String APIKey, String Latitude, String Longitude) {
        fio = new ForecastIO(APIKey);
        fio.setUnits(ForecastIO.UNITS_UK);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast(Latitude, Longitude);
        System.out.println("Timezone: " + fio.getTimezone());
    }

    public Map hourlyReport(int hour) {
        FIOHourly hourly = new FIOHourly(fio);
        //In case there is no hourly data available
        if (hourly.hours() < 0) {
            System.out.println("No hourly data.");
        } else {
            String temp = formatDouble(hourly.getHour(hour).temperature());
            String tempFeel = formatDouble(hourly.getHour(hour).apparentTemperature());
            String windspeed = formatDouble(hourly.getHour(hour).windSpeed());
            String humidity = formatPercentage(hourly.getHour(hour).humidity());
            String precip = formatPercentage(hourly.getHour(hour).precipProbability());
            String time = formatTime(hourly.getHour(hour).time());

            hourlyData.put("Temp", temp); // Temperature
            hourlyData.put("TempFeel", tempFeel); // Feel Temperature
            hourlyData.put("Humidity", humidity); // Humidity
            hourlyData.put("WindSpeed", windspeed); // Wind Speed
            hourlyData.put("Precip", precip); // Precipitation
            hourlyData.put("TimeStamp", time);// TimeStamp
            hourlyData.put("Icon", hourly.getHour(hour).icon());
        }
        return hourlyData;
    }
    
    private String formatDouble(double data) { 
        return String.format("%.0f", data);
    }
    
    private String formatPercentage(double data) {
        return String.format("%2d", (int) (data * 100));
    }
    
    private String formatTime(String data) {
        Date date = null;
        try {
            date = new SimpleDateFormat("d-MM-yyyy HH:mm:ss").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String oldStr = new SimpleDateFormat("EEEE HH:mma").format(date);
        String str = oldStr.replace("AM", "am").replace("PM","pm");
        return str;
    }

//    public Map dailyReport(int day) {
//        FIODaily daily = new FIODaily(fio);
//        //In case there is no daily data available
//        if (daily.days() < 0) {
//            System.out.println("No daily data.");
//        } else {
//            System.out.println("Data for day " + day);
//            Double temp1 = daily.getDay(day).temperatureMax();
//            System.out.println(temp1);
//            Double temp2 = daily.getDay(day).temperatureMin();
//            System.out.println(temp2);
//            Double result = temp1 + temp2;
//            dailyData.put("Temp", result); // Temperature
//            dailyData.put("Icon", daily.getDay(day).icon()); // Icon
//        }
//        return dailyData;
//    }

}
