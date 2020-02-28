package com.example.ui;

public class teacher_info {
    String face;
    String name;
    String phonenum;
    String email;
    String course;

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public teacher_info() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public teacher_info(String face, String name, String phonenum, String email, String course) {
        this.face = face;
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
        this.course = course;
    }
}
