//Holonomic Code
/**
 *
 * Created by Maddie, FTC Team 4962, The Rockettes
 * version 1.0 Aug 11, 2016
 *
 * modified by Duncan, FTC 5881, Tungsteel
 * version 1.1 Nov 27, 2016
 *
 * modified by Eden, FTC 8190 Improv at its finest
 * version 1.2 Jan 26, 2017
 *
 * modified by Ben, FTC 8190 Improv at its finest
 * version 1.3 Feb 3, 2017
 */

package org.firstinspires.ftc.team8190;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "8190: HoloPlus", group = "8190")
//@Disabled
public class HoloPlus extends OpMode {
    org.firstinspires.ftc.team8190.Hardware8190 robot = new Hardware8190();

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
    }

    @Override
    public void loop()
    {
        // left stick controls direction
        // right stick X controls rotation

        //set motor power to clipped range of gamepad w/ holo math
        robot.mtrF.setPower(Range.clip((-gamepad1.left_stick_x - gamepad1.right_stick_x), -1, 1));
        robot.mtrB.setPower(Range.clip((gamepad1.left_stick_x - gamepad1.right_stick_x), -1, 1));
        robot.mtrR.setPower(Range.clip((gamepad1.left_stick_y - gamepad1.right_stick_x), -1, 1));
        robot.mtrL.setPower(Range.clip((-gamepad1.left_stick_y - gamepad1.right_stick_x), -1, 1));
    }

    @Override
    public void stop()
    {
    }
}

