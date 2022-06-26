package model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "local_time")
    private String localtime;

    @Override
    public String toString() {
        return "\nLocation \n" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\ncountry='" + country + '\'' +
                "\nlat=" + lat +
                "\nlon=" + lon +
                "\nlocaltime='" + localtime + '\''
                ;
    }
}
