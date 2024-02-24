package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Bot.A6PropPosition;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="Close Red", group="Autonomous")
public class CloseRedAuto extends LinearOpMode {
    private A8AutoBase robot = new A8AutoBase(this);

    public void runOpMode() throws InterruptedException {
        double pmtcw = 0;
        double spaceToMove = (584.2-pmtcw-20) + 381.4;
        robot.resetEncoders();
        waitForStart();
        robot.driveYDistanceStraight(spaceToMove);
        if (isStopRequested()) {
            return;
        }
        if (robot.getPropPosition() == A6PropPosition.LEFT) {
            /*            robot.turnAngle(90.0);
            robot.purplePixelPlacement();
            robot.removeClaw();
            robot.purplePixelClose();
            robot.flipArmUp();
            robot.driveYDistanceStraight();
            robot.turnAngle(-90.0);*/
        }
        if (robot.getPropPosition() == A6PropPosition.RIGHT) {

        } else {
            //Center
        }
    }
}
