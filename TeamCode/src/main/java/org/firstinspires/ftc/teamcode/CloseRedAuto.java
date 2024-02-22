package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="SampleAutonomous", group="Autonomous")
public class CloseRedAuto extends LinearOpMode {

    // Declare motor variables
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor frontMotor;

    private DcMotor backMotor;

    // Constants for motor powers and distances
    private static final double DRIVE_POWER = 0.5;
    private static final double TURN_POWER = 0.5;
    private static final int DRIVE_DISTANCE = 1000; // Adjust this value for your robot's needs
    private static final int TURN_DISTANCE = 500; // Adjust this value for your robot's needs

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors
        frontMotor = hardwareMap.get(DcMotor.class, "frontMotor");
        backMotor = hardwareMap.get(DcMotor.class, "backMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");


        // Reverse the direction of one motor if necessary
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontMotor.setDirection(DcMotor.Direction.REVERSE);


        // Wait for the start button to be pressed
        waitForStart();

        // Move forward for a certain distance
        driveForward(DRIVE_POWER, DRIVE_DISTANCE);

        // Turn
        turn(TURN_POWER, TURN_DISTANCE);

        // Stop
        stopRobot();
    }

    // Method to make the robot move forward for a specified distance
    private void driveForward(double power, int distance) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
        sleep(calculateDriveTime(distance));
        stopRobot();
    }

    // Method to make the robot turn for a specified distance
    private void turn(double power, int distance) {
        leftMotor.setPower(power);
        rightMotor.setPower(-power);
        sleep(calculateTurnTime(distance));
        stopRobot();
    }

    // Method to calculate time for driving based on distance
    private long calculateDriveTime(int distance) {
        // Adjust this calculation based on your robot's speed and gearing
        return (long)(1000 * (distance / DRIVE_POWER / 1000));
    }

    // Method to calculate time for turning based on distance
    private long calculateTurnTime(int distance) {
        // Adjust this calculation based on your robot's turning radius and speed
        return (long)(1000 * (distance / TURN_POWER / 1000));
    }

    // Method to stop the robot
    private void stopRobot() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
