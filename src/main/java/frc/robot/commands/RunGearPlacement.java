package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class RunGearPlacement extends Command {

    public RunGearPlacement() {
    	requires(Robot.collector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.getGearStatus();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.ejectElement();
    	Robot.collector.getGearStatus();
    	Robot.collector.retriveGearState();


    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.collector.getGearStatus()) == true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stopElement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.collector.stopElement();
    }
}
