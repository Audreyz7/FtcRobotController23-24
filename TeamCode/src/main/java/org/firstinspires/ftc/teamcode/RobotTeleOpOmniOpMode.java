package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp(name = "Basic: Omni Linear OpMode", group = "Linear Opmode")
public class RobotTeleOpOmniOpMode extends LinearOpMode {
    // State used for updating telemetry
    Orientation angles;
    Acceleration gravity;
    // TeleOp
    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private Motor frontDrive = null;
    private Motor backDrive = null;
    private Motor rightDrive = null;
    private Motor leftDrive = null;
    private IMU imu;
    //drone launcher
    private Servo droneLaunchServo;
    private int servoclockwise;
    private double servoPosition;
    //arm rotation
    private Servo armRotationLeft;
    private Servo armRotationRight;
    // Possible claw rotation
    private Servo clawRotationLeft;
    private Servo clawRotationRight;
    // intake opening
    private Servo clawLeft;
    private Servo clawRight;

    @Override
    public void runOpMode() {
        frontDrive = hardwareMap.get(Motor.class, "frontMotor");
        backDrive = hardwareMap.get(Motor.class, "backMotor");
        leftDrive = hardwareMap.get(Motor.class, "leftMotor");
        rightDrive = hardwareMap.get(Motor.class, "rightMotor ");

        backDrive.setInverted(true);
        leftDrive.setInverted(true);
        frontDrive.setInverted(false);
        rightDrive.setInverted(false);

        /*
        TODO: determine which direction your control hub is facing
        Look at this to determine the right direction
        https://ftc-docs.firstinspires.org/en/latest/programming_resources/imu/imu.html
         */

        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        imu.initialize(parameters);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Waits for the start of the teleoperated period
        waitForStart();
        runtime.reset();

        // this drive base constructor is built for x-drive so it might not exactly work
        // but it probably will
        HDrive drive = new HDrive(frontDrive, rightDrive,
                leftDrive, backDrive);

        while (opModeIsActive()) {
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double y = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;
            double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            // this should be your entire drive (probably)
            //Field-Centric
            //For all types of holonomic drive you do this by calling the .driveFieldCentric() method that takes the gamepad inputs and converts them into directional values.
            //Additionally, you include the reading for the heading in degrees.
            //m_drive.driveFieldCentric(strafeSpeed, forwardSpeed, turn, heading);
            //The heading argument is the current heading of the robot, usually from the IMU. Note that it is in degress here, not radians.
            drive.driveFieldCentric(x, y, rx, heading);


            // Telemetry
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            //drone launch??
            if (gamepad1.y) {
                droneLaunch();
            }


            //put in continuous rotation mode and then rotate (rotation in radians)


        }
    }

    private void droneLaunch() {
        droneLaunchServo.setPosition(1);
        if (gamepad1.dpad_right) {
            servoclockwise = 1;
        } else if (gamepad1.dpad_left) {
            servoclockwise = -1;
        } else {
            servoclockwise = 0;
        }
        servoPosition += 0.01 * servoclockwise;
        droneLaunchServo.setPosition(servoPosition);
        telemetry.addData("Servo Positgion", droneLaunchServo.getPosition());
    }
}
