package com.example.database;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name="student")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String jobTitle;

    /**
     * We  did a relationship between 2 DB
     * Many student have one teacher
     */
    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                           CascadeType.DETACH,CascadeType.REFRESH}
              )

    @JoinColumn(name="teacher_id")
    private Teacher teacher ;



}