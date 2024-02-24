package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Bot.A6PropPosition;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FarRedAuto extends LinearOpMode{
    private A8AutoBase robot = new A8AutoBase(this);

    public void runOpMode() throws InterruptedException {
        double moveToSpike = 485.0; //609.6-228.2+609.6-25.4-506+25.4
        double moveSpikeLeft = 76.2; //3 inches
        double moveBoardLeft = 254.4; //482.6-228.2
        double leftPark = 897.6;//609.6+480-192
        //double moveSpikeCenter =  485.0; //609.6-228.2+609.6-25.4-506+25.4
        double moveBoardCenter = 0; //May need change
        double centerPark = 717.6; //609.6+300-192
        double moveSpikeRight = 76.2;
        double moveBoardRight = 544.6; //609.6-192+127
        double rightPark = 544.6;
        double closeMovetoBoard = 459.6; //609.6-228.2+584.2-506
        double farMovetoBoard = 0;
        int retractPosition = 0; //need to configure
        robot.resetEncoders();
        waitForStart();
        if (isStopRequested()) {
            return;
        }
        robot.driveYDistanceStraight(moveToSpike);
        if (robot.getPropPosition() == A6PropPosition.LEFT) {
            telemetry.addData("Prop Position:", A6PropPosition.LEFT);
            //Turns onto the left spike
            robot.resetEncoders();
            robot.turnAngle(90.0);
            //Move to hover over spike, may need to be be 0
            robot.resetEncoders();
            robot.driveYDistanceStraight(-(moveSpikeLeft));
            //Put down pixel & retract arm safely
            robot.purplePixelPlacement();
            robot.removeClaw();
            robot.purplePixelClose();
            robot.flipArmUp();
            //Moves to original position
            robot.resetEncoders();
            robot.driveYDistanceStraight(moveSpikeLeft);
            // turns straight towards backboard
            robot.resetEncoders();
            robot.turnAngle(-180.0);
            //drives towards backboard
            robot.resetEncoders();
            robot.driveYDistanceStraight(farMovetoBoard);
            //move infront of backboard placement position
            robot.resetEncoders();
            robot.driveXDistanceStraight(moveBoardLeft);
            //places yellow pixel
            robot.resetEncoders();
            robot.yellowPixelPlacement();
            //retracts vipers
            robot.climbRetract(retractPosition);
            //moves to parking sport at fence side, may drift
            robot.resetEncoders();
            robot.driveXDistanceStraight(-(leftPark));
            //moves forward, ignoring drift/ parks
            robot.resetEncoders();
            robot.driveYDistanceStraight(580);
        }
        if (robot.getPropPosition() == A6PropPosition.RIGHT) {
            telemetry.addData("Prop Position:", A6PropPosition.RIGHT);
            //turns right
            robot.resetEncoders();
            robot.turnAngle(-90.0);
            //move to hover over spike
            robot.resetEncoders();
            robot.driveYDistanceStraight(moveSpikeRight);
            //place purple
            robot.purplePixelPlacement();
            robot.removeClaw();
            robot.purplePixelClose();
            robot.flipArmUp();
            //move to original position
            robot.resetEncoders();
            robot.driveYDistanceStraight(-(moveSpikeRight));
            //goes back to original
            robot.resetEncoders();
            robot.driveXDistanceStraight(-521.2); //485.0+228.2-192
            //drive to backboard
            robot.resetEncoders();
            robot.driveYDistanceStraight(farMovetoBoard);
            //move to position
            robot.resetEncoders();
            robot.driveXDistanceStraight(moveBoardRight);
            //yellow pacement
            robot.resetEncoders();
            robot.yellowPixelPlacement();
            //retracts vipers
            robot.climbRetract(retractPosition);
            //moves to park
            robot.resetEncoders();
            robot.driveXDistanceStraight(-(rightPark));
            //park
            robot.resetEncoders();
            robot.driveYDistanceStraight(580);
        } else {
            telemetry.addData("Prop Position:", A6PropPosition.CENTER);
            //move to center spike already
            //Put down pixel & retract arm safely
            robot.purplePixelPlacement();
            robot.removeClaw();
            robot.purplePixelClose();
            robot.flipArmUp();
            //Move to backdrop
            robot.resetEncoders();
            robot.turnAngle(-90.0);
            //Move to backdrop
            robot.resetEncoders();
            robot.driveYDistanceStraight(farMovetoBoard);
            //align board center
            robot.resetEncoders();
            robot.driveXDistanceStraight(moveBoardCenter);
            //yellow pixel palcement
            robot.resetEncoders();
            robot.yellowPixelPlacement();
            //retracts vipers
            robot.climbRetract(retractPosition);
            //drive to fence
            robot.resetEncoders();
            robot.driveXDistanceStraight(-(centerPark));
            //park
            robot.resetEncoders();
            robot.driveYDistanceStraight(580);
        }
    }
}
