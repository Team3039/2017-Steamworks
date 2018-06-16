package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Receiver extends Subsystem {
	
	public Solenoid gearEjectCylinders = new Solenoid(RobotMap.gearEjectCylinders);
	
	public void releaseGear() {
		gearEjectCylinders.set(true);
	}
	
	public void closeGear() {
		gearEjectCylinders.set(false);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

