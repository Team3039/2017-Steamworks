package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class RunGearCollection extends Command {

    public RunGearCollection() {
    	requires(Robot.collector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.retriveGearState();
    	Robot.collector.getGearStatus();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.getElement();
    	Robot.collector.getGearStatus();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.collector.getGearStatus()) == false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.ejectGearState();
    	Robot.collector.stopElement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.collector.ejectGearState();
    	Robot.collector.stopElement();
    }
}
