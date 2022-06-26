package service;

import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import model.Current;
import model.WeatherModel;
import repository.CurrentRepository;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class WeatherService {

    private CurrentRepository currentRepository;

    public WeatherService (CurrentRepository currentRepository){
        this.currentRepository = currentRepository;
    }

    public WeatherService (){

    }

    public void getWeatherData(String city) throws IOException {

      HttpService httpService = new HttpService();
      String responseString = httpService.requestAPI(city);

        Gson gson = new Gson();
        WeatherModel weatherModel =
                gson.fromJson(responseString, WeatherModel.class);

        Current current = new Current();
        current.setId(weatherModel.getCurrent().getId());
        current.setTemperature(weatherModel.getCurrent().getTemperature());
        current.setWind_speed(weatherModel.getCurrent().getWind_speed());
        current.setWind_dir(weatherModel.getCurrent().getWind_dir());
        current.setHumidity(weatherModel.getCurrent().getHumidity());
        current.setWind_degree(weatherModel.getCurrent().getWind_degree());
        current.setPressure(weatherModel.getCurrent().getPressure());
        current.setFeelslike(weatherModel.getCurrent().getFeelslike());
        current.setVisibility(weatherModel.getCurrent().getVisibility());
        current.setCity(city);
        current.setDate(Date.valueOf(LocalDate.now()));

        currentRepository.saveCurrent(current);
    }

    public void getWeatherNow(String nameOfCity) throws IOException {

        HttpService httpService = new HttpService();
        String responseString = httpService.requestAPI(nameOfCity);

        Gson gson = new Gson();
        WeatherModel weatherModel =
                gson.fromJson(responseString, WeatherModel.class);

        Current current = new Current();
        current.setId(weatherModel.getCurrent().getId());
        current.setTemperature(weatherModel.getCurrent().getTemperature());
        current.setWind_speed(weatherModel.getCurrent().getWind_speed());
        current.setWind_dir(weatherModel.getCurrent().getWind_dir());
        current.setHumidity(weatherModel.getCurrent().getHumidity());
        current.setWind_degree(weatherModel.getCurrent().getWind_degree());
        current.setPressure(weatherModel.getCurrent().getPressure());
        current.setFeelslike(weatherModel.getCurrent().getFeelslike());
        current.setVisibility(weatherModel.getCurrent().getVisibility());
        current.setCity(nameOfCity);
        current.setDate(Date.valueOf(LocalDate.now()));

        System.out.println(current.toString());
    }

}
