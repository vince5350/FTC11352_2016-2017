package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by king.e on 9/27/2016.
 */

//@TeleOp(name="Basic Drive 4", group="Pushbot")

public class Basic_Drive_4 extends OpMode {

    public Basic_Drive_4(){



    }




    DcMotor motorLeft;
    DcMotor motorLeftRear;
    DcMotor motorRight; // this will be outside so that all modes can use it...If it is inside one opmode it is only usable by it
    DcMotor motorRightRear;


    public void init(){

        motorLeft = hardwareMap.dcMotor.get("Left_Drive");
        motorLeftRear = hardwareMap.dcMotor.get("Left_Drive_Rear");
        motorRight = hardwareMap.dcMotor.get("Right_Drive"); //motor2 must be the exact same as the config file on the phone;
        motorRightRear = hardwareMap.dcMotor.get("Right_Drive_Rear");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorLeftRear.setDirection(DcMotor.Direction.REVERSE);


    } //initiates variables


    public void loop(){

        float left,right;
        left = gamepad1.left_stick_y;
        right = gamepad1.right_stick_y;

        right = Range.clip(right, -1,1);
        left = Range.clip(left, -1,1);  //motor = Range.clip (motor, min, max);

        motorLeft.setPower(left);
        motorLeftRear.setPower(left);
        motorRight.setPower(right);
        motorRightRear.setPower(right);

    } //loop function, main code


    public void stop(){} //stop function
}