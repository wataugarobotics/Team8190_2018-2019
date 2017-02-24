package org.firstinspires.ftc.team8190;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

// Hardware config for 8190

public class HWholoplus8190
{
    // Public OpMode members
    public DcMotor  mtrF  = null;
    public DcMotor  mtrR  = null;
    public DcMotor  mtrL  = null;
    public DcMotor  mtrB  = null;
    // Local OpMode members
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    // Constructor
    public HWholoplus8190()
    {
    }

    // Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap)
    {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        mtrL = hwMap.dcMotor.get("mtrL");
        mtrR = hwMap.dcMotor.get("mtrR");
        mtrF = hwMap.dcMotor.get("mtrF");
        mtrB = hwMap.dcMotor.get("mtrB");

        // Set all motors to run WITHOUT (or USING) encoders
        mtrL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Set all motors to zero power
        mtrL.setPower(0);
        mtrR.setPower(0);
        mtrF.setPower(0);
        mtrB.setPower(0);

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



