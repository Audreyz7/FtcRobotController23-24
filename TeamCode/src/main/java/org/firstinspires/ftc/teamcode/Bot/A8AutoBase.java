package org.firstinspires.ftc.teamcode.Bot;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.CloseBlueAuto;

import java.util.Set;

public class A8AutoBase extends A7VisionPortal {
    public A8AutoBase(LinearOpMode opMode) {
        super(opMode);
    }

    int extension = 0; //configure vipers
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

        drive = new HDrive(frontDrive, backDrive, leftDrive, rightDrive);        if(USE_WEBCAM) {
            super.init(ahwMap);
        }
        armRotationLeft.setPosition(super.armStart);
        armRotationRight.setPosition(super.armStart);
        clawOpenLeft.setPosition(super.clawStart);
        clawOpenRight.setPosition(super.clawStart);
    }

    public void PropDetection(A5TeamColour teamColour) {

    }

    public void driveYDistanceStraight(double distance) {
        //Forward,backward movement
        //1 rotation = 301.6 mm
        // 537.6 pulses per rotation
        //each tile is 24 inches = 609.6
        double rotations = distance/301.6;
        SetPowerStraight();
        if (leftDrive.encoder.getRevolutions() == rotations) {
            SetPowerZero();
        }
    }

    public void driveXDistanceStraight(double distance) {
        //Left, right mvoement
        //double dpp = 301.6/577.6;
        double rotations = distance/301.6;
        SetPowerLeft();
        if (backDrive.encoder.getRevolutions() == rotations) {
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
            frontDrive.set(0.7);
            backDrive.set(0.7);
            leftDrive.set(0.7);
            rightDrive.set(0.7);
        }
    }

    public void flipArmUp() {
        double b = 0.74;
        armRotationLeft.setPosition(b);
        armRotationRight.setPosition(b);
    }

    public void yellowPixelPlacement() {
        double a = 0.52; //set left claw position (get from teleop
        leftViper.setTargetPosition(extension);
        rightViper.setTargetPosition(extension);
        clawOpenLeft.setPosition(a);
    }

    public void removeClaw() {
        double a = 0.30;
        clawOpenRight.setPosition(a);
    }

    public void purplePixelPlacement() {
        double a = 0.52; //open //set right claw position (get from teleop
        clawOpenRight.setPosition(a);
    }

    public void purplePixelClose() {
        //check with teleop
        clawOpenRight.setPosition(0);
    }

    public void pixelOuttake() {
        //Cant use without intake
        double a = 0.52;
        clawOpenLeft.setPosition(a);
        sleep(1200);
        clawOpenLeft.setPosition(1);
    }

    public void pixelIntake() {
        //Set certain angle for stack intake
        //48 degrees?
        armRotationLeft.setPosition(0.20);
        armRotationRight.setPosition(0.20);
    }

    public void SetPowerLeft() {
        frontDrive.setRunMode(Motor.RunMode.RawPower);
        backDrive.setRunMode(Motor.RunMode.RawPower);
        frontDrive.set(0.7);
        backDrive.set(0.7);
    }

    public void SetPowerStraight() {
        leftDrive.setRunMode(Motor.RunMode.RawPower);
        rightDrive.setRunMode(Motor.RunMode.RawPower);
        leftDrive.set(0.7);
        rightDrive.set(0.7);
    }

    public void SetPowerZero() {
        frontDrive.setRunMode(Motor.RunMode.RawPower);
        backDrive.setRunMode(Motor.RunMode.RawPower);
        leftDrive.setRunMode(Motor.RunMode.RawPower);
        rightDrive.setRunMode(Motor.RunMode.RawPower);
        frontDrive.set(0);
        backDrive.set(0);
        leftDrive.set(0);
        rightDrive.set(0);
    }

    public void resetEncoders() {
        leftDrive.resetEncoder();
        rightDrive.resetEncoder();
        frontDrive.resetEncoder();
        backDrive.resetEncoder();
        leftViper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightViper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftViper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightViper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
