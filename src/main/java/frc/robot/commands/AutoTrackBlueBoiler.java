package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTrackBlueBoiler extends CommandGroup {

    public AutoTrackBlueBoiler() {
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .115);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.55, 0, 0, 86)); //Distance to Turning Point 86
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .115);
    	//Turns Right
    	addSequential(new AutoTurnRight(50)); //Turning Angle
    	addSequential(new AutoDrive(0, 0, 0, 0), .115);
    	//Tracking Sequence
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	addSequential(new AutoDrive(0, 0, 0, 0), .115);
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	addSequential(new AutoDrive(0, 0, 0, 0), .115);
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	addSequential(new AutoDrive(0, 0, 0, 0), .115);
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	//Drive to Delivery Point
    	addSequential(new ResetGyro(), .5);
    	addSequential(new DriveStraight(.35, 0, 0, 11.5)); //Distance to Gear Delivery 15
    	//Delivers Gear
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	addSequential(new AutoGearOpen(), 1.5);
    	//Backs Off and Closes Gear
    	addParallel(new EncoderDriveLeft(-.55, 0, 0, 0, 58)); //Distance to Back Away
    	addParallel(new EncoderDriveRight(-.55, 0, 0, 0, 58));
    	addSequential(new AutoGearClose(), .5);
    	
    	addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
		addSequential(new AutoShoot(), .1);
    	//Shoot
    	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    	addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
		addSequential(new AutoDrive(0, 0, 0, 0), 1.5);
    	addSequential(new RunAgitate());
    	  	 
    }
}