package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTrackRedHopper extends CommandGroup {

    public AutoTrackRedHopper() {
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .5);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.37, 0, 0, 85)); //Distance to Turning Point
    	addSequential(new AutoDrive(-.37, 0, 0, 0), .115);
    	//Turns Left
    	addSequential(new AutoTurnRight(50)); //Turning Angle
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .115);
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
    	//Drives to Delivery Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.35, 0, 0, 19)); //Distance to Gear Delivery
    	//Delivers Gear
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	addSequential(new AutoGearOpen(), 1);
    	//Backs Off and Closes Gear
    	addParallel(new EncoderDriveLeft(-.3, 0, 0, 0, 42)); //Distance to Back Away
    	addParallel(new EncoderDriveRight(-.3, 0, 0, 0, 42));
    	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    	addSequential(new AutoGearClose(), .5);
    	
    	addSequential(new ResetGyro(), .1);
    	addSequential(new AutoTurnLeft(-50));
    	
    	addSequential(new RunBackward(), 4);
    }
}