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
    public void init(HardwareMap ahwMap){
        super.init(ahwMap);
        droneLaunchServo = ahwMap.get(Servo.class, "droneLauncher");
        droneLaunchServo.setPosition(0.6);
        droneLaunchServo.setDirection(Servo.Direction.REVERSE);
    }

    public boolean droneReset(double servoPositionorg) {
        droneLaunchServo.setPosition(servoPositionorg);
        return true;
    }

    public void launchDrone (double launchPosition) {
        droneLaunchServo.setPosition(launchPosition);
    }
}

