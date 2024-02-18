package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.Bot.A4Intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry;


@TeleOp(name = "Basic: Omni Linear OpMode", group = "Linear Opmode")
public class TeleOpMode extends LinearOpMode{
    private A4Intake robot = new A4Intake(this);
    private ElapsedTime runtime = new ElapsedTime();

    public int climbExtensionLeft = 0;
    public int climbExtensionRight = 0;
    public int climbRetractLeft = 0;
    public int climbRetractRight = 0;

    //initialize all variables, check for all variables that needs to be initalized
    public double DroneOrg = 0;
    public float DronePos = 0;
    public void runOpMode() throws InterruptedException {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        boolean isAuto = false;

        //telemetry.addLine("Hello?");
        // initializes all the hardware by chaining through the human centipede type inheritance you got here.
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        /******Make sure all devices connected******/
        telemetry.update();

        /*robot.getDroneServo();
        robot.getLeftViper();
        robot.getRightViper();
        /*robot.getArmLeft();
        robot.getArmRight();
        robot.getClawLeft();
        robot.getClawRight();*/

        waitForStart();
        runtime.reset();

        while(opModeIsActive()) {
            /******Drive******
            double y1 = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double x1 = gamepad1.left_stick_x;
            double rx1 = gamepad1.right_stick_x;
            robot.handDriveFieldCentric(y1,x1,rx1);
            /******Drone launch******
            if (gamepad1.a) {
                robot.launchDrone(DronePos);
            }
            if (gamepad1.a && gamepad1.left_bumper) {
                robot.droneReset(DroneOrg);
            }
            /******Viper extension*****
            double y2 = -gamepad2.left_stick_y;
            robot.extension(y2);
            /******Claw******
            robot.clawLeftOpen(gamepad2.left_bumper);
            robot.clawRightOpen(gamepad2.right_bumper);
            /******Arm Rotation******
            double position = -gamepad2.right_stick_y;
            robot.ArmRotation(position);
            /******Climb height*****
            robot.climbHeight(gamepad2.b, climbExtensionLeft,climbExtensionRight);
            robot.climbRetract(gamepad2.a, climbRetractLeft, climbRetractRight);
            /******Drive Optimizations******
            robot.positionLeftTag(gamepad1.x);
            robot.positionCenterTag(gamepad1.y);
            robot.positionRightTag(gamepad1.b);
            /******Pixel Optimizations******
            robot.aimClaw(gamepad2.y);
            /******Pixel Placement******
            robot.xDistanceBoard();
            /******Testing: Intake******
            double r1 = gamepad1.right_stick_x;
            double r2 = -gamepad2.right_stick_y;
            double l1 = gamepad1.left_stick_x;
            double l2 = -gamepad2.left_stick_y;
            robot.testServos(r1,l1,r2,l2);
            /******Testing: Linear Slides******
            double leftY = -gamepad1.left_stick_y;
            robot.TestViper(leftY);
            /******Testing: droneLauncher******/
            double leftY = -gamepad1.left_stick_y;
            boolean x = gamepad1.x;
            robot.testDroneLaunch(leftY,x);
            /************/
        }
        // insert whatever de-initialization things you need to do when the game ends.
    }
}
