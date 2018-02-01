package org.firstinspires.ftc.team8190.HoloX;

/**
 * Created by Mason on 1/27/2018.
 */

public class Team8190 {
    HWholoX robot = new HWholoX();

    public Team8190(){}

    public void liftPower(double power){
        robot.mtrLift.setPower(power/100);
    }

    public void stopLift(){
        robot.mtrLift.setPower(0);
    }
    
    public boolean isRed(double thresh){
        if (sensorColor.red() > thresh){
            return true;
        }
        else {
            return false;
        }
    }

    public void moveServo(java.lang.String identifier, double position){
        if (identifier == "Left" || identifier == "left"){
            robot.leftClaw.setPosition(position);
        }
        else if (identifier == "Right" || identifier == "right"){
            robot.rightClaw.setPosition(position);
        }
        else if (identifier == "Level" || identifier == "level"){
            robot.level.setPosition(position);
        }
        else if (identifier == "arm" || identifier == "Arm"){
            robot.arm.setPosition(position);
        }
        else {
            return;
        }
    }
}
