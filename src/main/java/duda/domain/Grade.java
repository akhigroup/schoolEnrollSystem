package duda.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grades")
public class Grade {
    private @Id @GeneratedValue Long id;
    private String courseName;
    private int grade;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pupil pupil;

    Grade() { }

   public Grade(String courseName, int grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }
}
