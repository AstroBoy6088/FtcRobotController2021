package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

    @Autonomous(name="WarehouseRed", group="Autonomous")
//@Disabled

    public class WarehouseRed extends LinearOpMode {
        private ElapsedTime runtime = new ElapsedTime();
        private DcMotor lf = null;  //left front wheel
        private DcMotor rf = null;  //right front wheel
        private DcMotor lb = null;  //left back wheel
        private DcMotor rb = null;  //right back wheel
        private DcMotor tower1 = null; //arm motor 1
        private DcMotor tower2 = null; //arm motor 2
        private Servo clawservo = null; //clawservo
        private DcMotor duckspinnerL = null; // the duck spinny thingy
        private DcMotor duckspinnerR = null; // the other duck spinny thingy




        @Override
        public void runOpMode() {
            telemetry.addData("Status", "Ready to run");
            telemetry.update();

            lf = hardwareMap.get(DcMotor.class, "lf");
            rf = hardwareMap.get(DcMotor.class, "rf");
            lb = hardwareMap.get(DcMotor.class, "lb");
            rb = hardwareMap.get(DcMotor.class, "rb");
            tower1 = hardwareMap.get(DcMotor.class, "tower1");
            tower2 = hardwareMap.get(DcMotor.class, "tower2");
            clawservo = hardwareMap.get(Servo.class,"clawservo");
            duckspinnerL = hardwareMap.get(DcMotor.class, "duckspinnerL");
            duckspinnerR = hardwareMap.get(DcMotor.class, "duckspinnerR");

            double sidemult = 1.0; // Red = 1.0 Blue = -1.0

            lf.setDirection(DcMotor.Direction.FORWARD);
            rf.setDirection(DcMotor.Direction.REVERSE);
            lb.setDirection(DcMotor.Direction.FORWARD);
            rb.setDirection(DcMotor.Direction.REVERSE);
            tower1.setDirection(DcMotor.Direction.FORWARD);
            tower2.setDirection(DcMotor.Direction.FORWARD);
            duckspinnerL.setDirection(DcMotor.Direction.FORWARD);
            duckspinnerR.setDirection(DcMotor.Direction.FORWARD);

            waitForStart();
            runtime.reset();



            while (opModeIsActive() && (runtime.seconds() < 30.0)) {


                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(0.5);
                rf.setPower(0.5);
                lb.setPower(0.5);
                rb.setPower(0.5);
                clawservo.setPosition(0.0);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(400); //Go forwards to side of goal


                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(-0.5 * sidemult);
                rf.setPower(0.5 * sidemult);
                lb.setPower(-0.5 * sidemult);
                rb.setPower(0.5 * sidemult);
                clawservo.setPosition(0.0);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(1000); //Turn left 90 to face goal

                //tower1.setPower(0);
                //tower2.setPower(0);
                //lf.setPower(0.5);
                //rf.setPower(0.5);
                //lb.setPower(0.5);
                //rb.setPower(0.5);
                //clawservo.setPosition(0.75);
                //duckspinnerL.setPower(0);
                //duckspinnerR.setPower(0);
                //sleep(250); //Go forwards to goal

                tower1.setPower(0.5);
                tower2.setPower(0.5);
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                clawservo.setPosition(0.0);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(1000); //Lower arm

                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                clawservo.setPosition(0.75);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(500); //Open claw

                tower1.setPower(-0.5);
                tower2.setPower(-0.5);
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                clawservo.setPosition(0.0);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(1000); //Raise arm and close claw

                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(-0.5);
                rf.setPower(-0.5);
                lb.setPower(-0.5);
                rb.setPower(-0.5);
                clawservo.setPosition(0.75);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(500); //Go backwards

                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(-0.5 * sidemult);
                rf.setPower(0.5 * sidemult);
                lb.setPower(-0.5 * sidemult);
                rb.setPower(0.5 * sidemult);
                clawservo.setPosition(0.75);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(400); //Turn left 90

                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(-0.5);
                rf.setPower(-0.5);
                lb.setPower(-0.5);
                rb.setPower(-0.5);
                clawservo.setPosition(0.75);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(1000); //Go forwards

                //tower1.setPower(0);
                //tower2.setPower(0);
                //lf.setPower(-0.5 * sidemult);
                //rf.setPower(0.5 * sidemult);
                //lb.setPower(-0.5 * sidemult);
                //rb.setPower(0.5 * sidemult);
                //clawservo.setPosition(0.75);
                //duckspinnerL.setPower(0);
                //duckspinnerR.setPower(0);
                //sleep(250); //Turn left

                //tower1.setPower(0);
                //tower2.setPower(0);
                //lf.setPower(0.5);
                //rf.setPower(0.5);
                //lb.setPower(0.5);
                //rb.setPower(0.5);
                //clawservo.setPosition(0.75);
                //duckspinnerL.setPower(0);
                //duckspinnerR.setPower(0);
                //sleep(250); //Go forwards

                tower1.setPower(0);
                tower2.setPower(0);
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                clawservo.setPosition(0.75);
                duckspinnerL.setPower(0);
                duckspinnerR.setPower(0);
                sleep(25000); //Do nothing
            }
        }
}
