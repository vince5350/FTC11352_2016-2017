package org.firstinspires.ftc.robotcontroller.internal.Bored;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by URL #1 on 2017-04-04.
 */


@TeleOp(name = "Forza Drive")
public class Forza_Drive extends OpMode {

    public Forza_Drive(){

    }

    DcMotor FRight;
    DcMotor FLeft;
    //DcMotor RRight; // I commented these out because I do not know if i want 4 wheel drive or 2
    //DcMotor RLeft;

    double Left, Right, BLeft, BRight;
    boolean forward, Backward;

    public void init(){

        FRight = hardwareMap.dcMotor.get("Front Right");
        FLeft = hardwareMap.dcMotor.get("Front Left");
        //RRight = hardwareMap.dcMotor.get("Back Right");
        //RLeft = hardwareMap.dcMotor.get("Back Left");

    }

    public void loop(){


        forward = gamepad1.right_bumper;
        Backward = gamepad1.left_bumper;

        if (forward == true){

            FRight.setPower(1);
            FLeft.setPower(1);
            //RRight.setPower(1);
            //RLeft.setPower(1);

        }

        if (Backward == true){

            FRight.setPower(-1);
            FLeft.setPower(-1);
            //RRight.setPower(-1);
            //RLeft.setPower(-1);
        }
    }

    public void stop(){

    }
}
