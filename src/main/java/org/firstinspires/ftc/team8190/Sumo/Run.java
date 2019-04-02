package org.firstinspires.ftc.team8190.Sumo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Run", group = "Sumo")
public class Run extends OpMode {

    private static final int COLOR_THRESH = 255;
    private static final double DISTANCE_THRESH = 0;

    private RobotMap robot = new RobotMap();
    private int[] color;
    private float left, right;
    private double distance;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void init_loop() {
        super.init_loop();
        distance = robot.getDistance();
        color = robot.getColor();
        telemetry.addLine("Distance: " + distance);
        telemetry.addLine("Color: R[" + color[0] + "] G[" + color[1] + "] B[" + color[2] + "]");
    }

    @Override
    public void loop() {
        distance = robot.getDistance();
        color = robot.getColor();
        telemetry.addLine("Distance: " + distance);
        telemetry.addLine("Color: R[" + color[0] + "] G[" + color[1] + "] B[" + color[2] + "]");
        if(color[0] > COLOR_THRESH && color[1] > COLOR_THRESH && color[2] > COLOR_THRESH){
            try {
                robot.move(-1, -1);
                wait(500);
                robot.move(-1, 1);
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            if(distance > DISTANCE_THRESH){
                robot.move(0.75f, 0.75f);
            }
            else {
                robot.move(1, 1);
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
        robot.stop();
    }
}
