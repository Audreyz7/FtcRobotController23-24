package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotDroneLauncher extends ARobotBase {
    private Servo droneLaunchServo = null;
    private int servoClockwise;
    private float servoPosition;

    private Gamepad gamepad1;

    public RobotDroneLauncher(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap){
        super.init(ahwMap);
        launcher = hwMap.get(Servo.class, "drone");
    }

    private void droneLaunch () {
        if (gamepad1.a) {
            droneLaunchServo.setPosition(1);
        }
        /*if (gamepad1.a && )
         what does this part do?
        if (gamepad1.dpad_right) {
            servoClockwise = 1;
        } else if (gamepad1.dpad_left) {
            servoClockwise = -1;
        } else {
            servoClockwise = 0;
        }*/
        servoPosition += 0.01 * servoClockwise;
        droneLaunchServo.setPosition(servoPosition);
        telemetry.addData("Drone launch, activated", droneLaunchServo.getPosition());
    }
}
