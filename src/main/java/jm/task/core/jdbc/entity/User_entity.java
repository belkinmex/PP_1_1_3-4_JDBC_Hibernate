package jm.task.core.jdbc.entity;

import jdk.jfr.DataAmount;

import javax.persistence.*;

@Entity
@Table (name = "users", schema = "testbase")
public class User_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private byte age;

}
