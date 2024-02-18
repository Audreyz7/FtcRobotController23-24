package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;


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
    public double Deadband(double d) {
        if (Math.abs(d) < 0.05) {
            return 0;
        }
        else {
            return d;
        }
    }

    public void getLeftViper() {
        telemetry.addData("LeftViper Initialized", leftViper.getConnectionInfo());
    }
    public void getRightViper() {
        telemetry.addData("RightViper Initialized", rightViper.getConnectionInfo());
    }
    public void TestViper(double left_stick_yy) {
        rightViper.setPower(left_stick_yy);
        telemetry.addData("Right Viper Position", rightViper.getCurrentPosition());
        leftViper.setPower(-left_stick_yy);
        telemetry.addData("Left Viper Position", leftViper.getCurrentPosition());
    }
    public void extension(double left_stick_yy) {
        double left_stick_y = Deadband(-left_stick_yy); //test to be changed
        rightViper.setPower(left_stick_y);
        leftViper.setPower(-left_stick_y);
        telemetry.addData("Right Viper Power", rightViper.getPower());
        telemetry.addData("Left Viper Power", leftViper.getPower());
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
