package model;

public class LocationModel {
    private Location location;

    public LocationModel (){

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "location=" + location +
                '}';
    }
}
