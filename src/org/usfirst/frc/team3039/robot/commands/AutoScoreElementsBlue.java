package org.usfirst.frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScoreElementsBlue extends CommandGroup {

    public AutoScoreElementsBlue() {
    	//Boiler Blue
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.55, 0, 0, 82)); //was 87
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Turns Right
    	addSequential(new AutoTurnRight(45));
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	//Drive Forward
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.55, 0, 0, 9)); //was 9
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunTrackingForward());
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
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
