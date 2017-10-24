package org.firstinspires.ftc.team8190.Sumo;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Objects;

// Hardware config for 8190

public class HWtank8190
{
    // Public OpMode members
    public static DcMotor mtrFL = null;
    public static DcMotor mtrFR = null;
    public static DcMotor mtrBL = null;
    public static DcMotor mtrBR = null;
    public static OpticalDistanceSensor ODS;
    private static I2cDevice color;
    public static I2cDeviceSynch colorReader;

    // Local OpMode members
    private HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    // Constructor
    public HWtank8190()
    {
    }

    // Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap)
    {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        mtrFL = hwMap.dcMotor.get("mtrFL");
        mtrFR = hwMap.dcMotor.get("mtrFR");
        mtrBL = hwMap.dcMotor.get("mtrBL");
        mtrBR = hwMap.dcMotor.get("mtrBR");
        ODS = hwMap.opticalDistanceSensor.get("ods");
        color = hwMap.i2cDevice.get("cc");
        colorReader = new I2cDeviceSynchImpl(color, I2cAddr.create8bit(0x3c), false);
        colorReader.engage();

        // Set all motors to run WITHOUT (or USING) encoders
        mtrFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Set all motors to zero power
        mtrFL.setPower(0);
        mtrFR.setPower(0);
        mtrBL.setPower(0);
        mtrBR.setPower(0);

        /* // Define and initialize ALL installed servos.
        rightClaw = hwMap.servo.get("right_hand");
        rightClaw.setPosition(MID_SERVO); */
    }

    public void waitForTick(long periodMs)
    {
        /* waitForTick implements a periodic delay. However, this acts like a metronome with a regular
         * periodic tick.  This is used to compensate for varying processing times for each cycle.
         * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
         *
         * @param periodMs  Length of wait cycle in mSec.
         */

        long  remaining = periodMs - (long)period.milliseconds();
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

//Easy movement class
class move {
    private static void motorPower(double fr, double br, double fl, double bl) {
        HWtank8190.mtrFR.setPower(fr);
        HWtank8190.mtrBR.setPower(br);
        HWtank8190.mtrFL.setPower(-fl);
        HWtank8190.mtrBL.setPower(-bl);
    }
    public static void forward(double power) {
        motorPower(power, power, power, power);
    }
    public static void reverse(double power) {
        motorPower(-power, -power, -power, -power);
    }
    public static void right(double power) {
        motorPower(-power, -power, power, power);
    }
    public static void left(double power) {
        motorPower(power, power, -power, -power);
    }
    public static void stop() {
        motorPower(0,0,0,0);
    }
    public static void swerve(String forwardreverse, String leftright, double power) {
        if (Objects.equals(forwardreverse, "forward")) {
            if (Objects.equals(leftright, "left")) {
                HWtank8190.mtrFL.setPower(power);
                HWtank8190.mtrBL.setPower(power);
            }
            if (Objects.equals(leftright, "right")) {
                HWtank8190.mtrFR.setPower(power);
                HWtank8190.mtrBR.setPower(power);
            }
        }
        if (Objects.equals(forwardreverse, "reverse")) {
            if (Objects.equals(leftright, "left")) {
                HWtank8190.mtrFL.setPower(-power);
                HWtank8190.mtrBL.setPower(-power);
            }
            if (Objects.equals(leftright, "right")) {
                HWtank8190.mtrFR.setPower(-power);
                HWtank8190.mtrBR.setPower(-power);
            }
        }
    }
}

//Easy sensor class
class sensor {
    public static int getcolor() {
        return HWtank8190.colorReader.read(0x04, 1)[0]; //read 0x04 byte - color #
    }
    public static void colorlight(boolean on){
        if (on) {
            HWtank8190.colorReader.write8(3, 0); //write 0x03 byte - mode
        } else {
            HWtank8190.colorReader.write8(3, 1); //write 0x03 byte - mode
        }
    }
    public static double getdistance() {
        return Math.pow(HWtank8190.ODS.getRawLightDetected(), 0.5);
    }
}