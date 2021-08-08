package com.ems.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;



@Entity
@Table(name = "login_master")
public class LoginMaster {
    @Id
    @Column(name="userid")
    private Long userid;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;


    public LoginMaster(Long userid) {
        this.userid = userid;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode("employee");
        this.role = "ROLE_EMPLOYEE";
    }

    public LoginMaster(Long userid, String role) {
        this.userid = userid;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode("employee");
        this.role = role;
    }


    public LoginMaster() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode("employee");
        this.role = "ROLE_EMPLOYEE";

    }

    public LoginMaster(long l, String pass, String role) {
        this.userid = l;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(pass);
        this.role = role;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginMaster{" +
                "userid=" + userid +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
