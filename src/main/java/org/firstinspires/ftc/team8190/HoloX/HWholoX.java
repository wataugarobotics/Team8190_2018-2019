package org.firstinspires.ftc.team8190.HoloX;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


// Hardware config for HoloX Drive
public class HWholoX
{
    HoloXTeleOp8190 holoX = new HoloXTeleOp8190();
    // Public OpMode members
    public DcMotor mtrFR = null;
    public DcMotor mtrFL = null;
    public DcMotor mtrBR = null;
    public DcMotor mtrBL = null;
    public DcMotor mtrLift = null;
    public Servo rightClaw = null;
    public Servo leftClaw = null;
    public Servo level = null;
    public Servo arm = null;
    // Local OpMode members
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();
    ColorSensor sensorColor;

    // Constructor
    public HWholoX() {

    }

    // Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap) {

        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        mtrFR = hwMap.dcMotor.get("mtrFR");
        mtrFL = hwMap.dcMotor.get("mtrFL");
        mtrBR = hwMap.dcMotor.get("mtrBR");
        mtrBL = hwMap.dcMotor.get("mtrBL");
        mtrLift = hwMap.dcMotor.get("mtrLift");

        // Set all motors to run WITHOUT (or USING) encoders
        mtrFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Set all motors to zero power
        mtrFL.setPower(0);
        mtrFR.setPower(0);
        mtrBL.setPower(0);
        mtrBR.setPower(0);
        mtrLift.setPower(0);
        // Define and initialize ALL installed servos.
        rightClaw = hwMap.servo.get("right_claw");
        leftClaw = hwMap.servo.get("left_claw");
        level = hwMap.servo.get("level");
        arm = hwMap.servo.get("arm");
        rightClaw.setPosition(holoX.servoStartPos("right"));
        leftClaw.setPosition(holoX.servoStartPos("left"));
        level.setPosition(holoX.servoStartPos("level"));
        arm.setPosition(holoX.servoStartPos("arm"));
    }

    public boolean isRed(double thresh){
        if (sensorColor.red() > thresh){
            return true;
        }
        else {
            return false;
        }
    }

    public void waitForTick(long periodMs) {

        /* waitForTick implements a periodic delay. However, this acts like a metronome with a regular
         * periodic tick.  This is used to compensate for varying processing times for each cycle.
         * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
         *
         * @param periodMs  Length of wait cycle in mSec.
         */
        long remaining = periodMs - (long) period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
