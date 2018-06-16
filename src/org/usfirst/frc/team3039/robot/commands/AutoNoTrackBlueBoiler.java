package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoNoTrackBlueBoiler extends CommandGroup {

    public AutoNoTrackBlueBoiler() {
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 87)); //was 87
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Turns Right
    	addSequential(new AutoTurnRight(45));
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	//Drive Forward
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 7.5)); //was 9
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunTrackingForward(), 1.25);
    	addSequential(new RunTrackingBackward(), .125);
    	addSequential(new AutoGearClose(), .125);
    	//Strafes into Poistion
    	addSequential(new AutoStrafeLeft(.6), 1);
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	addSequential(new AutoShoot(), .125);
		//Vision Sequence
    	addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
		addParallel(new RunTrackingRightBoiler());
		addParallel(new RunTrackingLeftBoiler());
    	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    	//Agitation Sequence
    	addSequential(new RunAgitate());
    }
}
