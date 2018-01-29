package org.firstinspires.ftc.team8190;

import com.qualcomm.robotcore.util.Range;

/**
 * Created by Mason on 1/25/2018.
 */

public class Gamepad {
    HWholoX robot = new HWholoX();

    public Gamepad(){

    }

    public double stickRead (java.lang.String stick,java.lang.String value, double min, double max){
        if (stick.equals("right")  || stick.equals("Right") ){
            if (value.equals("x") || value.equals("X")){
                return Range.clip(robot.gamepad1.right_stick_x, min, max);
            }
            else if (value.equals("y" )|| value.equals("Y")){
                return Range.clip(robot.gamepad1.right_stick_y, min, max);
            }
            else{
                return 0;
            }
        }
        else if (stick.equals("left") || stick.equals("Left")) {
            if (value.equals("x") || value.equals("X") ){
                return Range.clip(robot.gamepad1.left_stick_x, min, max);
            }
            else if (value.equals("y") || value.equals("Y")){
                return Range.clip(robot.gamepad1.left_stick_y, min, max);
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }

    public double getStickAngle(java.lang.String stick) {
        return (Math.atan2(stickRead(stick, "x", -1, 1), stickRead(stick, "y", -1, 1)) * (180 / Math.PI));
    }

    public double getAngle(double x, double y){
        return (Math.atan2(x, y) * (180 / Math.PI));
    }

    public double triggerRead (java.lang.String trigger, double min, double max){
        if ((trigger == "left" )|| (trigger == "Left")){
            return Range.scale(robot.gamepad1.left_trigger, 0, 127, min, max);
        }
        if ((trigger == "right" )|| trigger == "Right"){
            return Range.scale(robot.gamepad1.right_trigger, 0, 127, min, max);
        }
        else{
            return 0;
        }
    }

    public double triggerReadBoth(double min, double max){
        return Range.scale((triggerRead("left", 0, 1) + triggerRead("right", 0, 1)) , 0 , 2, -1, 1);
    }
}
