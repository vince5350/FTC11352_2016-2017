package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // these are base codes we expand upon
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;








/**
 * Created by Evan on 24/10/2016.
 */






// NOTES: Current code is for one gamepad, but can be altered for use with two
// if you are viewing on Android Studio you may need to scroll right to see some comments, if viewing copy on drive you should be fine




//@TeleOp(name="Intake Test", group="Pushbot") // this registers it so you can you it on the FTC apps on the phone

public class Intake_Test extends OpMode{// this states that this code is writing on top of the previously built code "OpMode"





    public Intake_Test(){

        // Mysteriously empty
        // Honestly I don't know what this does

    }



    DcMotor motorLeft;
    DcMotor motorRight; // this will be outside so that all modes can use it...If it is inside one opmode it is only usable by that one
    DcMotor motorIntake;


    boolean intake; // intake stands for the motor that will be attached to the intake on the robot
    boolean Rbumper; // Rbumper stands for the button Right bumper on the gamepad
    boolean Lbumper;// Lbumper stands for the button Left bumper on the gamepad


// these must be listed in the list of variables so they can be used later in the process of tying buttons
// and so that power can be applied to the items the variables stand for


//-------------------------------------------------------------------------------------------------------


    public void init(){ // this is where the variables are listed to be called upon by void loop



        motorLeft = hardwareMap.dcMotor.get("Left_Drive"); // this is telling the code where to get information on the motor i want
        motorRight = hardwareMap.dcMotor.get("Right_Drive");



        motorLeft.setDirection(DcMotor.Direction.REVERSE); // as the motor is facing a different direction it must spin the opposite way


        motorIntake = hardwareMap.dcMotor.get("Intake");//This is the front intake motor

        motorIntake.setDirection(DcMotor.Direction.REVERSE);

    } //initiates variables



//--------------------------------------------------------------------------------------------------

    public void loop(){



        float left,right;
        left = gamepad1.left_stick_y;  // ths is tying the main drive motors to left and right analog sticks on the gamepad
        right = gamepad1.right_stick_y;




        right = Range.clip(right, -1,1); // this is reducing the analog stick range from -255, 255 to -1, 1
        left = Range.clip(left, -1,1);  //motor = Range.clip (motor, min, max);



        motorLeft.setPower(left);   // this gives power to the motors

        motorRight.setPower(right);



// significant split here ------------------------------------------------------even though they are all bindings


        Rbumper = gamepad1.right_bumper; // this is where those variables come in handy
        Lbumper = gamepad1.left_bumper;




        // if statements say if a certain condition is met, do this {function it does goes in curly brackets}

// if you are working on the code and this is highlighted just ignore it

        if (Rbumper){
            motorIntake.setPower(1);
        }

        if (Lbumper){
            motorIntake.setPower(0);
        }

    } //loop function, main code


//-------------------------------------------------------------------------------------------------


    public void stop(){




    } // ~Fin
}
// mysterious curly bracket actually closes up code. if you go back to the top you will see a corresponding bracket right,
// after the line public abstract class FTC_Code extends OpMode


