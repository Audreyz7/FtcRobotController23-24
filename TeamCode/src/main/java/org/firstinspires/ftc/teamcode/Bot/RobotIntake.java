package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class RobotIntake extends RobotLinearSlide {
    public int servoclockwise;
    public double servoPosition;
    //arm rotation
    public Servo armRotationLeft;
    public Servo armRotationRight;
    // intake opening
    public Servo clawOpenLeft;
    public Servo clawOpenRight;


    //Change these variables for tuning
    public float clawPositionmax = 0;
    public float clawPositionmin = 0;
    public float armPositionmax = 0;
    public float armPositionmin = 0;

    private boolean clawLeftOpen = false;
    private boolean clawRightOpen = false;
    public float armStart = 0;
    public float clawStart = 0;
    
    public RobotIntake (LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init(HardwareMap ahwMap){
        super.init(ahwMap);
        armRotationLeft = hwMap.get(Servo.class, "armRotation");
        armRotationRight = hwMap.get(Servo.class, "armRotation");
        clawOpenLeft = hwMap.get(Servo.class, "clawLeft");
        clawOpenRight = hwMap.get(Servo.class, "clawRight");

        armRotationRight.setPosition(armStart);
        armRotationLeft.setPosition(armStart);
    }

    public void Intake () {
        // Claw intake
        if (gamepad2.left_bumper) {
            clawOpenLeft.setPosition(clawPositionmax);
            clawLeftOpen = true;
        }
        if (gamepad2.right_bumper){
            armRotationRight.setPosition(clawPositionmin);
            clawRightOpen = true;
        }
        if (clawLeftOpen == true && gamepad2.left_bumper) {
            clawOpenLeft.setPosition(clawPositionmin);
            clawLeftOpen = false;
        }
        if (clawRightOpen == true && gamepad2.right_bumper) {
            clawOpenRight.setPosition(clawPositionmin);
            clawRightOpen = false;
        }

        // Arm rotation
        double position = gamepad2.right_stick_y;
        position = (position + 1 )/2;
        if (position >= armPositionmax) {
            armRotationLeft.setPosition(armPositionmax);
            armRotationRight.setPosition(armPositionmax);
        }
        if (position <= armPositionmin) {
            armRotationLeft.setPosition(armPositionmin);
            armRotationRight.setPosition(armPositionmin);
        }
        else {
            armRotationLeft.setPosition(position);
            armRotationRight.setPosition(position);
        }
    }
}
