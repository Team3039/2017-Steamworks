package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBoilerScoreNoGearRed extends CommandGroup {

    public AutoBoilerScoreNoGearRed() {
    	//Spins Shooter, Stages Fuel, Stops Shooter
    	addSequential(new AutoShoot(), .5);
    	addSequential(new RunAgitate(), 9.5);
    	addSequential(new AutoStopShoot(), .125);
       	//Backs away
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.5, 0, 0, 35)); //Distance to Back Away 48
    	addSequential(new AutoDrive(-.5, 0, 0, 0), .125);
    	//Turns Left 
    	addSequential(new ResetGyro(), .125);
    	addSequential(new AutoTurnRight(60)); //Turning Away Angle

    	//Backs Across Tape
    	addSequential(new ResetGyro(), .125);
    	addSequential(new DriveStraight(.5, 0, 0, 59)); //Distance Across Arena
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	//Turns Right 
    	addSequential(new ResetGyro(), .125);
    	addSequential(new AutoTurnLeft(-45)); //Turning Toward Angle
    	
    	addSequential(new AutoDrive(0, 0, 0, 0), 1);

    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);

    	addSequential(new ResetGyro(), .25);
    	addSequential(new DriveStraight(.4, 0, 0, 24)); //Distance to Back Away 48
    	

    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	
    }
}
