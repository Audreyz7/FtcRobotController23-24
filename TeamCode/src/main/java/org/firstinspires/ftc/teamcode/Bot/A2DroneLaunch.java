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
        this.droneLaunchServo = ahwMap.get(Servo.class, "droneLauncher");
    }

    public void getDroneServo() {
        telemetry.addData("DroneLaunch Initialized", droneLaunchServo.getPosition());
    }
    public void testDroneLaunch(double left_stick_y, boolean x){
        droneLaunchServo.setPosition(left_stick_y);
        if (x) {
            telemetry.addData("Drone Launch Position", droneLaunchServo.getPosition());
        }
    }

    public void droneReset(double servoPositionorg) {
        droneLaunchServo.setPosition(servoPositionorg);
    }

    public void launchDrone (float launchPosition) {
        droneLaunchServo.setPosition(launchPosition);
        telemetry.addData("Drone launch, status: launched", droneLaunchServo.getPosition());
    }
}

