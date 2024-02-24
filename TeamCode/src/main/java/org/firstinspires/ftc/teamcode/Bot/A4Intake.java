package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class    A4Intake extends A3LinearSlide{
    private boolean clawLeftOpen = false;
    private boolean clawRightOpen = false;

    //arm rotation
    public Servo armRotationLeft;
    public Servo armRotationRight;
    // intake opening
    public Servo clawOpenLeft;
    public Servo clawOpenRight;

    //Change these variables for tuning
    public double clawPositionmaxLeft= 0.52; //open
    public double clawPositionminLeft = 0; //close
    public double clawPositionmaxRight = 0.52;
    public double clawPositionminRight = 1;
    public double armPositionmax = 0.74;
    public double armPositionmin = 0;

    public double armStart = 0;
    public double clawStart = 1;

    public A4Intake (LinearOpMode opMode) {
        super(opMode);
    }

   @Override
    public void init(HardwareMap ahwMap){
        super.init(ahwMap);
        armRotationLeft = ahwMap.get(Servo.class, "armLeft");
        armRotationRight = ahwMap.get(Servo.class, "armRight");
        clawOpenLeft = ahwMap.get(Servo.class, "clawLeft");
        clawOpenRight = ahwMap.get(Servo.class, "clawRight");

        armRotationLeft.setDirection(Servo.Direction.REVERSE);
        clawOpenLeft.setDirection(Servo.Direction.REVERSE);
        //clawOpenRight.setDirection(Servo.Direction.REVERSE);

        clawOpenLeft.setPosition(clawStart);
        clawOpenRight.setPosition(clawStart);
        armRotationRight.setPosition(armStart);
        armRotationLeft.setPosition(armStart);
    }

    public void clawLeftOpen(boolean left_bumper) {
        boolean active = false;
        if (!left_bumper) {
            active = false;
        }
        if (left_bumper && clawLeftOpen && !active) {
            //open
            clawOpenLeft.setPosition(clawPositionmaxLeft);
            clawLeftOpen = true;
            active = true;
        }
        if (left_bumper && !clawLeftOpen && !active) {
            // close
            clawOpenLeft.setPosition(clawPositionmaxLeft);
            clawLeftOpen = false;
            active = true;
        }
    }

    public void clawRightOpen(boolean right_bumper) {
        boolean active = false;
        if (!right_bumper) {
            active = false;
        }
        if (right_bumper && clawLeftOpen && !active) {
            //open
            clawOpenLeft.setPosition(clawPositionmaxRight);
            clawLeftOpen = true;
            active = true;
        }
        if (right_bumper && !clawLeftOpen && !active) {
            // close
            clawOpenLeft.setPosition(clawPositionmaxRight);
            clawLeftOpen = false;
            active = true;
        }
    }

    public void ArmRotation (double position) {
        position = (position + 1) / 2;
        if (position >= armPositionmax) {
            armRotationLeft.setPosition(armPositionmax);
            armRotationRight.setPosition(armPositionmax);
        }
        if (position <= armPositionmin) {
            armRotationLeft.setPosition(armPositionmin);
            armRotationRight.setPosition(armPositionmin);
        } else {
            armRotationLeft.setPosition(position);
            armRotationRight.setPosition(position);
        }
    }
}
