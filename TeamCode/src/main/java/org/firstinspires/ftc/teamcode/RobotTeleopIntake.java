package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotTeleopIntake extends RobotTeleOpOmniOpMode{
    //drone launcher
    private Servo droneLaunchServo;
    private int servoclockwise;
    private double servoPosition;
    //arm rotation
    private Servo armRotationLeft;
    private Servo armRotationRight;
    // Possible claw rotation
    private Servo clawRotationLeft;
    private Servo clawRotationRight;
    // intake opening
    private Servo clawLeft;
    private Servo clawRight;

}
