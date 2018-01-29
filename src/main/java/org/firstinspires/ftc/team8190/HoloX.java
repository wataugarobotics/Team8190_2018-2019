package org.firstinspires.ftc.team8190;

public class HoloX{

    HWholoX robot = new HWholoX();
    Gamepad gamepad1 = new Gamepad();

    private double direction;

    public double position;

    public HoloX(){
  
    }

    public void move(double direction, double speed){
        robot.mtrBL.setPower(-(Math.cos(direction - 45) * (speed/100)));
        robot.mtrFR.setPower(Math.cos(direction - 45) * (speed/100));
        robot.mtrBR.setPower(-(Math.sin(direction - 45) * (speed/100)));
        robot.mtrFL.setPower(Math.sin(direction - 45) * (speed/100));
    }

    public void move(double x, double y, double speed){
        direction = gamepad1.getAngle(x, y);
        robot.mtrBL.setPower(-(Math.cos(direction - 45) * (speed/100)));
        robot.mtrFR.setPower(Math.cos(direction - 45) * (speed/100));
        robot.mtrBR.setPower(-(Math.sin(direction - 45) * (speed/100)));
        robot.mtrFL.setPower(Math.sin(direction - 45) * (speed/100));
    }

    public void stop(){
        robot.mtrFL.setPower(0);
        robot.mtrBL.setPower(0);
        robot.mtrFR.setPower(0);
        robot.mtrBR.setPower(0);
        robot.mtrLift.setPower(0);
    }

    public void moveLift(double speed) {
        robot.mtrLift.setPower(speed);
    }

    public void spin( double turnSpeed){
        robot.mtrFR.setPower(turnSpeed/100);
        robot.mtrFL.setPower(turnSpeed/100);
        robot.mtrBR.setPower(turnSpeed/100);
        robot.mtrBL.setPower(turnSpeed/100);

    }



  }

