package duda.domain;

import java.util.List;
import java.util.Optional;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pupils")
public class Pupil {

    private @Id @GeneratedValue Long id;
    private double lat;
    private double lon;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "pupil_id")
    private @ElementCollection List<Grade> grades;

    @ManyToMany
    @JoinTable(name="friends",
            joinColumns=@JoinColumn(name="pupilId"),
            inverseJoinColumns=@JoinColumn(name="friendId")
    )
    private List<Pupil> friends;

    @ManyToMany
    @JoinTable(name="friends",
            joinColumns=@JoinColumn(name="friendId"),
            inverseJoinColumns=@JoinColumn(name="pupilId")
    )
    private List<Pupil> friendOf;

    @ManyToOne
    private Optional<School> school;

    Pupil() { }

    public Pupil (double lat, double lon, List<Grade> grades, Optional<School> school) {
        this.lat = lat;
        this.lon = lon;
        this.grades = grades;
        this.school = school;
    }

    public void addFriend(Pupil friend) {
     this.friends.add(friend);
     friend.friends.add(this);
    }

    public Pupil (double lat, double lon, List<Grade> grades) {
        this.lat = lat;
        this.lon = lon;
        this.grades = grades;
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

    public double getGPA() {
        return grades.stream().
                mapToInt(Grade::getGrade).
                average().
                orElse(Double.NaN);
    }

    public Optional<School> getSchool() {
        return school;
    }

    public List<Pupil> getFriends() {
        return friends;
    }
}
