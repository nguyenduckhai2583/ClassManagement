package com.example.ui;

import java.io.Serializable;

public class student_info implements Serializable {
    String face;
    String name;
    String phonenum;
    String mssv;
    String email;

    public student_info() {
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public student_info(String face, String name, String phonenum, String mssv, String email) {
        this.face = face;
        this.name = name;
        this.phonenum = phonenum;
        this.mssv = mssv;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
