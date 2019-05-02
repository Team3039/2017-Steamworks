package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoNoTrackCenter extends CommandGroup {

    public AutoNoTrackCenter() {
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 67)); 
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunForward(), 1.25);
    	addSequential(new RunBackward(), .125);
    	addParallel(new AutoGearClose(), .125);
    }
}
