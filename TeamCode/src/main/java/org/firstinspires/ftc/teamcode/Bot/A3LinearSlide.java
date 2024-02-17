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
    public void init(HardwareMap hwMap) {
        rightViper = hwMap.get(DcMotor.class, "rightViper");
        leftViper = hwMap.get(DcMotor.class, "leftViper");
    }
    public double Deadband(double d) {
        if (Math.abs(d) < 0.05) {
            return 0;
        }
        else {
            return d;
        }
    }
    public void extension(double left_stick_yy) {
        double left_stick_y = Deadband(-left_stick_yy); //test to be changed
        rightViper.setPower(left_stick_y);
        leftViper.setPower(-left_stick_y);
    }

    public void climbHeight(boolean b, int climbPositionLeft, int climbPositionRight) {
        rightViper.setTargetPosition(climbPositionRight);
        leftViper.setTargetPosition(climbPositionLeft);
    }

    public void climbRetract(boolean a, int climbRetractLeft, int climbRetractRight) {
        rightViper.setTargetPosition(climbRetractRight);
        leftViper.setTargetPosition(climbRetractLeft);
    }

}
