package com.springboot.goodbam.vo;

import org.springframework.stereotype.Component;

@Component("TempVO")
public class TempVO {
    private String userNum;
    private int raspID;
    private String temperature;
    private String humidity;
    private String date;
    private String time;

    public String getUserNum() { return userNum; }

    public void setUserNum(String userNum) { this.userNum = userNum; }

    public int getRaspID() { return raspID; }

    public void setRaspID(int raspID) { this.raspID = raspID; }

    public String getTemperature() { return temperature; }

    public void setTemperature(String temperature) { this.temperature = temperature; }

    public String getHumidity() { return humidity; }

    public void setHumidity(String humidity) { this.humidity = humidity; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }
}
