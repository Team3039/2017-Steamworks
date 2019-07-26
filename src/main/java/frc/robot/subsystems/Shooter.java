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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  public TalonSRX shooter = new TalonSRX(RobotMap.shootMotor);
  public TalonSRX ballStager = new TalonSRX (RobotMap.stagingMotor);
  public TalonSRX ballDial = new TalonSRX (RobotMap.agitatorMotor);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.public 
  
  public void startShooter () {
    shooter.configOpenloopRamp(1);
    shooter.set(ControlMode.PercentOutput, .9);
    shooter.setNeutralMode(NeutralMode.Coast);
  }

  public void startStaging() {
    ballStager.set(ControlMode.PercentOutput, .85);
  } 
  public void startDial (){ 
    ballDial.set(ControlMode.PercentOutput, -.70);
   }

   public void stopShooter() {
     shooter.set(ControlMode.PercentOutput, 0);
   }

  public void stopStaging () {
    ballStager.set(ControlMode.PercentOutput, 0);
  }
   public void stopDial (){  
    ballDial.set(ControlMode.PercentOutput, 0); }
    

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }
}
