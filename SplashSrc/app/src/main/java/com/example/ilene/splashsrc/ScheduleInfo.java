package com.example.ilene.splashsrc;

public class ScheduleInfo {
    String date, startTime, endTime, schedule;

    public ScheduleInfo(String date, String startTime, String endTime, String schedule){
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
        this.schedule=schedule;
    }

    public String getSchedule(){
        return schedule;
    }
}
