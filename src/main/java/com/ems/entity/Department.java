package com.ems.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="department")
public class Department {

    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    @Column(name="department_nm",unique = true)
    @NotBlank
    private String department_name;

    public Department(int department_id) {
        this.department_id = department_id;
    }

    public Department()
    {

    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
