package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Bot.A4Intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

@TeleOp(name = "Basic: Omni Linear OpMode", group = "Linear Opmode")
public class TeleOpMode extends LinearOpMode {
    private A4Intake robot = new A4Intake(this);
    private ElapsedTime runtime = new ElapsedTime();
    Telemetry opmode_telemetry;

    public int climbExtensionLeft = 0;
    public int climbExtensionRight = 0;
    public int climbRetractLeft = 0;
    public int climbRetractRight = 0;

    public double clawPos = 0;

    //initialize all variables, check for all variables that needs to be initalized
    public double DroneOrg = 0.6;
    public double DronePos = 0;

    public void runOpMode() throws InterruptedException {
        //Telemetry telemetry = new Telemetry;
        boolean isAuto = false;
        boolean launcher = false;

        //telemetry.addLine("Hello?");
        // initializes all the hardware by chaining through the human centipede type inheritance you got here.
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        /******Make sure all devices connected******/
        //telemetry.update();

        /*public double Deadband(double d) {
            if (Math.abs(d) < 0.05) {
                return 0;
            }
            else {
                return d;
            }
        }*/

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            /******Drive******/ //Debug
             double y1 = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
             double x1 = gamepad1.left_stick_x;
             double rx1 = gamepad1.right_stick_x;
             robot.handDriveFieldCentric(y1,x1,rx1);
             telemetry.addLine("Drive initialized");
             /******Drone launch******/ //Pass
             if (gamepad1.a) {
             robot.launchDrone(DronePos);
             launcher = true;
             }
             if (gamepad1.a && gamepad1.left_bumper) {
             robot.droneReset(DroneOrg);
             }
             if (launcher = true) {
             telemetry.addLine("Drone Launched");
             }

             /******Viper extension*****/ //Good, tension left viper and set restrictions
             double y2 = -gamepad2.left_stick_y;
             robot.extension(y2);
             telemetry.addData("Right Viper Power", robot.rightViper.getPower());
             telemetry.addData("Left Viper Power", robot.leftViper.getPower());
             /******Claw******/ //Debug why opening does not work
             robot.clawLeftOpen(gamepad2.left_bumper);
             telemetry.addData("Left Claw opened", robot.clawOpenLeft.getPosition());
             robot.clawRightOpen(gamepad2.right_bumper);
             telemetry.addData("Right Claw opened", robot.clawOpenRight.getPosition());
             //*****Arm Rotation****** //Arm Servo Broken
             double position = -gamepad2.right_stick_y;
             robot.ArmRotation(position);
             /******Climb height***** //Test with truss, Can be hand tuned
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
             robot.clawOpenRight.setPosition(1);
             double r1 = gamepad1.right_stick_y;
             double r2 = -gamepad2.right_stick_y;
             double l1 = gamepad1.left_stick_y;
             double l2 = 1;
             robot.testServos(r1);
             telemetry.addData("Arm Left Position", robot.armRotationLeft.getPosition());
             telemetry.addData("Arm Right Position", robot.armRotationRight.getPosition());
             telemetry.addData("Claw left Position", robot.clawOpenLeft.getPosition());
             telemetry.addData("Claw Right Position", robot.clawOpenRight.getPosition());
             /******Testing: Linear Slides******
             double leftY = -gamepad2.left_stick_y;
             robot.TestViper(leftY);
             telemetry.addData("Right Viper Position", robot.rightViper.getCurrentPosition());
             telemetry.addData("Left Viper Position", robot.leftViper.getCurrentPosition());
             /******Testing: droneLauncher******
             double leftY = -gamepad1.left_stick_y;
             boolean x = gamepad1.x;
             telemetry.addData("Org", robot.droneLaunchServo.getPosition());
             robot.testDroneLaunch(leftY);
             if (gamepad1.left_bumper) {
             telemetry.addData("Drone position", robot.droneLaunchServo.getPosition());
             }
             /************/
             telemetry.update();

             if(gamepad2.a) {
                 clawPos += 0.001;
             }
             if (gamepad2.b) {
                 clawPos -= 0.001;
             }
             robot.clawOpenLeft.setPosition(clawPos);


        }
        // insert whatever de-initialization things you need to do when the game ends.
    }
}

