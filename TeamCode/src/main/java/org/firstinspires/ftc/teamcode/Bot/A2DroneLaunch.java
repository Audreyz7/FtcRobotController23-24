package org.firstinspires.ftc.teamcode.Bot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class A2DroneLaunch extends A1HDrive{
    public Servo droneLaunchServo;

    public A2DroneLaunch(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap){
        super.init(ahwMap);
        this.droneLaunchServo = hwMap.get(Servo.class, "droneLauncher");
    }

    public void droneReset(double servoPositionorg) {
        droneLaunchServo.setPosition(servoPositionorg);
        telemetry.addData("Drone launch, status: reset", droneLaunchServo.getPosition());
    }

    public void launchDrone (float launchPosition) {
        droneLaunchServo.setPosition(launchPosition);
        telemetry.addData("Drone launch, status: launched", droneLaunchServo.getPosition());
    }
}

