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
    public float clawPositionmax = 0;
    public float clawPositionmin = 0;
    public float armPositionmax = 0;
    public float armPositionmin = 0;

    public float armStart = 0;
    public float clawStart = 0;

    public A4Intake (LinearOpMode opMode) {
        super(opMode);
    }

   @Override
    public void init(HardwareMap ahwMap, Telemetry opmode_telemetry){
        super.init(ahwMap, opmode_telemetry);
        armRotationLeft = ahwMap.get(Servo.class, "armLeft");
        armRotationRight = ahwMap.get(Servo.class, "armRight");
        clawOpenLeft = ahwMap.get(Servo.class, "clawLeft");
        clawOpenRight = ahwMap.get(Servo.class, "clawRight");

        clawOpenRight.setPosition(1);
        clawOpenLeft.setPosition(0);
        //armRotationRight.setPosition(armStart);
        //armRotationLeft.setPosition(armStart);
    }

    public void testServos(double r1, double l1, double r2, double l2) {
        armRotationLeft.setPosition(r1);
        armRotationRight.setPosition(l1);
        clawOpenLeft.setPosition(r2);
        clawOpenRight.setPosition(l2);
    }

    public void getArmLeft() {
        telemetry.addData("ArmLeft Initialized", armRotationLeft.getConnectionInfo());
    }

    public void getArmRight() {
        telemetry.addData("ArmRight Initialized", armRotationRight.getConnectionInfo());
    }

    public void getClawLeft() {
        telemetry.addData("ClawLeft Initialized", clawOpenLeft.getConnectionInfo());
    }

    public void getClawRight() {
        telemetry.addData("clawRight Initialized", clawOpenRight.getConnectionInfo());
    }

    public void clawLeftOpen(boolean left_bumper) {
        if (left_bumper) {
            clawOpenLeft.setPosition(clawPositionmax);
            clawLeftOpen = true;
        }
        if (clawLeftOpen && left_bumper) {
            clawOpenLeft.setPosition(clawPositionmin);
            clawLeftOpen = false;
        }
    }

    public void clawRightOpen(boolean right_bumper) {
        if (right_bumper) {
            clawOpenRight.setPosition(clawPositionmax);
            clawRightOpen = true;
        }
        if (clawRightOpen && right_bumper) {
            clawOpenRight.setPosition(clawPositionmin);
            clawRightOpen = false;
        }
    }

    public void ArmRotation (double position) {
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

    public void aimClaw(boolean y) {

    }

    public void armPosition(boolean x) {

    }
}
