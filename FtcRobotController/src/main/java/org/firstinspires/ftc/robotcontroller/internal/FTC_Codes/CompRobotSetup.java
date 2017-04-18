package org.firstinspires.ftc.robotcontroller.internal.FTC_Codes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by URL #1 on 2017-02-07.

*/

public class CompRobotSetup{

    DcMotor motorLeft = null; //Left Drive motor
    DcMotor motorRight = null; // Right Drive motor
    DcMotor motorIntake = null; // Intake motor
    DcMotor UptakeMotor = null; // Uptake motor
    DcMotor CatMotor = null ; // Catapult motor\

    HardwareMap hardwareMap = null;

    public void init(HardwareMap ahardwareMap){
        hardwareMap = ahardwareMap;
        motorLeft = hardwareMap.dcMotor.get("Left_Drive"); // this is telling the code where to get information on the motor i want
        motorRight = hardwareMap.dcMotor.get("Right_Drive");
        motorLeft.setDirection(DcMotor.Direction.REVERSE); // as the motor is facing a different direction it must spin the opposite way

        motorIntake = hardwareMap.dcMotor.get("Intake");//This is the front intake motor
       // motorIntake.setDirection(DcMotor.Direction.REVERSE);

        UptakeMotor = hardwareMap.dcMotor.get("Conveyor"); // this is the conveyor belt motor
        //
        // UptakeMotor.setDirection(DcMotor.Direction.REVERSE);

        CatMotor = hardwareMap.dcMotor.get("Cat");
        // CatMotor.setDirection(DcMotor.Direction.REVERSE);
    }

}

