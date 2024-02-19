package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class A3LinearSlide extends A2DroneLaunch {
    public DcMotor leftViper;
    public DcMotor rightViper;

    public A3LinearSlide(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap, Telemetry opmode_telemetry) {
        super.init(ahwMap, opmode_telemetry);
        rightViper = ahwMap.get(DcMotor.class, "rightViper");
        leftViper = ahwMap.get(DcMotor.class, "leftViper");
    }

    public void TestViper(double left_stick_yy) {
        rightViper.setPower(left_stick_yy);
        leftViper.setPower(-left_stick_yy);
    }
    public void extension(double left_stick_yy) {
        double left_stick_y = -left_stick_yy; //test to be changed
        rightViper.setPower(left_stick_y);
        leftViper.setPower(-left_stick_y);
    }

    public void climbHeight(boolean b, int climbPositionLeft, int climbPositionRight) {
        rightViper.setTargetPosition(climbPositionRight);
        leftViper.setTargetPosition(climbPositionLeft);
        telemetry.addData("Right Viper Position", rightViper.getCurrentPosition());
        telemetry.addData("Left Viper Position", leftViper.getCurrentPosition());
    }

    public void climbRetract(boolean a, int climbRetractLeft, int climbRetractRight) {
        rightViper.setTargetPosition(climbRetractRight);
        leftViper.setTargetPosition(climbRetractLeft);
    }

}
