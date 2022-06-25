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

    private static final String BASE_URL = "http://api.weatherstack.com";
    private static final String ACCESS_KEY = "22f972b8e72a81d190e4092c7dd6c1bd";
    private CurrentRepository currentRepository;

    public WeatherService (CurrentRepository currentRepository){
        this.currentRepository = currentRepository;
    }

    public WeatherService (){

    }

    public void getWeatherData() throws IOException {
        System.out.println("----PLEASE GIVE THE NAME OF THE CITY TO GET WEATHER DATA :----");
        Scanner scanner = new Scanner(System.in);
        String nameOfCity = scanner.next();
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/current").newBuilder();
        urlBuilder.addQueryParameter("access_key", ACCESS_KEY);
        urlBuilder.addQueryParameter("query",nameOfCity);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();

        System.out.println(responseString);

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

        currentRepository.saveCurrent(current);
    }

    public void getWeatherNow() throws IOException {
        System.out.println("----PLEASE GIVE THE NAME OF THE CITY TO GET WEATHER DATA :----");
        Scanner scanner = new Scanner(System.in);
        String nameOfCity = scanner.next();
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/current").newBuilder();
        urlBuilder.addQueryParameter("access_key", ACCESS_KEY);
        urlBuilder.addQueryParameter("query",nameOfCity);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();

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
