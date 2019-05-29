/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.controllers.PS4Gamepad;
import frc.robot.RobotMap;
import frc.robot.commands.TeleOpDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  public TalonSRX leftFrontDrive = new TalonSRX(RobotMap.frontleftMotor);
  public TalonSRX rightFrontDrive = new TalonSRX(RobotMap.frontrightMotor);
  public TalonSRX leftRearDrive = new TalonSRX(RobotMap.rearleftMotor);
  public TalonSRX rightRearDrive = new TalonSRX(RobotMap.rearrightMotor);

  public void joystickControl(PS4Gamepad gp) {
    //Tele-Op Driving
    //Each Motor is Set to Brake Mode, the motor speeds are set in an Arcade Drive fashion
    double y = gp.getLeftYAxis()*-.9;
    double rot = gp.getRightXAxis()*.8;

    //Calculated Outputs (Limits Output to 12V)
    double leftOutput = y + rot;
    double rightOutput = rot - y;


    //Set Motor's Neutral/Idle Mode to Brake
    leftFrontDrive.setNeutralMode(NeutralMode.Brake);
    rightFrontDrive.setNeutralMode(NeutralMode.Brake);
    leftRearDrive.setNeutralMode(NeutralMode.Brake);
    rightRearDrive.setNeutralMode(NeutralMode.Brake); 

    //Assigns Each Motor's Power
    leftFrontDrive.set(ControlMode.PercentOutput, leftOutput);
    rightFrontDrive.set(ControlMode.PercentOutput, rightOutput);
    leftRearDrive.follow(leftFrontDrive);
    rightRearDrive.follow(rightFrontDrive);


  }

  public void strafeRight() {
    leftFrontDrive.set(ControlMode.PercentOutput, .9);
    leftRearDrive.set(ControlMode.PercentOutput, -.9);
    rightFrontDrive.set(ControlMode.PercentOutput, .9);
    rightRearDrive.set(ControlMode.PercentOutput, -.9);
  }
  
  public void strafeLeft() {
    rightFrontDrive.set(ControlMode.PercentOutput, -0.9);
    rightRearDrive.set(ControlMode.PercentOutput, 0.9);
    leftFrontDrive.set(ControlMode.PercentOutput, -0.9);
    leftRearDrive.set(ControlMode.PercentOutput, 0.9);
}

  public void stopDrive()  {
    leftFrontDrive.set(ControlMode.PercentOutput, 0);
    rightFrontDrive.set(ControlMode.PercentOutput, 0);
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleOpDrive());
    
  }
}
