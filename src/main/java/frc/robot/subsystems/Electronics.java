package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

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

