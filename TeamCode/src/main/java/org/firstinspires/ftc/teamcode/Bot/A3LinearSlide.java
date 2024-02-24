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
    public void init(HardwareMap ahwMap) {
        super.init(ahwMap);
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

    public void climbHeight(int climbPosition) {
        rightViper.setTargetPosition(climbPosition);
        leftViper.setTargetPosition(climbPosition);
    }

    public void climbRetract(int climbRetract) {
        rightViper.setTargetPosition(climbRetract);
        leftViper.setTargetPosition(climbRetract);
    }

}
