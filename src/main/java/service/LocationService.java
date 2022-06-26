package service;

import com.google.gson.Gson;
import model.Location;
import model.LocationModel;
import repository.LocationRepository;

import java.io.IOException;

public class LocationService {

    private LocationRepository locationRepository;

    public LocationService (LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    public void getLocationData(String nameOfCity) throws IOException {

        HttpService httpService = new HttpService();
        String responseString = httpService.requestAPI(nameOfCity);

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
