package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class AutoTurnRight extends Command {
double targetAngle;
    public AutoTurnRight(double targetAngle) {
    	this.targetAngle = targetAngle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.frontrightMotor.set(.43); //on .35 turn 10 degrees less than target
    	Robot.drivetrain.rearrightMotor.set(.43);
    	Robot.drivetrain.frontleftMotor.set(.43);
    	Robot.drivetrain.rearleftMotor.set(.43);
    	System.out.println("Gyro" + Robot.drivetrain.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (targetAngle <= (Robot.drivetrain.getAngle()));
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
