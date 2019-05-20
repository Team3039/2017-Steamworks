/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 //HID Ports
 public static final int HID_Controller = 0;
 public static final int HID_Copilot = 1;
 
 //PWM Ports
 public static int rightServo = 0;
 public static int leftServo = 1;
 public static int blockServo = 2;
 
//CAN Ports
public static int shootMotor = 8;

 public static int pickupMotor = 6;

public static int rearleftMotor = 4;
public static int rearrightMotor = 9;
public static int frontleftMotor = 0;
public static int frontrightMotor = 5;
 
public static int agitatorMotor = 2;
 public static int stagingMotor = 7;

 public static int climbMotorA = 1;
public static int climbMotorB = 3;
 
 //AIO Ports
public static int gyro = 0;
public static int ultrasonic = 1;

//DIO Ports
public static int camerarelay = 0;
public static int gearSwitch = 1; 
public static int encoderALeft = 2;
public static int encoderBLeft = 3;
public static int encoderARight = 4;
public static int encoderBRight = 5;
public static int leftRotate = 8;//Arduino Left 3
public static int rightRotate = 9;//Arduino Right 5

//Solenoid Ports
public static int gearEjectCylinders = 0;
public static int gearPickupCylinders = 1;
//public static int gearPickupBCylinders = 2;

//public static int encoderPIDLeftA = 6;
//public static int encoderPIDLeftB = 7;
//public static int encoderPIDRightA = 8;
//public static int encoderPIDRightB = 9;
 
// For example to map the left and right motors, you could define the
 // following variables to use with your drivetrain subsystem.
 // public static int leftMotor = 1;
 // public static int rightMotor = 2;
 
 // If you are using multiple modules, make sure to define both the port
 // number and the module. For example you with a rangefinder:
 // public static int rangefinderPort = 1;
// public static int rangefinderModule = 1;
}
