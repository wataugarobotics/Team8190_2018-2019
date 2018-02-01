package org.firstinspires.ftc.team8190.HoloX;

import java.util.Calendar;

public class Time{
    Calendar time;
    private float startTime;
    private int var;
    public Time(){

    }


    public void waitMilliseconds(int waitTime){
        var = 0;
        startTime = time.getTimeInMillis();
        while((startTime + waitTime) < time.getTimeInMillis()){
            var = var + 1;
        }

    }


}
