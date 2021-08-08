package com.ems.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name ="compliance")
public class Regulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="complianceid")
    private int id;

    @Column(name="rltype")
    private String RLType;

    @Column(name="details")
    @NotBlank
    private String details;

    @Column(name="createdate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate createdate;

    @ManyToOne()
    @JoinColumn(name="department_id")
    private Department department;

    @Transient
    private int dept_id;

    public String getRLType() {
        return RLType;
    }

    public void setRLType(String RLType) {
        this.RLType = RLType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Regulation{" +
                "id=" + id +
                ", RLType='" + RLType + '\'' +
                ", details='" + details + '\'' +
                ", createdate=" + createdate +
                ", department=" + department +
                ", dept_id=" + dept_id +
                '}';
    }
}
