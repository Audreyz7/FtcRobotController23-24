package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Bot.A4Intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Tele op Mode", group = "TeleOp")
public class TeleOpMode extends LinearOpMode {
    private A4Intake robot = new A4Intake(this);
    private ElapsedTime runtime = new ElapsedTime();
    Telemetry opmode_telemetry;

    public int climbExtension = 0;
    public int climbRetract = 0;

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
             robot.handDrive(y1,x1,rx1);
             telemetry.addLine("Drive initialized");

             /******Drone launch******/ //Deadzone
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

             /******Viper extension*****/
             double y2 = -gamepad2.left_stick_y;
             robot.extension(y2);
             telemetry.addData("Right Viper Power", robot.rightViper.getPower());
             telemetry.addData("Left Viper Power", robot.leftViper.getPower());
             /******Claw******/ //Debug left claw opening
             robot.clawLeftOpen(gamepad2.left_bumper);
             telemetry.addData("Left Claw opened", robot.clawOpenLeft.getPosition());
             robot.clawRightOpen(gamepad2.right_bumper);
             telemetry.addData("Right Claw opened", robot.clawOpenRight.getPosition());
             /*****Arm Rotation******/
             double position = -gamepad2.right_stick_y;
             robot.ArmRotation(position);
             telemetry.addData("posl", robot.armRotationLeft.getPosition());
             telemetry.addData("posr", robot.armRotationRight.getPosition());
             /******Climb height*****/ //Test with truss, Can be hand tuned
             robot.climbHeight(gamepad2.b, climbExtension);
             robot.climbRetract(gamepad2.a, climbRetract);
             /******Drive Optimizations******
             robot.positionLeftTag(gamepad1.x);
             robot.positionCenterTag(gamepad1.y);
             robot.positionRightTag(gamepad1.b);
             /******Pixel Optimizations******
             robot.aimClaw(gamepad2.y);
             /******Pixel Placement******
             robot.xDistanceBoard();
             /******Testing: droneLauncher******
             double leftY = -gamepad1.left_stick_y;
             boolean x = gamepad1.x;
             telemetry.addData("Org", robot.droneLaunchServo.getPosition());
             robot.droneLaunchServo.setPosition(leftY);
             if (gamepad1.left_bumper) {
             telemetry.addData("Drone position", robot.droneLaunchServo.getPosition());
             }
             /************
            double position = -gamepad2.left_stick_y;
            clawOpenTest(position);
            telemetry.addData("dirl", robot.clawOpenLeft.getDirection());
            telemetry.addData("dirr", robot.clawOpenRight.getDirection());
            telemetry.addData("posl", robot.clawOpenLeft.getPosition());
            telemetry.addData("posr", robot.clawOpenRight.getPosition());
            /************/
            telemetry.update();
        }
        // insert whatever de-initialization things you need to do when the game ends.
    }


    public void clawOpenTest(double pos) {
        robot.clawOpenLeft.setPosition(pos);
        robot.clawOpenRight.setPosition(1-pos);
    }
}

