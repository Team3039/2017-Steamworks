package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.Robot;
import org.usfirst.frc.team3039.robot.RobotMap;
import org.usfirst.frc.team3039.robot.commands.TeleOpDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.team3039.util.PS4Gamepad;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	public double driveFactor;
	public double turnFactor;
	public double strafeFactor;
	
	//P Gain
	private final double Kp = -2.1;
	
	public double input = Robot.gearPosition;
	public double output;
	//Talons
	public WPI_TalonSRX rearleftMotor = new WPI_TalonSRX(RobotMap.rearleftMotor);
	public WPI_TalonSRX rearrightMotor = new WPI_TalonSRX(RobotMap.rearrightMotor);
	public WPI_TalonSRX frontrightMotor = new WPI_TalonSRX(RobotMap.frontrightMotor);
	public WPI_TalonSRX frontleftMotor = new WPI_TalonSRX(RobotMap.frontleftMotor);
    
    public MecanumDrive driveArcade = new MecanumDrive(frontleftMotor, rearleftMotor, frontrightMotor, rearrightMotor);

	public WPI_TalonSRX climbMotorA = new WPI_TalonSRX(RobotMap.climbMotorA);
	public WPI_TalonSRX climbMotorB = new WPI_TalonSRX(RobotMap.climbMotorB);	
	
	//Encoders
	public Encoder encoderLeft = new Encoder(RobotMap.encoderALeft, RobotMap.encoderBLeft, false);
	public Encoder encoderRight = new Encoder(RobotMap.encoderARight, RobotMap.encoderBRight, false);
	
	//Sensors
	public AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	public AHRS navX = new AHRS(SPI.Port.kMXP);
	public AnalogInput ultrasonic = new AnalogInput(RobotMap.ultrasonic);
	
	//VisionTracking
	public DigitalInput leftRotate = new DigitalInput(RobotMap.leftRotate);
	public DigitalInput rightRotate = new DigitalInput(RobotMap.rightRotate);

	//Drivetrain
	public void driveArcade(PS4Gamepad gp) {
		driveArcade.driveCartesian(0,gp.getLeftYAxis() * -driveFactor,  -gp.getRightXAxis()* -turnFactor, 0);
		getDriveFactor();
		getTurnFactor();
	}
	
	public void DriveStraight(double Magnitude, double Direction, double Rotation) {
		driveArcade.drivePolar(Magnitude, ((Direction-getAngle())* Kp) + 90, Rotation);
	}

	public void autoDrive(double X, double Y, double Rotation, double gyroAngle) {
		driveArcade.driveCartesian(X, Y, Rotation, getAngle());
	}
	
	public void strafeRight() {
		frontleftMotor.set(strafeFactor);
		rearleftMotor.set(-strafeFactor);
		frontrightMotor.set(strafeFactor);
		rearrightMotor.set(-strafeFactor);
	}
	
	public void strafeLeft() {
		frontrightMotor.set(-strafeFactor);
		rearrightMotor.set(strafeFactor);
		frontleftMotor.set(-strafeFactor);
		rearleftMotor.set(strafeFactor);
	}
	
	public double getDriveFactor() {
		return driveFactor = SmartDashboard.getNumber("Driving Speed", 1);
	}
	
	public double getTurnFactor() {
		return turnFactor = SmartDashboard.getNumber("Turning Speed", .65);
	}
	
	public double getStrafeFactor() {
		return strafeFactor = SmartDashboard.getNumber("Strafing Speed", .75);
	}
	
	//Use this for Feedback Driving (targetAngle-getAngle*Gain)
	
	public void rotateRight() {
		driveArcade.driveCartesian(0, 0, -.35, 0);
	}
	
	public void rotateLeft() {
		driveArcade.driveCartesian(0, 0, .35, 0);
	}

	public void autoStrafeLeft(double strafeSpeed) {
		frontrightMotor.set(-strafeSpeed);
		rearrightMotor.set(strafeSpeed);
		frontleftMotor.set(-strafeSpeed);
		rearleftMotor.set(strafeSpeed);
	}
	
	public void autoStrafeRight(double strafeSpeed) {
		frontrightMotor.set(strafeSpeed);
		rearrightMotor.set(-strafeSpeed);
		frontleftMotor.set(strafeSpeed);
		rearleftMotor.set(-strafeSpeed);
	}
	
	public void rotate(double speed) {
		frontrightMotor.set(speed);
		rearrightMotor.set(speed);
		frontleftMotor.set(speed);
		rearleftMotor.set(speed);
	}

	public void DriveBackward() {
		rearleftMotor.set(-.5); //Negitive Back
		rearrightMotor.set(.5); //Positive Back
		frontrightMotor.set(-.5); //Negitive Back
		frontleftMotor.set(.5); //Postive Back
	}
	
	public void DriveForward() {
		rearleftMotor.set(.5); //Negitive Back
		rearrightMotor.set(-.5); //Positive Back
		frontrightMotor.set(.5); //Negitive Back
		frontleftMotor.set(-.5); //Postive Back
	}
	
	public void stopDriving() {
		driveArcade.stopMotor();
	}
	
    //Sensors
	public void resetGyro() {
		navX.reset();
		navX.resetDisplacement();
	}
	
	public double getAngle() {
		return navX.getYaw();
	}
	
	public void resetEncoder() {
		encoderLeft.reset();
		encoderRight.reset();
	}


	/**1440 pulses is one rotation
	 * 1 Rotation of a 6'' wheel is 18.85''
	 * 18.85'' is a little over 18 and 7/8 in
	 * For every 1440 pulses the Robot should move 18.85''
	 * For every 76.39 pulses the Robot should move 1''
	 * For every 1 Pulse the Robot should move 0.0130902777778''
	 * Our mecanum wheel has a circumference of  19'' making our DPP 0.0131944444444'' 
	**/
	
	public void setDistancePerPulse() {
		encoderLeft.setDistancePerPulse(0.0542416666666667);
		encoderRight.setDistancePerPulse(0.0542416666666667);
	}
	
	public double getLeftDistance() {
		return encoderLeft.getDistance();
	}
	
	public double getRightDistance() {
		return encoderRight.getDistance();
	}

	//Climber
	public void Climb() {
		climbMotorA.set(-.95);
		climbMotorB.set(-.95);
	}
	
	public void stopClimb() {
		climbMotorA.set(0);
		climbMotorB.set(0);
	}
	
	public void slowClimb() {
		climbMotorA.set(-.45);
		climbMotorB.set(-.45);
	}
	
	public void initDefaultCommand() {
        setDefaultCommand(new TeleOpDrive());
    }
}

