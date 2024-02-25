package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Bot.A6PropPosition;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="Close Red", group="Autonomous")
public class CloseRedAuto extends LinearOpMode {
    private A8AutoBase robot = new A8AutoBase(this);

    public void runOpMode() throws InterruptedException {
        //1 matt length: 609.6 mm
        //Close pos 1 matt between spike matt and board
        //Far pos 3 matts between spike matt and board
        //Board from edge of matt 342.9mm
        //Starting wheel position from back (Back to middle wheel center): 228.2 mm
        //Wheel displacement from center to side (front wheel center to left side): 192 mm
        //Starting pos to end matt: 381.4mm
        //Space from end matt to center tape: 584.2mm
        //Left spike bd position from inside(moving under truss close to board): 482.6 mm
        //Center spike bd position from inside: 304.8 mm
        //Right spike bd position from inside: 127 mm
        //Length of truss supports: 1 beam leave space: 38.1mm
        //Length of tape
        //All measurements in mm
        //Center of rotation should not change when rotating
        //Long 6x* just delete the last "/" or add it back to comment and uncomment code
        /******I'll set up everything, and it will be up to you guys to calculate it******/
        //double clawTipToWheel = 506;
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
        resetEncoders();
        waitForStart();
        if (isStopRequested()) {
            return;
        }
        robot.driveYDistanceStraight(moveToSpike);
        //Moves forward onto the spiked tile
        if (robot.getPropPosition() == A6PropPosition.LEFT) {
            telemetry.addData("Prop Position:", A6PropPosition.LEFT);
            //Turns onto the left spike
            resetEncoders();
            robot.turnAngle(90.0);
            //Move to hover over spike, may need to be be 0
            resetEncoders();
            robot.driveYDistanceStraight(-(moveSpikeLeft));
            //Put down pixel & retract arm safely
            robot.purplePixelPlacement();
            robot.removeClaw();
            robot.purplePixelClose();
            robot.flipArmUp();
            //Moves to original position
            resetEncoders();
            robot.driveYDistanceStraight(moveSpikeLeft);
            // turns straight towards backboard
            resetEncoders();
            robot.turnAngle(-180.0);
            //drives towards backboard
            resetEncoders();
            robot.driveYDistanceStraight(closeMovetoBoard);
            //move infront of backboard placement position
            resetEncoders();
            robot.driveXDistanceStraight(moveBoardLeft);
            //places yellow pixel
            resetEncoders();
            robot.yellowPixelPlacement();
            //retracts vipers
            robot.climbRetract(retractPosition);
            //moves to parking sport at fence side, may drift
            resetEncoders();
            robot.driveXDistanceStraight(-(leftPark));
            //moves forward, ignoring drift/ parks
            resetEncoders();
            robot.driveYDistanceStraight(580);
        }
        if (robot.getPropPosition() == A6PropPosition.RIGHT) {
            telemetry.addData("Prop Position:", A6PropPosition.RIGHT);
            //turns right
            resetEncoders();
            robot.turnAngle(-90.0);
            //move to hover over spike
            resetEncoders();
            robot.driveYDistanceStraight(moveSpikeRight);
            //place purple
            robot.purplePixelPlacement();
            robot.removeClaw();
            robot.purplePixelClose();
            robot.flipArmUp();
            //move to original position
            resetEncoders();
            robot.driveYDistanceStraight(-(moveSpikeRight));
            //goes back to original
            resetEncoders();
            robot.driveXDistanceStraight(-521.2); //485.0+228.2-192
            //drive to backboard
            resetEncoders();
            robot.driveYDistanceStraight(closeMovetoBoard);
            //move to position
            resetEncoders();
            robot.driveXDistanceStraight(moveBoardRight);
            //yellow pacement
            resetEncoders();
            robot.yellowPixelPlacement();
            //retracts vipers
            robot.climbRetract(retractPosition);
            //moves to park
            resetEncoders();
            robot.driveXDistanceStraight(-(rightPark));
            //park
            resetEncoders();
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
            resetEncoders();
            robot.turnAngle(-90.0);
            //Move to backdrop
            resetEncoders();
            robot.driveYDistanceStraight(closeMovetoBoard);
            //align board center
            resetEncoders();
            robot.driveXDistanceStraight(moveBoardCenter);
            //yellow pixel palcement
            resetEncoders();
            robot.yellowPixelPlacement();
            //retracts vipers
            robot.climbRetract(retractPosition);
            //drive to fence
            resetEncoders();
            robot.driveXDistanceStraight(-(centerPark));
            //park
            resetEncoders();
            robot.driveYDistanceStraight(580);
        }
    }

    public void resetEncoders() {
        robot.leftDrive.resetEncoder();
        robot.rightDrive.resetEncoder();
        robot.frontDrive.resetEncoder();
        robot.backDrive.resetEncoder();
        robot.leftViper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightViper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftViper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightViper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
