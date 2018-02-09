package org.firstinspires.ftc.team8190.HoloX2;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Mason on 2/3/2018.
 */

public class HWmap {

    // get motors w/o hw class (for testing)//
    public DcMotor mtrFR = null;
    public DcMotor mtrFL = null;
    public DcMotor mtrBR = null;
    public DcMotor mtrBL = null;
    public DcMotor mtrLift = null;
    public DcMotor mtrLvl = null;
    public Servo srvLe = null;
    public Servo srvR = null;
    public Servo srvL = null;

    HardwareMap hardwareMap = null;
    public HWmap(){}
    // Code to run ONCE when the driver hits INIT
    public void init(HardwareMap ahwmap) {
        // get motors w/o hw class (for testing)//
        hardwareMap = ahwmap;
        mtrFR = hardwareMap.dcMotor.get("mtrFR");
        mtrFL = hardwareMap.dcMotor.get("mtrFL");
        mtrBR = hardwareMap.dcMotor.get("mtrBR");
        mtrBL = hardwareMap.dcMotor.get("mtrBL");
        mtrLift = hardwareMap.dcMotor.get("mtrLift");
        mtrLvl = harwareMap.dcMotor.get("mtrLvl");

        srvLe = hardwareMap.servo.get("level");
        srvL = hardwareMap.servo.get("leftClaw");
        srvR = hardwareMap.servo.get("rightClaw");
        srvL.setPosition(90);
        srvLe.setPosition(90);
        srvR.setPosition(90);
    }
}
