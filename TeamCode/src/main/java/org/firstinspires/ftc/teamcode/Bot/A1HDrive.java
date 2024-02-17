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
    private ElapsedTime runtime = new ElapsedTime();
    public Motor frontDrive;
    public Motor backDrive;
    public Motor rightDrive;
    public Motor leftDrive;
    public IMU imu;

    public A1HDrive(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap hwMap) {
        super.init(hwMap);
        frontDrive = hwMap.get(Motor.class, "frontMotor");
        backDrive = hwMap.get(Motor.class, "backDrive");
        rightDrive = hwMap.get(Motor.class, "rightMotor");
        leftDrive = hwMap.get(Motor.class, "leftDrive");
    }

    public void handDriveFieldCentric(double left_stick_y, double left_stick_x, double right_stick_x) {
        double y = -left_stick_y;  // Note: pushing stick forward gives negative value
        double x = left_stick_x;
        double rx = right_stick_x;

        backDrive.setInverted(true);
        leftDrive.setInverted(true);
        frontDrive.setInverted(false);
        rightDrive.setInverted(false);

        /*
        TODO: determine which direction your control hub is facing
        Look at this to determine the right direction
        https://ftc-docs.firstinspires.org/en/latest/programming_resources/imu/imu.html
         */

        imu = hwMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        imu.initialize(parameters);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //waitForStart(); Figure out what is wrong with this
        runtime.reset();

        HDrive drive = new HDrive(frontDrive, rightDrive, leftDrive, backDrive);

        double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        drive.driveFieldCentric(x, y, rx, heading);
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

