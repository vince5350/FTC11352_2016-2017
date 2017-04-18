package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes; // this is where its located

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Evan on 24/10/2016.
 */

// NOTES: Current code is for two gamepads, but can be altered for use with one.
// If you are viewing on Android Studio or a text file you may need to scroll right to see some comments, if viewing copy on drive you should be fine.
// Currently uptake and Intake are on Gamepad 1, drive and Catapult are on 2.
// I AM STILL NEW TO THIS! There is probably some errors in here but it works well enough.



@TeleOp(name="Catapult_Test FIX", group="Pushbot") // this registers it so you can you it on the FTC apps on the phone
public class Catapult_TestREDONE extends OpMode{// this states that this code is writing on top of the previously built code "OpMode"

    public Catapult_TestREDONE(){

        // Mysteriously empty
        // Honestly I don't know what this does

    }

    // this will be outside so that all modes can use it...If it is inside one Opmode it is only usable by that one

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorIntake;
    DcMotor UptakeMotor;
    DcMotor CatMotor;

    float left;
    float right;

    float Yax; // Rbumper stands for the button Right bumper on the gamepad

    //boolean abortRobot; //If digital set to TRUE, kill code.

    float bleh;
  //ompRobotSetup robot = new CompRobotSetup();
// these must be listed in the list of variables so they can be used later in the process of tying buttons
// and so that power can be applied to the items the variables stand for*/

//-------------------------------------------------------------------------------------------------------

    public void init(){ // this is where the variables are listed to be called upon by void loop

        motorLeft = hardwareMap.dcMotor.get("Left_Drive"); // this is telling the code where to get information on the motor i want
        motorRight = hardwareMap.dcMotor.get("Right_Drive");
        motorRight.setDirection(DcMotor.Direction.REVERSE); // as the motor is facing a different direction it must spin the opposite way

        motorIntake = hardwareMap.dcMotor.get("Intake");//This is the front intake motor
        motorIntake.setDirection(DcMotor.Direction.REVERSE);

        UptakeMotor = hardwareMap.dcMotor.get("Conveyor"); // this is the conveyor belt motor
        //UptakeMotor.setDirection(DcMotor.Direction.REVERSE);

        CatMotor = hardwareMap.dcMotor.get("Cat");
       // CatMotor.setDirection(DcMotor.Direction.REVERSE);
       // telemetry.addData("Status:","Initialize Success!");
        //telemetry.update();

    }//initiates variables

//--------------------------------------------------------------------------------------------------

    public void loop() {

        //while (!abortRobot) {

            left = gamepad1.left_stick_y;  // ths is tying the main drive motors to left and right analog sticks on the gamepad
            right = gamepad1.right_stick_y;

            right = Range.clip(right, -1, 1); // this is reducing the analog stick range from -255, 255 to -1, 1
            left = Range.clip(left, -1, 1);  //motor = Range.clip (motor, min, max);
            motorLeft.setPower(left);   // this gives power to the motor
            motorRight.setPower(right);
            telemetry.addData("Motors:","Motor Power left: %f",left);
            telemetry.addData("Motors:","Motor power right: %f", right);
            telemetry.update();
            // This lets you drive

            // significant split here ------------------------------------------------------even though they are all bindings
            //--------------------------------------------------------------------------------------------------

            Yax = gamepad2.left_stick_y;
            Yax = Range.clip(Yax, -1,1);
            UptakeMotor.setPower(Yax*.2);
            motorIntake.setPower(Yax*.5);



            //----------------------------------------------------------------------------------------------------


            bleh = gamepad2.right_stick_y;
            bleh = Range.clip(bleh, -255, 1);
            CatMotor.setPower(bleh);

            //this should let you use the catapult
            //abortRobot = gamepad1.start;
        /*
       }*/ //loop function, main code <-- loop basically means the program keeps running this section of code until it is told to stop}
    }
//-------------------------------------------------------------------------------------------------




    public void stop(){





    } // ~Fin
}
// mysterious curly bracket actually closes up code. if you go back to the top you will see a corresponding bracket right,
// after the line public class Catapult_Test extends OpMode


