package org.firstinspires.ftc.team8190.Sumo;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

public class RobotMap {

    private DcMotor mtrL, mtrR;
    private ColorSensor color;
    private OpticalDistanceSensor ods;
    private HardwareMap hwMap;

    public void init(HardwareMap aHwMap){
        hwMap = aHwMap;
        mtrL = hwMap.dcMotor.get("mtrL");
        mtrL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mtrL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mtrR = hwMap.dcMotor.get("mtrR");
        mtrR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mtrR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        color = hwMap.colorSensor.get("color");
        color.enableLed(true);
        ods = hwMap.opticalDistanceSensor.get("ods");
    }

    public void move(float r, float l){
        mtrR.setPower(r);
        mtrL.setPower(l);
    }

    public void stop(){
        mtrR.setPower(0);
        mtrL.setPower(0);
    }

    public int getAlpha(){
        return color.alpha();
    }

    public double getDistance(){
        return ods.getLightDetected();
    }

    public int[] getColor(){
        return new int[]{color.red(), color.green(), color.blue()};
    }
}
