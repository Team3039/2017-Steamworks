package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTrackSequence extends CommandGroup {

    public AutoTrackSequence() {
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 0), 1.9);
    	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    	addSequential(new AutoTurnLeft(-50));

    		System.err.println("If Autotracking");
    		addParallel(new RunTrackingRightBoiler());
    		addParallel(new RunTrackingLeftBoiler());
        	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    		addParallel(new RunTrackingRightBoiler());
    		addParallel(new RunTrackingLeftBoiler());
        	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    		addParallel(new RunTrackingRightBoiler());
    		addParallel(new RunTrackingLeftBoiler());
        	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    		addParallel(new RunTrackingRightBoiler());
    		addParallel(new RunTrackingLeftBoiler());


//    	if(Robot.getAxisLeft() | Robot.getAxisRight()){
//    		
//    	}
    	System.err.println("Outside of if");

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
