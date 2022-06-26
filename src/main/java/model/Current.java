package model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "current")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Current {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "wind_speed")
    private int wind_speed;

    @Column(name = "wind_degree")
    private int wind_degree;

    @Column(name = "wind_dir")
    private String wind_dir;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "feelslike")
    private int feelslike;

    @Column(name = "visibility")
    private int visibility;

    @Column(name = "city")
    private String city;

    @Column(name = "date")
    private Date date;

    @Override
    public String toString() {
        return "\nWeather data: \n" +
                "id=" + id +
                "\ntemperature= " + temperature +
                "\nwind_speed= " + wind_speed +
                "\nwind_degree= " + wind_degree +
                "\nwind_dir= '" + wind_dir + '\'' +
                "\npressure= " + pressure +
                "\nhumidity= " + humidity +
                "\nfeelslike= " + feelslike +
                "\nvisibility= " + visibility +
                "\ncity= '" + city + '\'' +
                "\ndate= " + date+"\n"
                ;
    }
}
