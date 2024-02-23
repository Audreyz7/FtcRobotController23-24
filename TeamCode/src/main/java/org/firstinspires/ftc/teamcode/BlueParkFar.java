package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Bot.A6PropPosition;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;

@Autonomous(name="Blue Park Farside", group="Autonomous")
public class BlueParkFar extends LinearOpMode {
    private A8AutoBase robot = new A8AutoBase(this);

    public void runOpMode() throws InterruptedException {

        waitForStart();
        if (isStopRequested()) {
            return;
        }
        if(robot.getPropPosition() == A6PropPosition.LEFT ) {

        }
        if(robot.getPropPosition() == A6PropPosition.RIGHT) {

        }
        else {
            //Center
        }

    }
}
