package com.example.database;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="teacher")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;

    private String jobTitle;


   @OneToMany(mappedBy = "teacher",
        cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                   CascadeType.DETACH,CascadeType.REFRESH}
    )
    private List<Student> students ;

    /**
     * Method : two way link between the teacher and student
     * @param tempStudent
     */

    public void add(Student tempStudent){

        if(students == null){
            students = new ArrayList<>();
        }

        students.add(tempStudent);
        tempStudent.setTeacher(this);

    }

}