/*package org.firstinspires.ftc.teamcode.Bot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

import javax.annotation.processing.Processor;

public class A5VisionPortal extends A4Intake {
    VisionPortal.Builder myVisionPortalBuilder;
    boolean USE_WEBCAM;
    int RESOLUTION_WIDTH;
    int RESOLUTION_HEIGHT;
    VisionPortal myVisionPortal;
    boolean lastX;
    int frameCount;
    long capReqTime;
    boolean x;

    Processor myAprilTagProcessor;

    public A5VisionPortal(LinearOpMode opMode) {
        super(opMode);
    }

    public void init(HardwareMap ahwMap, Telemetry opmode_telemetry) {
        super.init(ahwMap, opmode_telemetry);
        // Specify the camera to be used for this VisionPortal.
        myVisionPortalBuilder.setCamera(ahwMap.get(WebcamName.class, "Webcam 1"));
    }

    public void visionPortal() {
        // Add the AprilTag Processor to the VisionPortal Builder.
        myVisionPortalBuilder.addProcessor(myAprilTagProcessor);       // An added Processor is enabled by default.

        // Optional: set other custom features of the VisionPortal (4 are shown here).
        myVisionPortalBuilder.setCameraResolution(new Size(640, 480));  // Each resolution, for each camera model, needs calibration values for good pose estimation.
        myVisionPortalBuilder.setStreamFormat(VisionPortal.StreamFormat.YUY2);  // MJPEG format uses less bandwidth than the default YUY2.
        myVisionPortalBuilder.enableCameraMonitoring(true);      // Enable LiveView (RC preview).
        myVisionPortalBuilder.setAutoStopLiveView(true);     // Automatically stop LiveView (RC preview) when all vision processors are disabled.

        // Create a VisionPortal by calling build()
        myVisionPortal = myVisionPortalBuilder.build();
    }
}*/
