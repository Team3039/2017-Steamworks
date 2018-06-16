package org.usfirst.frc.team3039.robot.commands;

import org.usfirst.frc.team3039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
double Magnitude;
double Direction;
double Rotation;
double targetDistance;
    public DriveStraight(double Magnitude, double Direction, double Rotation, double targetDistance) {
    	this.Magnitude = Magnitude;
    	this.Direction = Direction;
    	this.Rotation = Rotation;
    	this.targetDistance = targetDistance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoder();
    	Robot.drivetrain.setDistancePerPulse();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.DriveStraight(Magnitude, Direction, Rotation);
    	System.out.println("Encoder Value " + Robot.drivetrain.getRightDistance());
    	System.out.println("Gyro Value " + Robot.drivetrain.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (targetDistance <= Math.abs(Robot.drivetrain.getRightDistance()));    }

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
