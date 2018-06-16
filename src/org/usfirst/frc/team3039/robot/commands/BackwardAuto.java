package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BackwardAuto extends CommandGroup {

    public BackwardAuto() {
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	
    	addSequential(new DriveStraight(-.4, 0, 0, 90)); //was 87
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Turns Right
    	addSequential(new AutoTurnRight(45));
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	/**
    	//Drive Forward
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 14)); //was 9
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	/**
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunForward(), 1.25);
    	addSequential(new RunBackward(), .125);
    	addSequential(new AutoGearClose(), .125);
    	**/
    }
}
