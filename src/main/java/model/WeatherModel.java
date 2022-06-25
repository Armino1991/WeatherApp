package model;

public class WeatherModel {
    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public WeatherModel() {
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "current=" + current +
                '}';
    }
}
