/*/package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

** Below is a simple time-based coding structure for your robot. As you can see, it programs it in "Steps" and then runs from top to bottom, waiting for an elapsed time in the while{} loop to be done before
 * moving to the next step. It is critical that the runtime.reset() command is run before each step. I've also added some simple telemetry so that you can see it's application in the code.
 *
 * Think about the potential benefits + extended application of utilizing telemetry in future code (especally for FRC).




public class AutonomousOpMode extends LinearOpMode {

    //Code is written to move robot ahead 10 seconds, then spin for 5 seconds.

    CompRobotSetup robot   = new CompRobotSetup();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    double forwardSpeed = 0.25;
    double backwardSpeed = 0.25;


    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        telemetry.addData("Status","Waiting for start command"); //Tell driver to hit start.
        telemetry.update();

        this.waitForStart(); // wait for the start button to be hit on phone.

        // Step 1: Move robot forward for 10 seconds
        runtime.reset(); //Resets time counter for robot moving forward

        while(opModeIsActive() && runtime.seconds() < 5.0){
            robot.motorLeft.setPower(forwardSpeed); //Starts robot moving forward.
            robot.motorRight.setPower(forwardSpeed);
            telemetry.addData("Progress","Step 1: %2.5f s elapsed", runtime.seconds());
            telemetry.update();
        }

        //Step 2: Spin robot for 5 seconds
        runtime.reset();// Resets time counter

        while(opModeIsActive() && runtime.seconds() < 2.5){
            robot.motorRight.setPower(forwardSpeed);
            robot.motorLeft.setPower(backwardSpeed);
            telemetry.addData("Progress","Step 2: %2.5f s elapsed", runtime.seconds());
            telemetry.update();
        }

    }
}
*/