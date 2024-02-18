package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class A2DroneLaunch extends A1HDrive{
    public Servo droneLaunchServo;

    public A2DroneLaunch(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap, Telemetry opmode_telemetry){
        super.init(ahwMap,opmode_telemetry);
        droneLaunchServo = ahwMap.get(Servo.class, "droneLauncher");
    }

    public void testDroneLaunch(double left_stick_y){
        droneLaunchServo.setPosition(left_stick_y);
    }

    public void droneReset(double servoPositionorg) {
        droneLaunchServo.setPosition(servoPositionorg);
    }

    public void launchDrone (double launchPosition) {
        droneLaunchServo.setPosition(launchPosition);
    }
}

