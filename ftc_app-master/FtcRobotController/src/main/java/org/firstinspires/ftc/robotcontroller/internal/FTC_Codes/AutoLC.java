package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by URL #1 on 2017-02-11.
 */
@Autonomous(name="AutoLeftCurved")
public class AutoLC extends LinearOpMode {

    DcMotor motorLeft;
    DcMotor motorRight;


    private ElapsedTime runtime = new ElapsedTime();
    double forwardSpeed = 0.5;
    double backwardSpeed = -0.5;


    @Override
    public void runOpMode() throws InterruptedException {

        motorLeft = hardwareMap.dcMotor.get("Left_Drive"); // this is telling the code where to get information on the motor i want
        motorRight = hardwareMap.dcMotor.get("Right_Drive");
        motorRight.setDirection(DcMotor.Direction.REVERSE); // as the motor is facing a different direction it must spin the opposite way


        // CatMotor.setDirection(DcMotor.Direction.REVERSE);
        // telemetry.addData("Status:","Initialize Success!");
        //telemetry.update();

        telemetry.addData("Status","Waiting for start command"); //Tell driver to hit start.
        telemetry.update();

        this.waitForStart(); // wait for the start button to be hit on phone.

        // Step 1: Move robot forward for 10 seconds
        runtime.reset(); //Resets time counter for robot moving forward

        while(opModeIsActive() && runtime.seconds() < convDistTime(forwardSpeed, 0.58)){
            motorLeft.setPower(backwardSpeed); //Starts robot moving forward.
            motorRight.setPower(backwardSpeed);
            telemetry.addData("Progress","Step 1: %2.5f s elapsed", runtime.seconds());
            telemetry.update();
        }

        //Step 2: Spin robot for 5 seconds
        runtime.reset();// Resets time counter

       while(opModeIsActive() && runtime.seconds() < 0.6){
            motorRight.setPower(backwardSpeed);
            motorLeft.setPower(forwardSpeed);
            telemetry.addData("Progress","Step 2: %2.5f s elapsed", runtime.seconds());
            telemetry.update();
        }
    //Step 3: Wait 10 seconds to avoid crossing line
    runtime.reset();
    while(opModeIsActive() && runtime.seconds() < 10.0){
        motorLeft.setPower(0); //Starts robot moving forward.
        motorRight.setPower(0);
        telemetry.addData("Progress","Step 1: %2.5f s elapsed", runtime.seconds());
        telemetry.update();
    }

        runtime.reset(); //reset time count
        //Step 3: Move robot forward.
        while(opModeIsActive() && runtime.seconds() < convDistTime(forwardSpeed, 0.70)){
            motorLeft.setPower(backwardSpeed); //Starts robot moving forward.
            motorRight.setPower(backwardSpeed);
            telemetry.addData("Progress","Step 1: %2.5f s elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    float convDistTime(double power, double distance){
        double c = 2.01 ; // Calibration constant
        double velocity = Math.abs((c * power * 152 * 0.1016 * 3.1415)) / 60.0;
        float time = (float) (distance / velocity);
        telemetry.addData("Time: ", "Function return: %f", time);
        telemetry.update();
        return time;


    }
}
