package org.firstinspires.ftc.team8190;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp: HoloX Without Compass Correction", group = "TeleOp")
public class HoloXTeleOp8190 extends LinearOpMode {
    
    // initialize the robot
    HoloX holo = new HoloX();
    HWholoX robot = new HWholoX();
    Time time = new Time();
    Gamepad controller = new Gamepad();
    Team8190 team = new Team8190();

    public HoloXTeleOp8190(){

    }

    private boolean speedToggle = true;
    private double thresh;
    private double servoSpeed = 10;
    public double servoOpenPosition = 0;
    public double servoStartPos(java.lang.String servo){
        if (servo == "left" || servo == "Left"){
            return 90;
        }
        else if (servo == "right" || servo == "Right"){
            return 90;
        }
        else if (servo == "Level" || servo == "level"){
            return 90;
        }
        else if (servo == "Arm" || servo == "arm"){
            return 90;
        }
        else {
            return 0;
        }
    }

    public void runOpMode(){
        
        robot.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()) {
            if (controller.triggerReadBoth(-1, 1) > thresh || controller.triggerReadBoth(-1, 1) < -thresh) {
                holo.spin(gamepad1.triggerReadBoth(-1, 1));
            }
            if (Math.abs(gamepad1.stickRead("Right", "y", -1, 1)) > thresh) {
                holo.position = robot.level.getPosition() + controller.stickRead("right", "y", -servoSpeed, servoSpeed);
                //team.moveServo("Level", holo.position);
            }
            if (Math.abs(gamepad1.stickRead("right", "X", -1, 1)) > thresh) {
                holo.position = robot.level.getPosition() + controller.stickRead("right", "x", -servoSpeed, servoSpeed);
            }
            if (gamepad1.left_stick_button = true) {
                speedToggle = !speedToggle;
                time.waitMilliseconds(100);
            }
            if (speedToggle = true) {
                holo.move(controller.getStickAngle("left"), 100);
            } else {
                holo.move(controller.getStickAngle("left"), 50);
            }
        }


    }

}
