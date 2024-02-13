package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotIntake extends RobotLinearSlide {
    private int servoclockwise;
    private double servoPosition;
    //arm rotation
    private Servo armRotationLeft;
    private Servo armRotationRight;
    // Possible claw rotation
    private Servo clawRotationLeft;
    private Servo clawRotationRight;
    // intake opening
    private Servo clawOpenLeft;
    private Servo clawOpenRight;

    //Change these variables for tuning
    public RobotIntake (LinearOpMode opMode) {
        super(opMode);
    }
}
