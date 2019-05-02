package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class AutoDrive extends Command {
	double X;
	double Y;
	double Rotation;
	double targetAngle;
	public AutoDrive(double X, double Y, double Rotation, double targetAngle) {
		this.X = X;
		this.Y = Y;
		this.Rotation = Rotation;
		this.targetAngle = targetAngle;
	}


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.autoDrive(X, Y, Rotation, targetAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
