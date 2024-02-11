package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.hardware.Servo;

public class RobotDroneLauncher extends ARobotT2 {
    private Servo droneLaunchServo = null;
    private int servoClockwise;
    private float servoPosition;

    private void droneLaunch () {
        if (gamepad1.a) {
            droneLaunchServo.setPosition(1);
        }

        if (gamepad1.a && )
        /* what does this part do?
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
