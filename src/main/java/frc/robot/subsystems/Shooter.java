package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 *
 */

public class Shooter extends Subsystem {
	
	public WPI_TalonSRX agitatorMotor = new WPI_TalonSRX(RobotMap.agitatorMotor);
	public WPI_TalonSRX stagingMotor = new WPI_TalonSRX(RobotMap.stagingMotor);
	public Servo blockServo = new Servo(RobotMap.blockServo);
	public WPI_TalonSRX shootMotor = new WPI_TalonSRX(RobotMap.shootMotor);
		
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void shoot() {
		shootMotor.set(.65);
	}
	
	public void stopShoot() {
		shootMotor.set(0);
	}
	public void Agitate() {
		agitatorMotor.set(-.4);
	}

	public void StopAgitate() {
		agitatorMotor.set(0);
	}
	
	public void StageFuel() {
		stagingMotor.set(.6);
	}
	
	public void StopStageFuel() {
		stagingMotor.set(0);
	}
		
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

