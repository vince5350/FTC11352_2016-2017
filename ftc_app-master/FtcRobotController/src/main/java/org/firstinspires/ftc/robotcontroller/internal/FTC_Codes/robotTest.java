package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by URL #1 on 2017-02-11.
 */
//@TeleOp(name="RoboTest", group="Pushbot") // this registers it so you can you it on the FTC apps on the phone
public class robotTest extends OpMode{

    CompRobotSetup robot = new CompRobotSetup();
    float leftStick;
    float rightStick;
    float leftPower;
    float rightPower;


    @Override
    public void init() {

    }

    @Override
    public void loop() {

        leftStick = gamepad1.left_stick_y;
        rightStick = gamepad1.right_stick_y;

        leftPower = Range.clip(leftStick,-1,1);
        rightPower = Range.clip(rightStick,-1,1);

        robot.motorLeft.setPower(leftPower);
        robot.motorRight.setPower(rightPower);

    }
}
