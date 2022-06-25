package service;

import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import model.Location;
import model.LocationModel;
import repository.LocationRepository;

import java.io.IOException;
import java.util.Scanner;

public class LocationService {

    private static final String BASE_URL = "http://api.weatherstack.com";
    private static final String ACCESS_KEY = "22f972b8e72a81d190e4092c7dd6c1bd";
    private LocationRepository locationRepository;

    public LocationService (LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public void getLocationData() throws IOException {
        System.out.println("----PLEASE GIVE THE NAME OF THE CITY TO BE ADDED :----");
        Scanner scanner = new Scanner(System.in);
        String nameOfCity = scanner.next();
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/current").newBuilder();
        urlBuilder.addQueryParameter("access_key", ACCESS_KEY);
        urlBuilder.addQueryParameter("query", nameOfCity);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();

        System.out.println(responseString);

        Gson gson = new Gson();
        LocationModel locationModel =
                gson.fromJson(responseString, LocationModel.class);

        Location location = new Location();
        location.setId(locationModel.getLocation().getId());
        location.setName(locationModel.getLocation().getName());
        location.setCountry(locationModel.getLocation().getCountry());
        location.setLat(locationModel.getLocation().getLat());
        location.setLon(locationModel.getLocation().getLon());
        location.setLocaltime(locationModel.getLocation().getLocaltime());
        locationRepository.saveLocation(location);
    }
}
