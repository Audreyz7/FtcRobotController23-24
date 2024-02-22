package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Bot.A7VisionPortal;
import org.firstinspires.ftc.teamcode.Bot.A8AutoBase;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="Close Blue", group="Autonomous")
public class CloseBlueAuto extends A8AutoBase{
    private A8AutoBase robot = new A8AutoBase(this);
    public CloseBlueAuto(LinearOpMode opMode) {
        super(opMode);
    }
    public void init(HardwareMap ahwMap) {
        super.init(ahwMap);
    }
}
