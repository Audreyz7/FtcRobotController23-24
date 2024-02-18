package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Bot.A4Intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

@TeleOp(name = "Basic: Omni Linear OpMode", group = "Linear Opmode")
public class TeleOpMode extends LinearOpMode{
    private A4Intake robot = new A4Intake(this);
    private ElapsedTime runtime = new ElapsedTime();
    Telemetry opmode_telemetry;

    public int climbExtensionLeft = 0;
    public int climbExtensionRight = 0;
    public int climbRetractLeft = 0;
    public int climbRetractRight = 0;

    //initialize all variables, check for all variables that needs to be initalized
    public double DroneOrg = 0.6;
    public double DronePos = 0;
    public void runOpMode() throws InterruptedException {
        //Telemetry telemetry = new Telemetry;
        boolean isAuto = false;

        //telemetry.addLine("Hello?");
        // initializes all the hardware by chaining through the human centipede type inheritance you got here.
        robot.init(hardwareMap, opmode_telemetry);
        telemetry.addData("Status", "Initialized");
        /******Make sure all devices connected******/
        telemetry.update();

        waitForStart();
        runtime.reset();

        while(opModeIsActive()) {
            /*telemetry.addData("Drone Servo", robot.droneLaunchServo.getConnectionInfo());
            telemetry.addData("Left Viper", robot.leftViper.getConnectionInfo());
            telemetry.addData("Right Viper", robot.rightViper.getConnectionInfo());
            telemetry.addData("Left arm", robot.armRotationLeft.getConnectionInfo());
            telemetry.addData("Right arm", robot.armRotationRight.getConnectionInfo());
            telemetry.addData("Clas left", robot.clawOpenLeft.getConnectionInfo());
            telemetry.addData("Claw Right", robot.clawOpenRight.getConnectionInfo());
            telemetry.update();

            /******Drive******/
            double y1 = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double x1 = gamepad1.left_stick_x;
            double rx1 = gamepad1.right_stick_x;
            robot.handDriveFieldCentric(y1,x1,rx1);
            telemetry.addLine("Drive initialized");
            telemetry.update();
            /******Drone launch******/
            if (gamepad1.a) {
                robot.launchDrone(DronePos);
                telemetry.addData("Drone Launched", robot.droneLaunchServo.getPosition());
                telemetry.update();
            }
            if (gamepad1.a && gamepad1.left_bumper) {
                robot.droneReset(DroneOrg);
                telemetry.addData("Drone reset", robot.droneLaunchServo.getPosition());
            }
            /******Viper extension*****
            double y2 = -gamepad2.left_stick_y;
            robot.extension(y2);
             telemetry.addData("Right Viper Power", robot.rightViper.getPower());
             telemetry.addData("Left Viper Power", robot.leftViper.getPower());
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
            /******Testing: Linear Slides******/
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
        }
        // insert whatever de-initialization things you need to do when the game ends.
    }
}
