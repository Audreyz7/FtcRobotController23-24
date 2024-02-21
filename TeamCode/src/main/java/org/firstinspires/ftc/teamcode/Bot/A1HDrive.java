package org.firstinspires.ftc.teamcode.Bot;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class A1HDrive extends ARobotBase {
    public Motor frontDrive;
    public Motor backDrive;
    public Motor rightDrive;
    public Motor leftDrive;
    public HDrive drive;
    public IMU imu;

    public A1HDrive(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap) {
        super.init(ahwMap);
        frontDrive = new Motor(ahwMap, "frontMotor");
        backDrive = new Motor(ahwMap, "backMotor");
        rightDrive = new Motor(ahwMap, "rightMotor");
        leftDrive = new Motor(ahwMap, "leftMotor");

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

    public void handDriveFieldCentric(double left_stick_y, double left_stick_x, double right_stick_x) {
        double rotated_x = left_stick_x * Math.cos(Math.toRadians(45)) - left_stick_y * Math.sin(Math.toRadians(45));
        double rotated_y = left_stick_x * Math.sin(Math.toRadians(45)) + left_stick_y * Math.cos(Math.toRadians(45));
        double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        heading += 45.0;
        drive.driveFieldCentric(rotated_x, right_stick_x, rotated_y, heading);
    }

    public void positionLeftTag(boolean x) {

    }

    public void positionCenterTag(boolean y) {

    }

    public void positionRightTag(boolean b) {

    }

    public void xDistanceBoard() {

    }
}

