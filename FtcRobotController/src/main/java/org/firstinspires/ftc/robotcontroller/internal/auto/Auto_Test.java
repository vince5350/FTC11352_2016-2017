/**package org.firstinspires.ftc.robotcontroller.internal.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.internal.FTC_Codes.Basic_Drive_2;
import org.firstinspires.ftc.robotcontroller.internal.FTC_Codes.Catapult_Test;

/**
 * Created by URL #1 on 2017-01-05.




@Autonomous(name="Blue Left")

public class Auto_Test extends LinearOpMode {



    Catapult_Test robot   = new Catapult_Test();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.8;
    static final double     TURN_SPEED    = 0.7;


    public void init(){


    }

    /**
     * Created by URL #1 on 2017-01-04.

    @Autonomous(name="Blue Left")


    // Field size is 125.25'^2

    public static class Autonomous_Blue1 extends LinearOpMode{


        /* Declare OpMode members.
        Catapult_Test         robot   = new Catapult_Test();   // Use a Pushbot's hardware
        private ElapsedTime runtime = new ElapsedTime();


        static final double     FORWARD_SPEED = 0.8;
        static final double     TURN_SPEED    = 0.7;

        @Override
        public void runOpMode() throws InterruptedException {

            /*
             * Initialize the drive system variables.
             * The init() method of the hardware class does all the work here
             *

            //MAY NOT WORK might have to be robot.init(hardwareMap);
            robot.init();

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Ready to run");    //
            telemetry.update();

            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

            // Step 1:  Drive forward for 3 seconds
            robot.motorLeft.setPower(FORWARD_SPEED); //Rename motors to match your code in
            robot.motorRight.setPower(FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
                idle();
            }

            // Step 2:  Spin right for 1.3 seconds
            robot.motorLeft.setPower(TURN_SPEED);
            robot.motorRight.setPower(-TURN_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.3)) {
                telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
                idle();
            }

            // Step 3:  Drive Backwards for 1 Second
            robot.motorLeft.setPower(-FORWARD_SPEED);
            robot.motorRight.setPower(-FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
                idle();
            }

            // Step 4:  Stop the Robot
            robot.motorLeft.setPower(0);
            robot.motorRight.setPower(0);

            telemetry.addData("Path", "Complete");
            telemetry.update();
            sleep(1000);
            idle();
        }
    }

    /**
     * Created by URL #1 on 2017-01-04.
     *

    public static class Autonomous_Blue2 extends LinearOpMode {


        Basic_Drive_2 robot  = new Basic_Drive_2();
        private ElapsedTime runtime = new ElapsedTime();


       public void init(){

        }

    }

    /**
     * Created by URL #1 on 2017-01-04.
     *

    public static class Autonomous_Red1 {
    }

    /**
     * Created by URL #1 on 2017-01-04.
     *

    public static class Autonomous_Red2 {
    }
}
 **/