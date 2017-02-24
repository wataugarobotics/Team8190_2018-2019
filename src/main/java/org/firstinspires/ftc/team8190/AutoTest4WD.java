//4WD Auto Test Code
/* Created by Ben, FTC 8190 Improv at its finest
 * version 1.0 Feb 3, 2017
 */

package org.firstinspires.ftc.team8190;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "8190: AutoTest4WD", group = "8190")
//@Disabled
public class AutoTest4WD extends LinearOpMode {
    HWtank8190 robot = new HWtank8190();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        sleep(500);

        robot.mtrFL.setPower(0.5);
        robot.mtrFR.setPower(0.5);
        robot.mtrBL.setPower(0.5);
        robot.mtrBR.setPower(0.5);

        sleep(1000);

        robot.mtrFL.setPower(-0.5);
        robot.mtrFR.setPower(0.5);
        robot.mtrBL.setPower(-0.5);
        robot.mtrBR.setPower(0.5);

        sleep(1000);

        robot.mtrFL.setPower(0.5);
        robot.mtrFR.setPower(-0.5);
        robot.mtrBL.setPower(0.5);
        robot.mtrBR.setPower(-0.5);

        sleep(1000);

        robot.mtrFL.setPower(0);
        robot.mtrFR.setPower(0);
        robot.mtrBL.setPower(0);
        robot.mtrBR.setPower(0);
    }
}