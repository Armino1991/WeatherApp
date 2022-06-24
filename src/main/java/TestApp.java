import model.Current;
import model.Location;
import repository.CurrentRepository;
import repository.LocationRepository;
import service.LocationService;
import service.WeatherService;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) throws IOException {
        TestApp testApp = new TestApp();
        testApp.showMenu();
    }
    public void showMenu() throws IOException {
        System.out.println("1 : Add a location\n2 : Display all locations\n3 : Get weather from location");
        Scanner scanner = new Scanner(System.in);
        Integer numberPressed = scanner.nextInt();
        switch (numberPressed){
            case 1:
                addLocation();
                break;
            case 2:
                displayAllLocations();
                break;
            case 3:
                getWeatherFromLocation();
                break;
            default:
                System.out.println("\nWrong choose !!!");
                break;
        }
    }

    public void addLocation() throws IOException {
        LocationRepository locationRepository = new LocationRepository();
        LocationService locationService = new LocationService(locationRepository);
        locationService.getLocationData();

        System.out.println("----LOCATION ADDED SUCCESSFULLY !----");

        CurrentRepository currentRepository = new CurrentRepository();
        WeatherService weatherService = new WeatherService(currentRepository);
        weatherService.getWeatherData();

        System.out.println("----WEATHER DATA ADDED SUCCESSFULLY !----");

        System.out.println("\n");

        System.out.println("----MAIN MENU----");

        showMenu();
    }

    public void displayAllLocations() throws IOException {
        LocationRepository locationRepository = new LocationRepository();
        List<Location> locations =locationRepository.getLocations();
        System.out.println("----LOCATIONS ARE LISTED AS BELOW :----");
        System.out.println(locations);

        System.out.println("\n");

        System.out.println("----MAIN MENU----");

        showMenu();
    }

    public void getWeatherFromLocation() throws IOException {

        CurrentRepository currentRepository = new CurrentRepository();
        Current current =currentRepository.getCurrentByLocation();
        System.out.println("----WEATHER DATA FOR GIVEN LOCATION ARE AS BELOW :----");
        System.out.println(current);

        System.out.println("\n");

        System.out.println("----MAIN MENU----");

        showMenu();

    }

}
