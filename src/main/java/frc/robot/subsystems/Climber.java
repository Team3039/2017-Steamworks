/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  public TalonSRX climbA = new TalonSRX(RobotMap.climbMotorA);
  public TalonSRX climbB = new TalonSRX(RobotMap.climbMotorB);

  public void climb () {
    climbA.set(ControlMode.PercentOutput, -.8);
    climbB.follow(climbA);
  }
 public void stopClimb () {
   climbA.set(ControlMode.PercentOutput, 0);
   climbB.follow(climbA);
  }
 

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
