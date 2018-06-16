 package org.usfirst.frc.team3039.robot.commands;

import org.usfirst.frc.team3039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDriveLeft extends Command {
	double X;
	double Y;
	double Rotation;
	double gyroAngle;
	double targetDistance;
    public EncoderDriveLeft(double X, double Y, double Rotation, double gyroAngle, double targetDistance) {
    	this.X = X;
    	this.Y = Y;
    	this.Rotation = Rotation;
    	this.gyroAngle = gyroAngle;
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
    	Robot.drivetrain.autoDrive(X, Y, Rotation, gyroAngle);
    	System.out.println("Left Value is " + Robot.drivetrain.encoderRight.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (targetDistance <= Math.abs(Robot.drivetrain.getRightDistance()));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.frontleftMotor.set(0);
    	Robot.drivetrain.rearleftMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.frontleftMotor.set(0);
    	Robot.drivetrain.rearleftMotor.set(0);    }
}
