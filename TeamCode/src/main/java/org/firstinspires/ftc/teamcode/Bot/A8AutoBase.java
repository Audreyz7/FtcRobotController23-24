package org.firstinspires.ftc.teamcode.Bot;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Bot.A7VisionPortal;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class A8AutoBase extends A7VisionPortal{
    public A7VisionPortal robot = new A7VisionPortal(this);
    public static double WIDTH = 17.78;
    public static double LENGTH = 17.5;
    // always starting boardside
    public static double START_X = 24 - WIDTH / 2;
    public static double START_Y = 72 - (LENGTH / 2);
    public static double BONUS_OFFSET = -6.22;
    public static double SPIKE_BACK_OFFSET = -10;

    public static double BASE_X = 34, BASE_Y = 36, BASE_H = 180;
    public static double SC_X = 15.11, SC_Y = 27;
    public static double SR_X = 8, SR_Y = 36, SR_H = -90;
    public static double SL_X = 29, SL_Y = 36, SL_H = 90;
    public static double DROP_X = 49, DROP_Y = 48;
    public static double DROP_CENTER = 35, DROP_OFFSET = 5;
    public static double PARK_X = 60, PARK_Y = 60;
    public static double BOARD_X1 = -55, BOARD_Y1 = 12;
    public static double BOARD_X2 = 38, BOARD_Y2 = 12;

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

    public void driveXDistanceStraight(double x ) {

    }

    public void straftXAngle(double x) {

    }

    public void yellowPixelPlacement(boolean x) {

    }

    public void purplePixelPlacement(boolean x) {

    }

    public void pixelIntake(boolean x) {

    }

}
