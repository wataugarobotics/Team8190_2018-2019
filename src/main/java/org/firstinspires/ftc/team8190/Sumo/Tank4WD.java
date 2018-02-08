//4WD Tank Code
/* Created by Ben, FTC 8190 Improv at its finest
 * version 1.0 Feb 3, 2017
 */

package org.firstinspires.ftc.team8190.Sumo;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "8190: Tank4WD", group = "8190")
//@Disabled
public class Tank4WD extends OpMode {
    HWtank8190 robot = new HWtank8190();

    @Override
    public void init()
    {
        robot.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop()
    {
    }

    // Code to run ONCE when the driver hits PLAY
    @Override
    public void start()
    {
        //set color sensor to active mode
        sensor.colorlight(true);
    }

    @Override
    public void loop()
    {
        // Stick Y-Axes Control Respective Sides

        //set motor power to clipped range of gamepad input
        robot.mtrFL.setPower(Range.clip((gamepad1.left_stick_y), -1, 1));
        robot.mtrBL.setPower(Range.clip((gamepad1.left_stick_y), -1, 1));
        robot.mtrFR.setPower(Range.clip((-gamepad1.right_stick_y), -1, 1));
        robot.mtrBR.setPower(Range.clip((-gamepad1.right_stick_y), -1, 1));

        //show sensor status via telemetry
        telemetry.addData("Color: ", sensor.getcolor() & 0xFF);
        telemetry.addData("Distance: ", sensor.getdistance());
    }

    @Override
    public void stop()
    {
    }
}