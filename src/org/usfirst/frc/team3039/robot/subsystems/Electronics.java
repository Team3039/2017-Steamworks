package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Electronics extends Subsystem {
				
		public DigitalOutput cameraRelay = new DigitalOutput(RobotMap.camerarelay);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

			public void relayOn() {
				cameraRelay.set(true);
			}
			
			public void relayOff() {
				cameraRelay.set(false);
			}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

