package org.usfirst.frc.team3039.robot.commands;

import org.usfirst.frc.team3039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunTrackingRightBoiler extends Command {

    public RunTrackingRightBoiler() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Rotates Right while Pixy is too far Left
    	Robot.drivetrain.frontrightMotor.set(.25);
    	Robot.drivetrain.rearrightMotor.set(.25);
    	Robot.drivetrain.frontleftMotor.set(.25);
    	Robot.drivetrain.rearleftMotor.set(.25);    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (false ==  Robot.boilerRight);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stopDriving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stopDriving();
    }
}
