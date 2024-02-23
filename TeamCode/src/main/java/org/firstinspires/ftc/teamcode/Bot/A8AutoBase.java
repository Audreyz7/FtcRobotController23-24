package org.firstinspires.ftc.teamcode.Bot;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.CloseBlueAuto;

import java.util.Set;

public class A8AutoBase extends A7VisionPortal {
    public A8AutoBase(LinearOpMode opMode) {
        super(opMode);
    }

    public void init(HardwareMap ahwMap) {
        super.init(ahwMap);
        backDrive.setInverted(false);
        leftDrive.setInverted(true);
        frontDrive.setInverted(true);
        rightDrive.setInverted(false);

        /*
        Look at this to determine the right direction for your imu
        https://ftc-docs.firstinspires.org/en/latest/programming_resources/imu/imu.html
         */
        imu = hwMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        imu.initialize(parameters);

        drive = new HDrive(frontDrive, backDrive, leftDrive, rightDrive);
    }

    public void driveYDistanceStraight(double distance, double rotationy) {
        //Forward,backward movement
        //1 rotation = 301.6 mm
        // 537.6 ppr
        //each tile is 24 inches = 609.6
        double rotations = distance/301.6;
        SetPowerStraight();
        if (rotationy == rotations) {
            SetPowerZero();
        }
    }

    public void driveXDistanceStraight(double distance, double rotationx) {
        //Left, right mvoement
        double rotations = distance/301.6;
        SetPowerLeft();
        if (rotationx == rotations) {
            SetPowerZero();
        }
    }

    public void turnAngle(double angle) {
        // turning
        angle *= (Math.PI / 180);
        double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double new_heading = heading;
        for (; new_heading != heading + angle;) {
            new_heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
            frontDrive.setRunMode(Motor.RunMode.RawPower);
            backDrive.setRunMode(Motor.RunMode.RawPower);
            leftDrive.setRunMode(Motor.RunMode.RawPower);
            rightDrive.setRunMode(Motor.RunMode.RawPower);
            frontDrive.set(0.5);
            backDrive.set(0.5);
            leftDrive.set(0.5);
            rightDrive.set(0.5);
        }
    }

    public void yellowPixelPlacement() {
        double a = 0.52;
        double b = 0.74;
        armRotationLeft.setPosition(b);
        armRotationRight.setPosition(b);
        clawOpenRight.setPosition(a);
    }

    public void purplePixelPlacement() {
        double a = 0.52;
        clawOpenLeft.setPosition(a);
    }

    public void pixelOuttake() {
        //Cant use without intake
        double a = 0.52;
        clawOpenLeft.setPosition(a);
    }

    public void pixelIntake() {
        //Set certain angle for stack intake
        //48 degrees?
        armRotationLeft.set
    }

    public void SetPowerStraight() {
        frontDrive.setRunMode(Motor.RunMode.RawPower);
        backDrive.setRunMode(Motor.RunMode.RawPower);
        frontDrive.set(0.5);
        backDrive.set(0.5);
    }

    public void SetPowerLeft() {
        leftDrive.setRunMode(Motor.RunMode.RawPower);
        rightDrive.setRunMode(Motor.RunMode.RawPower);
        leftDrive.set(0.5);
        rightDrive.set(0.5);
    }

    public void SetPowerZero() {
        frontDrive.set(0);
        backDrive.set(0);
        leftDrive.set(0);
        rightDrive.set(0);
    }
}
