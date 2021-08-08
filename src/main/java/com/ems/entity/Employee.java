package com.ems.entity;

import com.ems.dao.DepartmentDAO;
import com.ems.validator.DOBConstraint;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name="employee")
@SequenceGenerator(name="seq",initialValue = 2000000000)
public class Employee {

    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq")
    private long employee_id;

    @Column(name="first_name")
    @NotBlank
    private String firstName;

    @Column(name="last_name")
    @NotBlank
    private String lastName;

    @Column(name="dob")
    @Past(message="The date of birth must be in past!")
    @DOBConstraint
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    @Column(name="email")
    @NotBlank
    private String email;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToOne(cascade ={CascadeType.ALL,CascadeType.REMOVE})
    @JoinColumn(name="userid")
    private LoginMaster loginMaster;

    @Transient
    private int department_id;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setDept(Department department) {
        this.department = department;
    }

    public void setLoginMaster(LoginMaster loginMaster) {this.loginMaster = loginMaster;}

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", loginMaster=" + loginMaster +
                ", department_id=" + department_id +
                '}';
    }
}
