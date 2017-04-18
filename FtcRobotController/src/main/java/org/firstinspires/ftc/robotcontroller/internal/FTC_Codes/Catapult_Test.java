package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes; // this is where its located

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // these are base codes we expand upon
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
//import org.firstinspires.ftc.robotcontroller.internal.FTC_Codes.CompRobotSetup;
/**
 * Created by Evan on 24/10/2016.
 */

// NOTES: Current code is for two gamepads, but can be altered for use with one.
// If you are viewing on Android Studio or a text file you may need to scroll right to see some comments, if viewing copy on drive you should be fine.
// Currently uptake and Intake are on Gamepad 1, drive and Catapult are on 2.
// I AM STILL NEW TO THIS! There is probably some errors in here but it works well enough.



//@TeleOp(name="Catapult_Test", group="Pushbot") // this registers it so you can you it on the FTC apps on the phone

public class Catapult_Test extends OpMode{// this states that this code is writing on top of the previously built code "OpMode"

    public Catapult_Test(){

        // Mysteriously empty
        // Honestly I don't know what this does

    }

    // this will be outside so that all modes can use it...If it is inside one Opmode it is only usable by that one



    DcMotor motorLeft; //Left Drive motor
    DcMotor motorRight; // Right Drive motor
    DcMotor motorIntake; // Intake motor
    DcMotor UptakeMotor; // Uptake motor
    DcMotor CatMotor; // Catapult motor

    float left,right;
    boolean Cat;

    boolean Rbumper; // Rbumper stands for the button Right bumper on the gamepad
    boolean Lbumper;// Lbumper stands for the button Left bumper on the gamepad

    float bleh;

// these must be listed in the list of variables so they can be used later in the process of tying buttons
// and so that power can be applied to the items the variables stand for

//-------------------------------------------------------------------------------------------------------

    public void init(){ // this is where the variables are listed to be called upon by void loop
        /*
        motorLeft = hardwareMap.dcMotor.get("Left_Drive"); // this is telling the code where to get information on the motor i want
        motorRight = hardwareMap.dcMotor.get("Right_Drive");
        motorLeft.setDirection(DcMotor.Direction.REVERSE); // as the motor is facing a different direction it must spin the opposite way

        motorIntake = hardwareMap.dcMotor.get("Intake");//This is the front intake motor
        motorIntake.setDirection(DcMotor.Direction.REVERSE);

        UptakeMotor = hardwareMap.dcMotor.get("Conveyor"); // this is the conveyor belt motor
        //UptakeMotor.setDirection(DcMotor.Direction.REVERSE);

        CatMotor = hardwareMap.dcMotor.get("Cat");
       // CatMotor.setDirection(DcMotor.Direction.REVERSE);
        */
    } //initiates variables

//--------------------------------------------------------------------------------------------------

    public void loop(){

        left = gamepad1.left_stick_y;  // ths is tying the main drive motors to left and right analog sticks on the gamepad
        right = gamepad1.right_stick_y;

        right = Range.clip(right, -1,1); // this is reducing the analog stick range from -255, 255 to -1, 1
        left = Range.clip(left, -1,1);  //motor = Range.clip (motor, min, max);

        motorLeft.setPower(left);   // this gives power to the motors
        motorRight.setPower(right);

// This lets you drive

// significant split here ------------------------------------------------------even though they are all bindings

        Rbumper = gamepad2.right_bumper; // this is where those variables come in handy
        Lbumper = gamepad2.left_bumper;

        // this is tying variables to actual physical buttons

        // if statements say if a certain condition is met, do this {function it does goes in curly brackets}

// if you are working on the code and this is highlighted just ignore it

        motorIntake.setMaxSpeed(1);


        if (Rbumper){
            motorIntake.setPower(1);
        }

        if (Lbumper){
            motorIntake.setPower(0);
        }
        // Another split -----------------------------------------------------------------------------------------

        Rbumper = gamepad2.right_bumper;
        Lbumper = gamepad2.left_bumper;

        UptakeMotor.setMaxSpeed(1);


        if(Rbumper) {
            UptakeMotor.setPower(1); // I'm hoping this gives us less speed on the motor
        }

        if (Lbumper) {
            UptakeMotor.setPower(0);

        // this lets you use the intake

        }

        // this should let you use the uptake

//----------------------------------------------------------------------------------------------------


        bleh = gamepad2.right_stick_y;
        bleh = Range.clip(bleh,-255,1);
        CatMotor.setPower(bleh);

        //this should let you use the catapult
    } //loop function, main code <-- loop basically means the program keeps running this section of code until it is told to stop



//-------------------------------------------------------------------------------------------------




    public void stop(){




    } // ~Fin
}
// mysterious curly bracket actually closes up code. if you go back to the top you will see a corresponding bracket right,
// after the line public class Catapult_Test extends OpMode


