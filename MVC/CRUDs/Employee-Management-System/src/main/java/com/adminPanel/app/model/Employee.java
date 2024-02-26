package com.adminPanel.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name="name")
    private String name;

    @Column(name="department")
    private String department;

    @Column(name="email")
    private String email;

    @Column(name="position")
    private String position;

    @Column(name="salary")
    private double salary;
}
