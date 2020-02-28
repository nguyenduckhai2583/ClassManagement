package com.example.ui;

public class daySchedule {
    String dayname;
    String morning_name_course_item;
    String morning_time_course_item;
    String afternoon_name_course_item;
    String afternoon_time_course_item;

    public daySchedule() {
    }

    public daySchedule(String dayname, String morning_name_course_item, String morning_time_course_item, String afternoon_name_course_item, String afternoon_time_course_item) {
        this.dayname = dayname;
        this.morning_name_course_item = morning_name_course_item;
        this.morning_time_course_item = morning_time_course_item;
        this.afternoon_name_course_item = afternoon_name_course_item;
        this.afternoon_time_course_item = afternoon_time_course_item;
    }

    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }

    public String getMorning_name_course_item() {
        return morning_name_course_item;
    }

    public void setMorning_name_course_item(String morning_name_course_item) {
        this.morning_name_course_item = morning_name_course_item;
    }

    public String getMorning_time_course_item() {
        return morning_time_course_item;
    }

    public void setMorning_time_course_item(String morning_time_course_item) {
        this.morning_time_course_item = morning_time_course_item;
    }

    public String getAfternoon_name_course_item() {
        return afternoon_name_course_item;
    }

    public void setAfternoon_name_course_item(String afternoon_name_course_item) {
        this.afternoon_name_course_item = afternoon_name_course_item;
    }

    public String getAfternoon_time_course_item() {
        return afternoon_time_course_item;
    }

    public void setAfternoon_time_course_item(String afternoon_time_course_item) {
        this.afternoon_time_course_item = afternoon_time_course_item;
    }
}
