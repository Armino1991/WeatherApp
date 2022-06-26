import model.Current;
import model.Location;
import repository.CurrentRepository;
import repository.LocationRepository;
import service.LocationService;
import service.WeatherService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class TestApp {

    private static final int ADD_LOCATION=1;
    private static final int DISPLAY_ALL_LOCATIONS=2;
    private static final int GET_WEATHER=3;
    private static final int GET_WEATHER_NOW=4;
    private static final int EXIT=5;

    LocationRepository locationRepository = new LocationRepository();
    CurrentRepository currentRepository = new CurrentRepository();

    public static void main(String[] args) throws IOException {
        // Turn Hibernate logging off
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        TestApp testApp = new TestApp();
        printHeader();
        testApp.showMenu();
    }
    public void showMenu() throws IOException {

        System.out.println("1 : Add a location\n" +
                "2 : Display all locations\n" +
                "3 : Get weather from location\n" +
                "4 : Get weather now\n" +
                "5 : Close");
        System.out.print("\n Choose an action > ");
        Scanner scanner = new Scanner(System.in);
        Integer numberPressed = scanner.nextInt();
        switch (numberPressed){
            case ADD_LOCATION:
                addLocation();
                break;
            case DISPLAY_ALL_LOCATIONS:
                displayAllLocations();
                break;
            case GET_WEATHER:
                getWeatherFromLocation();
                break;
            case GET_WEATHER_NOW:
                getCurrentWeather();
                break;
            case EXIT:
                exit();
                break;
            default:
                System.out.print("\n------Wrong choose !----");
        }
    }

    private static void printHeader() {
        System.out.println("---------------------------------");
        System.out.println("-------------SDA DEMO------------");
        System.out.println("------Weather Station v.1.0-----");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------\n");
    }

    public void addLocation() throws IOException {

        System.out.println("----PLEASE GIVE THE NAME OF THE CITY TO BE ADDED :----");
        Scanner scanner = new Scanner(System.in);
        String nameOfCity = scanner.next();

        LocationService locationService = new LocationService(locationRepository);
        locationService.getLocationData(nameOfCity);

        System.out.println("----LOCATION ADDED SUCCESSFULLY !----");

        System.out.println("----PLEASE GIVE THE NAME OF THE CITY TO GET WEATHER DATA :----");
        Scanner scanner1 = new Scanner(System.in);
        String city = scanner1.next();

        WeatherService weatherService = new WeatherService(currentRepository);
        weatherService.getWeatherData(city);

        System.out.println("----WEATHER DATA ADDED SUCCESSFULLY !----");

        System.out.println("\n");

        System.out.println("----MAIN MENU----");

        showMenu();
    }

    public void displayAllLocations() throws IOException {

        List<Location> locations =locationRepository.getLocations();
        System.out.println("----LOCATIONS ARE LISTED AS BELOW :----");
        System.out.println(locations);

        System.out.println("\n");

        System.out.println("----MAIN MENU----");

        showMenu();
    }

    public void getWeatherFromLocation() throws IOException {

        System.out.println("----PLEASE GIVE THE LOCATION :----");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();

        System.out.println("----PLEASE GIVE THE DATE ON FORMAT yyyy-mm-dd :----");
        Scanner scanner1 = new Scanner(System.in);
        String date = scanner1.next();

        Current current =currentRepository.getCurrentByLocation(city, date);
        System.out.println("----WEATHER DATA FOR GIVEN LOCATION ARE AS BELOW :----");
        System.out.println(current);

        System.out.println("\n");

        System.out.println("----MAIN MENU----");

        showMenu();

    }

    public void getCurrentWeather() throws IOException {

        System.out.println("----PLEASE GIVE THE NAME OF THE CITY TO GET WEATHER DATA :----");
        Scanner scanner = new Scanner(System.in);
        String nameOfCity = scanner.next();
        WeatherService weatherService = new WeatherService();
        weatherService.getWeatherNow(nameOfCity);

        System.out.println("\n----MAIN MENU----");

        showMenu();
    }
    public void exit() throws IOException {

        System.exit(0);
    }

}
