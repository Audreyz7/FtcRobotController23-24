package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Bot.A6PropPosition;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="Close Blue", group="Autonomous")
public class CloseBlueAuto extends LinearOpMode{
    private A8AutoBase robot = new A8AutoBase(this);

    public void runOpMode() throws InterruptedException {
        /*
        robot.leftDrive.resetEncoder();
        robot.rightDrive.resetEncoder();
        robot.frontDrive.resetEncoder();
        robot.backDrive.resetEncoder();
         */

        waitForStart();
        if (isStopRequested()) {
            return;
        }
        double pmtcw = 0;
        double spaceToMove = (584.2-pmtcw-20) + 381.4;
        robot.resetEncoders();
        robot.driveYDistanceStraight(spaceToMove);
        if(robot.getPropPosition() == A6PropPosition.LEFT ) {

        }
        if(robot.getPropPosition() == A6PropPosition.RIGHT) {

        }
        else {
            //Center

        }
    }
}
