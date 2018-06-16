package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
		
	public WPI_TalonSRX pickupMotor = new WPI_TalonSRX(RobotMap.pickupMotor);

	public Solenoid gearPickupCylinders = new Solenoid(RobotMap.gearPickupCylinders);
	//public Solenoid gearPickupBCylinders = new Solenoid(RobotMap.gearPickupBCylinders);
	
	public DigitalInput gearSwitch = new DigitalInput(RobotMap.gearSwitch);
	
	public void getElement() {
		pickupMotor.set(.7);
	}
	
	public void stopElement() {
		pickupMotor.set(0);
	}
	
	public void	ejectElement() {
		pickupMotor.set(-.7);
	}
	
	public void retriveGearState() {
		gearPickupCylinders.set(true);
		//gearPickupBCylinders.set(true);
	}
	
	/*
	public void retriveFuelState() {
		gearPickupACylinders.set(true);
		gearPickupBCylinders.set(false);
		
	}
	*/
	
	public void ejectGearState() {
		gearPickupCylinders.set(false);
		//gearPickupBCylinders.set(false);
	}

	public boolean getGearStatus() {
		return gearSwitch.get();
	}
	
	public void printGearStatus() {
		System.out.println("Gear Status " + gearSwitch.get());
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

