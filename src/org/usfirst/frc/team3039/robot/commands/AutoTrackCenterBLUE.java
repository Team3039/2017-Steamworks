package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTrackCenterBLUE extends CommandGroup {

    public AutoTrackCenterBLUE() {
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Track Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.45, 0, 0, 57.5)); 
    	addSequential(new AutoDrive(-.5, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 10)); 
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addParallel(new EncoderDriveLeft(-.55, 0, 0, 0, 40)); //Distance to Back Away
    	addParallel(new EncoderDriveRight(-.55, 0, 0, 0, 40));
    	addSequential(new AutoShoot(), .125);
    	//Turns to boiler 
    	addSequential(new AutoTurnRight(90)); //Turning Angle
    	addSequential(new ResetGyro(), .1);
    	addParallel(new EncoderDriveLeft(-.6, 0, 0, 0, 51)); //Distance to Back Away
    	addParallel(new EncoderDriveRight(-.6, 0, 0, 0, 51));
    	addSequential(new ResetGyro(), .25);
    	addSequential(new AutoTurnLeft(-25)); //Turning Angle
    	addParallel(new AutoGearClose(), .5);
    	
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);

    	addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
		addSequential(new AutoDrive(0, 0, 0, 0), .25);
		
    	//Shoot
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
		addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	addSequential(new RunAgitate());
    	  	 
	
    }
}
