package org.firstinspires.ftc.teamcode.Bot;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

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
        frontDrive = new Motor(hwMap, "frontMotor");
        backDrive = new Motor(hwMap, "backMotor");
        rightDrive = new Motor(hwMap, "rightMotor");
        leftDrive = new Motor(hwMap, "leftMotor");

        backDrive.setInverted(true);
        leftDrive.setInverted(true);
        frontDrive.setInverted(false);
        rightDrive.setInverted(false);

        /*
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing
        FIXME determine which direction your control hub is facing

        IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Look at this to determine the right direction for your imu
        https://ftc-docs.firstinspires.org/en/latest/programming_resources/imu/imu.html
         */
        imu = hwMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        imu.initialize(parameters);

        drive = new HDrive(frontDrive, rightDrive, leftDrive, backDrive);
    }

    public void handDriveFieldCentric(double left_stick_y, double left_stick_x, double right_stick_x) {
        double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        drive.driveFieldCentric(left_stick_x, left_stick_y, right_stick_x, heading);
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

