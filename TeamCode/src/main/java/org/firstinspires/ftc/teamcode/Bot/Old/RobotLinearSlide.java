package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class RobotLinearSlide extends RobotDroneLauncher {
    public Gamepad gamepad1;
    public Gamepad gamepad2;
    public DcMotor leftViper;
    public DcMotor rightViper;

    public double joystickposition;

    public double positionleft;
    public double positionright;

    public double minpos;
    public double maxpos;
    public RobotLinearSlide (LinearOpMode opMode) {
        super(opMode);
    }

    public void init(HardwareMap ahwMa) {
        super.init(ahwMa);
        leftViper = hardwareMap.get(DcMotor.class, "leftViper");
        rightViper = hardwareMap.get(DcMotor.class, "rightViper");
    }

    public void LinearSlide () {
        joystickposition = -gamepad2.left_stick_y;
    }

}
