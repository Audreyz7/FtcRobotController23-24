package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.Bot.A4Intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Basic: Omni Linear OpMode", group = "Linear Opmode")
public class TeleOpMode extends LinearOpMode{
    private A4Intake robot = new A4Intake(this);
    public Gamepad gamepad1;
    public Gamepad gamepad2;
    public int climbExtensionLeft = 0;
    public int climbExtensionRight = 0;
    public int climbRetractLeft = 0;
    public int climbRetractRight = 0;

    //initialize all variables, check for all variables that needs to be initalized
    public double DroneOrg = 0;
    public float DronePos = 0;
    public void runOpMode() throws InterruptedException {
        boolean isAuto = false;
        /******Drive******/
        double y1 = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
        double x1 = gamepad1.left_stick_x;
        double rx1 = gamepad1.right_stick_x;
        robot.handDriveFieldCentric(y1,x1,rx1);
        /******Drone launch******/
        if (gamepad1.a) {
            robot.launchDrone(DronePos);
        }
        if (gamepad1.a && gamepad1.left_bumper) {
            robot.droneReset(DroneOrg);
        }
        /******Viper extension*****/
        double y2 = gamepad2.left_stick_y;
        robot.extension(y2);
        /******Claw******/
        robot.clawLeftOpen(gamepad2.left_bumper);
        robot.clawRightOpen(gamepad2.right_bumper);
        /******Arm Rotation******/
        double position = gamepad2.right_stick_y;
        robot.ArmRotation(position);
        /******Climb height*****/
        robot.climbHeight(gamepad2.b, climbExtensionLeft,climbExtensionRight);
        robot.climbRetract(gamepad2.a, climbRetractLeft, climbRetractRight);
        /******Drive Optimizations******/
        robot.positionLeftTag(gamepad1.x);
        robot.positionCenterTag(gamepad1.y);
        robot.positionRightTag(gamepad1.b);
        /******Pixel Optimizations******/
        robot.aimClaw(gamepad2.y);
        /******Pixel Placement******/

    }
}
