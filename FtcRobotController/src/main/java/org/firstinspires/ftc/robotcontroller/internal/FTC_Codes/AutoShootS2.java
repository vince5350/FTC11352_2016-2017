package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by URL #1 on 2017-02-11.
 */
@Autonomous(name="AutoShootStraightTwice")
public class AutoShootS2 extends LinearOpMode {

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorCatapault; //Catapault motor used to launch balls
    DcMotor UptakeMotor;
    DcMotor motorIntake;


    private ElapsedTime runtime = new ElapsedTime();
    double forwardSpeed = 0.5;
    double backwardSpeed = -0.5;


    @Override
    public void runOpMode() throws InterruptedException {

        motorLeft = hardwareMap.dcMotor.get("Left_Drive"); // this is telling the code where to get information on the motor i want
        motorRight = hardwareMap.dcMotor.get("Right_Drive");
        motorRight.setDirection(DcMotor.Direction.REVERSE); // as the motor is facing a different direction it must spin the opposite way
        motorCatapault = hardwareMap.dcMotor.get("Cat");
        UptakeMotor = hardwareMap.dcMotor.get("Conveyor");
        motorIntake = hardwareMap.dcMotor.get("Intake");
        motorIntake.setDirection(DcMotor.Direction.REVERSE);

        // CatMotor.setDirection(DcMotor.Direction.REVERSE);
        // telemetry.addData("Status:","Initialize Success!");
        //telemetry.update();

        telemetry.addData("Status","Waiting for start command"); //Tell driver to hit start.
        telemetry.update();

        this.waitForStart(); // wait for the start button to be hit on phone.

        // Step 1: Move robot forward for 10 seconds
        runtime.reset(); //Resets time counter for robot moving forward

        while(opModeIsActive() && runtime.seconds() < convDistTime(forwardSpeed, 0.2)){
            motorLeft.setPower(backwardSpeed); //Starts robot moving forward.
            motorRight.setPower(backwardSpeed);
            telemetry.addData("Progress","Step 1: %2.5f s elapsed", runtime.seconds());
            telemetry.update();
        }


        runtime.reset();
        while(opModeIsActive() && runtime.seconds() <2.0){
            motorLeft.setPower(0);
            motorRight.setPower(0);
            telemetry.addData("Progress","Hold for %2.5f s", runtime.seconds());
        }

        // Step 2: Set catapault
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 0.2){
            motorCatapault.setPower(-0.5);
        }

        //Step 3: Launch Catapault
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 3.0){
            motorCatapault.setPower(1.0);
        }

        //Step 4: Start uptake
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 5){
            motorCatapault.setPower(0);
            UptakeMotor.setPower(0.2);
            motorIntake.setPower(0.5);
        }

        //Step 5: Set ball
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 0.2){
            motorCatapault.setPower(-.5);
        }

        //Step 6: Shoot second ball
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 3.0){
            motorCatapault.setPower(1);
        }

        //Step 7: END
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 1.0){
            motorCatapault.setPower(0);
            motorIntake.setPower(0);
            UptakeMotor.setPower(0);
        }
        idle();
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
