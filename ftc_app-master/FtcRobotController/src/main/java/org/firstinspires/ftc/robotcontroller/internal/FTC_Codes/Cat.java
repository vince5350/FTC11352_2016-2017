package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by king.e on 9/27/2016.
 */


//@TeleOp(name="Cat", group="Pushbot")

public class Cat extends OpMode {

    public Cat(){



    }


    DcMotor motorLeft;
     // this will be outside so that all modes can use it...If it is inside one opmode it is only usable by it



    public void init(){

        motorLeft = hardwareMap.dcMotor.get("motor1");
       // motorRight = hardwareMap.dcMotor.get("motor2"); //motor2 must be the exact same as the config file on the phone;
      //  motorLeft.setDirection(DcMotor.Direction.REVERSE);

    } //initiates variables


    public void loop(){

        float left,right;
        left = gamepad1.left_stick_y;
       // right = gamepad1.right_stick_y;

       // right = Range.clip(right, -1,1);
        left = Range.clip(left, -1,1);  //motor = Range.clip (motor, min, max);

        motorLeft.setPower(left);
        //motorRight.setPower(right);

    } //loop function, main code


    public void stop(){} //stop function
}
