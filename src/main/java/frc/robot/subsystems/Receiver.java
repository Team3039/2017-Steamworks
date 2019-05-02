package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

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

