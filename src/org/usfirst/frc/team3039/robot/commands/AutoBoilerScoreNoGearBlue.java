package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBoilerScoreNoGearBlue extends CommandGroup {

    public AutoBoilerScoreNoGearBlue() {
    	//Spins Shooter, Stages Fuel, Stops Shooter
    	addSequential(new AutoShoot(), 1);
    	addSequential(new RunAgitate(), 6);
    	addSequential(new AutoStopShoot(), .1);
       	//Backs away
    	addSequential(new ResetGyro(), .115);
    	addSequential(new DriveStraight(.5, 0, 0, 44)); //Distance to Back Away 48
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .1);
    	//Turns Left 
    	addSequential(new ResetGyro(), .115);
    	addSequential(new AutoTurnLeft(-50)); //Turning Away Angle
    	addSequential(new AutoDrive(-.3, 0, 0, 0), .1);

    	//Backs Across Tape
    	addSequential(new ResetGyro(), .115);
    	addSequential(new DriveStraight(.5, 0, 0, 46)); //Distance Across Arena
    	addSequential(new AutoDrive(-.5, 0, 0, 0), .115);
    	//Turns Right 
    	addSequential(new ResetGyro(), .115);
    	addSequential(new AutoTurnRight(45)); //Turning Toward Angle
    	
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);

    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);

    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.3, 0, 0, 20)); //Distance to Back Away 48
    	
    	//addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	
    }
}
