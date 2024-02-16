package org.firstinspires.ftc.teamcode.Bot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotDroneLauncher extends RobotHDrive {
    private Servo droneLaunchServo;

    //set positions
    private int servoClockwise;
    private float servoPosition = 0;
    private float servoPositionorg = 0;

    public RobotDroneLauncher(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap){
        super.init(ahwMap);
        this.droneLaunchServo = hwMap.get(Servo.class, "drone");
    }

    private void droneLaunch () {

        if (gamepad1.a) {
            droneLaunchServo.setPosition(1);
        }
        if (gamepad1.a && gamepad1.left_bumper) {
            droneLaunchServo.setPosition(servoPositionorg);
        }

        servoPosition += 0.01 * servoClockwise;
        droneLaunchServo.setPosition(servoPosition);
        telemetry.addData("Drone launch, activated", droneLaunchServo.getPosition());
    }
}
