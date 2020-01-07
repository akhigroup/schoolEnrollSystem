package duda.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "schools")
public class School {
    private @Id @GeneratedValue Long id;
    private double lat;
    private double lon;
    private int minimumGpa;
    private int maxNumberOfPupils;


    School() {}

    School(double lat, double lon, int minimumGpa, int maxNumberOfPupils) {
        this.lat = lat;
        this.lon = lon;
        this.minimumGpa = minimumGpa;
        this.maxNumberOfPupils = maxNumberOfPupils;

    }

    public Long getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public int getMinimumGpa() {
        return this.minimumGpa;
    }

    public int getMaxNumberOfPupils() {
        return maxNumberOfPupils;
    }
}



