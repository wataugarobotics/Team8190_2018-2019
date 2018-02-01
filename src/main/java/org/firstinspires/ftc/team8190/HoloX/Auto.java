package org.firstinspires.ftc.team8190.HoloX;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Autonomous: First Draft", group = "Autonomous")
public class Auto extends LinearOpMode{

    // initialize the robot
    HWholoX robot = new HWholoX();
    HoloX holo = new HoloX();
    Time time = new Time();
    Vuforia view = new Vuforia();
    Team8190 team = new Team8190();

    private int colorThresh = 10;
    private int speed = 100;
    private int num = 0;
    private int mark = 0;
    private double clawClosedPosition = 0;
    private double clawOpenPosition = 90;
    private double armUpPosition = 90;
    private double armDownPosition = 0;

    @Override
    public void runOpMode(){
        while (view.check() == 0){
            num = num + 1;
        }
        mark = view.check();

        // grab block here
        team.moveServo("Left", clawClosedPosition);
        team.moveServo("Right", clawClosedPosition);

        // lower arm here
        team.moveServo("arm", armDownPosition);

        if (robot.isRed(colorThresh)){
            holo.move(0, speed);
            // change time value to increase or decrease distance
            time.waitMilliseconds(100);
            holo.stop();
            holo.move(180, speed);
            // change this one too
            time.waitMilliseconds(100);
            holo.stop();
            team.moveServo("arm", armUpPosition);
        }

        else{
            holo.move(180, speed);
            // same as before
            time.waitMilliseconds(100);
            holo.stop();
            holo.move(0, speed);
            // and again
            time.waitMilliseconds(100);
            team.moveServo("arm", armUpPosition);
        }
        holo.move(0, speed);
        // experiment with this one too, until we end up in front of the pictograph
        time.waitMilliseconds(100);
        holo.stop();
        holo.spin(.5);
        // again, experiment with this one
        time.waitMilliseconds(100);
        if (mark == 1){
            holo.move(270, speed);
        }
        else if (mark == 3){
            holo.move(90, speed);
        }
        else if (mark == 2){
            holo.stop();
        }
        else {
            return;
        }
        time.waitMilliseconds(100);
        holo.stop();
        team.liftPower(100);
        time.waitMilliseconds(100);
        team.stopLift();
        // release the block
        team.moveServo("Left", clawOpenPosition);
        team.moveServo("Right", clawOpenPosition);
        team.liftPower(-100);
        time.waitMilliseconds(100);
        team.stopLift();
        holo.move(180, speed);
        time.waitMilliseconds(100);
        holo.stop();
    }
}
