package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Bot.A6PropPosition;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FarRedAuto extends LinearOpMode{
    private A8AutoBase robot = new A8AutoBase(this);

    public void runOpMode() throws InterruptedException {

        waitForStart();
        if (isStopRequested()) {
            return;
        }

        if (robot.getPropPosition() == A6PropPosition.LEFT) {

        }
        if (robot.getPropPosition() == A6PropPosition.RIGHT) {

        } else {
            //Center
        }
    }
}
