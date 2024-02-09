package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class RobotDroneLauncher extends RobotTeleOpOmniOpMode{
    private Servo droneLaunchServo = null;
    private int servoClockwise;
    private float servoPosition;

    private void droneLaunch () {
        if (gamepad1.y) {
            droneLaunchServo.setPosition(1);
        }
        if (gamepad1.dpad_right) {
            servoClockwise = 1;
        } else if (gamepad1.dpad_left) {
            servoClockwise = -1;
        } else {
            servoClockwise = 0;
        }
        servoPosition += 0.01 * servoClockwise;
        droneLaunchServo.setPosition(servoPosition);
        telemetry.addData("Servo Positgion", droneLaunchServo.getPosition());
    }
}
