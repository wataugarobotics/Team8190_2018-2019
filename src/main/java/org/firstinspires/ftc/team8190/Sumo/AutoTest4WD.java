//4WD Auto Test Code
/* Created by Ben, FTC 8190 Improv at its finest
 * version 2.0 Mar 16, 2017
 */

package org.firstinspires.ftc.team8190.Sumo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/*
How to make your own 8190 SumoBot autonomous program:
-make sure you have setup the Team8190 directory as directed on GitHub
-copy this file, and rename it whatever you want (probably your name)
-replace all "AutoTest4WD"s below with the name of your file (capitalization counts!)
-replace all of the inner code starting with "move.forward(0.5);" with your own program
    -use move.[insert forward/reverse/left/right w/o brackets](power); to move (power from 0-1)
    -use move.swerve("[forward/backward]", "[left/right]", power); to swerve
    -use move.stop(); to stop
    -use sensor.getcolor() to get a numerical representation of color (for telemetry add 0xFF)
    -use sensor.getdistance() to get a numerical representation of distance
-send it to me (Ben) so I can add it to the codebase
 */

@Autonomous(name = "8190: AutoTest4WD", group = "8190")
public class AutoTest4WD extends LinearOpMode {
    HWtank8190 robot = new HWtank8190();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        sensor.colorlight(true);

        while (true) {
            //movement demo
            move.forward(0.5);
            sleep(500);
            move.right(0.5);
            sleep(1000);
            move.left(0.5);
            sleep(1000);
            move.reverse(0.5);
            sleep(500);
            move.swerve("forward", "left", 0.5);
            sleep(500);
            move.stop();
            sleep(500);

            //show sensor status via telemetry
            telemetry.addData("Color: ", sensor.getcolor() & 0xFF);
            telemetry.addData("Distance: ", sensor.getdistance());
        }
    }
}