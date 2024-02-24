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
        //1 matt length: 609.6 mm
        //Starting wheel position from back: 228.2mm
        //Starting pos to end matt: 381.4
        //Space from end matt to center tape:584.2
        //Move forward after
        //Space need to move: (584.2 - pixel middle to center wheel) + 381.4
        //rotate -> place pixel, flip arm up
        //Go to starting pos, not fully, avoding the truss
        //rotate, to straight
        // move to pixel palcement
        // extend vipers -> place
        // retract move sideways towards wall
        // moveforward -> park

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
