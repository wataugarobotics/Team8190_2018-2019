package org.firstinspires.ftc.team8190.HoloX2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/** ClassDoc */
@TeleOp(name = "Basic X", group = "TeleOp")
public class TeleXBasic extends OpMode {

    HWmap robot = new HWmap();

    // get motors w/o hw class (for testing)//

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {}

    // Code to run ONCE when the driver hits PLAY
    @Override
    public void start() {}

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        // get x, y, c values from joystick
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double c = -gamepad1.right_stick_x;
        double lift;
        double servoSpeed = 10;
        double closedPos = 45;
        boolean toggle = true;
        double lvlSpeed = 1;
        double lvlMult = 0.5;
        double val = 0;
        if (gamepad1.left_trigger > 0){
            lift = gamepad1.left_trigger;
        }
        else if (gamepad1.right_trigger > 0){
            lift = -gamepad1.right_trigger;
        }
        else {
            lift = 0;
        }
        if (gamepad1.dpad_up){
            lvlMult = lvlMult + 0.1;
        }
        else if (gamepad1.dpad_down){
            lvlMult = lvlMult - 0.1;
        }
        else if (gamepad1.start){
            lvlMult = 0.5;
        }
        else {}
        if (gamepad1.right_bumper){
            lvlSpeed = lvlMult * -1;
        }
        else if (gamepad1.left_bumper){
            lvlSpeed = lvlMult *  1;
        }
        else{
            lvlSpeed = 0;
        }


        // set motor powers
        robot.mtrFL.setPower(Range.clip((y + x + c), -1.0, 1.0));
        robot.mtrBL.setPower(Range.clip((y - x + c), -1.0, 1.0));
        robot.mtrFR.setPower(Range.clip((-y + x + c), -1.0, 1.0));
        robot.mtrBR.setPower(Range.clip((-y - x + c), -1.0, 1.0));
        robot.mtrLift.setPower(lift);
        robot.mtrLvl.setPower(lvlSpeed);
    }

    // Code to run ONCE after the driver hits STOP
    @Override
    public void stop() {
        robot.mtrFL.setPower(0);
        robot.mtrBL.setPower(0);
        robot.mtrFR.setPower(0);
        robot.mtrBR.setPower(0);
    }
}
