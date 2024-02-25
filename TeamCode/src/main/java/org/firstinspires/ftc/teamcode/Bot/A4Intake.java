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
    public double clawPositionmaxLeft= 1; //open
    public double clawPositionminLeft = 0.75; //close
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

        clawOpenLeft.setPosition(1);
        clawOpenRight.setPosition(clawStart);
        armRotationRight.setPosition(0.74);
        armRotationLeft.setPosition(0.74);
        sleep(2000);
        armRotationRight.setPosition(0);
        armRotationLeft.setPosition(0);

    }

    public void clawLeftOpen(boolean left_bumper) {
        if (left_bumper) {
            clawOpenLeft.setPosition(clawPositionminLeft);
        }
        else {
            clawOpenLeft.setPosition(clawPositionmaxLeft);
        }
    }

    public void clawRightOpen(boolean right_bumper) {
        if (right_bumper) {
            clawOpenRight.setPosition(clawPositionmaxRight);
        }
        else {
            clawOpenRight.setPosition(clawPositionminRight);
        }
    }

    public void ArmRotation (double position) {
        double minArmPosition = 0;
        double maxArmPosition = 0.74;
        // scales the position to a value between minArmPosition and maxArmPosition
        double scaled_position = (maxArmPosition - minArmPosition) * Math.min(1, Math.max(0, position)) + minArmPosition;
        armRotationLeft.setPosition(scaled_position);
        armRotationRight.setPosition(scaled_position);
    }
}
