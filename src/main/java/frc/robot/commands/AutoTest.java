package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	
//    	addParallel(new RunTrackingForward());
//    	addParallel(new RunTrackingBackward());
    	/**Driving Sequence
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(positiveSpeed, 0, 0, targetDistance));
    	addSequential(new AutoDrive(negativeSpeed, 0, 0, 0), .125);
    	**/   	
	 
    	/** Boiler Blue
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
    	addSequential(new DriveStraight(.4, 0, 0, 9)); //was 9
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
    	addParallel(new RunTrackingRight());
		addParallel(new RunTrackingLeft());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
		addParallel(new RunTrackingRight());
		addParallel(new RunTrackingLeft());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
		addParallel(new RunTrackingRight());
		addParallel(new RunTrackingLeft());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
		addParallel(new RunTrackingRight());
		addParallel(new RunTrackingLeft());
    	addSequential(new AutoDrive(0, 0, 0, 0), 1);
    	//Agitation Sequence
    	addSequential(new RunAgitate());
    	**/
    	
    	/** Center
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 67)); 
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunTrackingForward(), 1.25);
    	addSequential(new RunTrackingBackward(), .125);
    	addParallel(new AutoGearClose(), .125);
    	**/
    	
    	/**Hopper Blue
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 80)); //was 87
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Turns Right
    	addSequential(new AutoTurnLeft(-45));
    	addSequential(new AutoDrive(0, 0, 0, 0), .25);
    	//Drive Forward
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 14)); //was 9
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunForward(), 1.25);
    	addSequential(new RunBackward(), .125);
    	addSequential(new AutoGearClose(), .125);
    	**/
    	
    	/**Center Track
    	//Closes Gear in Place
    	//Closes Gear in Place
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 46)); 
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .5);
    	
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	
    	addSequential(new ResetGyro(), .1);
    	addSequential(new UltrasonicDrive(12)); 
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunForward(), 1.25);
    	addSequential(new RunBackward(), .125);
    	addParallel(new AutoGearClose(), .125);
    	**/
    	
    	/** Boiler Track
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 87)); //was 87
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Turns Right
    	addSequential(new AutoTurnRight(45));
    	addSequential(new AutoDrive(0, 0, 0, 0), .5);
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());

    	//Drive Forward
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 9)); //was 9
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunForward(), 1.25);
    	addSequential(new RunBackward(1), .125);
    	addSequential(new AutoGearClose(), .125);
    	**/
    	
    	/** Hopper Track
    	//Closes Gear in Place
    	addSequential(new AutoGearClose(), .1);
    	//Drives until Turn Point
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 80)); //was 87
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Turns Right
    	addSequential(new AutoTurnLeft(-45));
    	addSequential(new AutoDrive(0, 0, 0, 0), .5);
    	
    	addParallel(new RunTrackingLeftGear());
    	addParallel(new RunTrackingRightGear());
    	//Drive Forward
    	addSequential(new ResetGyro(), .1);
    	addSequential(new DriveStraight(.4, 0, 0, 16.5)); //was 9
    	addSequential(new AutoDrive(-.4, 0, 0, 0), .125);
    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
    	//Delivers Gear
    	addSequential(new AutoGearOpen(), .25);
    	//Backs Off and Closes
    	addSequential(new RunForward(), 1.25);
    	addSequential(new RunBackward(), .125);
    	addSequential(new AutoGearClose(), .125);
    	**/
    	//addSequential(new UltrasonicDrive(12));
    	
//    	addParallel(new RunTrackingLeftGear());
//    	addParallel(new RunTrackingRightGear()); 
    	
//    	addParallel(new RunTrackingForward());
//     	addParallel(new RunTrackingBackward());
//    	addSequential(new AutoDrive(-.2, 0, 0, 0), .1);
//
//     	//Vision Sequence
//		addSequential(new AutoShoot(), .125);
//    	addParallel(new RunTrackingRightBoiler());
//		addParallel(new RunTrackingLeftBoiler());
//    	addSequential(new AutoDrive(0, 0, 0, 0), .125);
//		addParallel(new RunTrackingRightBoiler());
//		addParallel(new RunTrackingLeftBoiler());
//    	
//    	//Agitation Sequence
//    	addSequential(new AutoDrive(0, 0, 0, 0), 2);
//
//    	addSequential(new RunAgitate(), 10);
//   	
    	}
}
