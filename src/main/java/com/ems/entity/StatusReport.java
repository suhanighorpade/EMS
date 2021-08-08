package com.ems.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="statusreport")
public class StatusReport {

    @Id
    @Column(name = "statusrptid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statusrptid;

    @Column(name = "comments")
    @NotBlank
    private String comments;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "createdate")
    @NotNull
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "complianceid")
    private Regulation regulation;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @Transient
    private int department_id;

    @Transient
    private long employee_id;

    @Transient
    private int regulation_id;

    @Transient
    private boolean addComment = true;

    public long getStatusrptid() {
        return statusrptid;
    }

    public void setStatusrptid(long statusrptid) {
        this.statusrptid = statusrptid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Regulation getRegulation() {
        return regulation;
    }

    public void setRegulation(Regulation regulation) {
        this.regulation = regulation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public int getRegulation_id() {
        return regulation_id;
    }

    public void setRegulation_id(int regulation_id) {
        this.regulation_id = regulation_id;
    }

    public boolean getAddComment() {
        return addComment;
    }

    public void setAddComment(boolean addComment) {
        this.addComment = addComment;
    }

    public StatusReport() {
    }

    @Override
    public String toString() {
        return "StatusReport{" +
                "statusrptid=" + statusrptid +
                ", comments='" + comments + '\'' +
                ", createDate=" + createDate +
                ", regulation=" + regulation +
                ", employee=" + employee +
                ", department=" + department +
                ", department_id=" + department_id +
                ", employee_id=" + employee_id +
                ", regulation_id=" + regulation_id +
                ", addComment=" + addComment +
                '}';
    }
}
