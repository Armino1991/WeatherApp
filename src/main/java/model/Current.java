package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "current")
public class Current {

    @Id
    private int id;

    private int temperature;

    private int wind_speed;

    private int wind_degree;

    private String wind_dir;

    private Double pressure;

    private int humidity;

    private int feelslike;

    private int visibility;

    private String city;

    private Date date;

    public Current() {
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(int wind_degree) {
        this.wind_degree = wind_degree;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public int getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(int feelslike) {
        this.feelslike = feelslike;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Current{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", wind_speed=" + wind_speed +
                ", wind_degree=" + wind_degree +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", feelslike=" + feelslike +
                ", visibility=" + visibility +
                ", city='" + city + '\'' +
                ", date=" + date +
                '}';
    }
}
