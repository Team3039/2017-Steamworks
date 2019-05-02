package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.commands.CameraRelay;
import frc.robot.commands.RunAgitate;
import frc.robot.commands.RunClimber;
import frc.robot.commands.RunCollectorReset;
import frc.robot.commands.RunGear;
import frc.robot.commands.RunGearCollectNoBeam;
import frc.robot.commands.RunGearCollection;
import frc.robot.commands.RunGearPlaceNoBeam;
import frc.robot.commands.RunGearPlacement;
import frc.robot.commands.RunPickup;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunSlowClimb;
import frc.robot.commands.RunStrafeLeft;
import frc.robot.commands.RunStrafeRight;
import frc.util.PS4Copad;
import frc.util.PS4Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joysticks.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	private PS4Gamepad gp = new PS4Gamepad(RobotMap.HID_Controller);
	private PS4Copad cp = new PS4Copad(RobotMap.HID_Copilot);

	//Allows the Pilot Access to His Controls
	
	//PS4 Buttons
	Button ButtonX = gp.getButtonX();
	Button ButtonCircle = gp.getButtonCircle();
	Button ButtonTriangle = gp.getButtonTriangle();
	Button ButtonSquare = gp.getButtonSquare();
	Button ButtonOptions = gp.getOptionsButton();
	Button ButtonStart = gp.getStartButton();
	Button ButtonShare = gp.getShareButton();
	Button ButtonR1 = gp.getR1();
	Button ButtonL1 = gp.getL1();
	Button ButtonR2 = gp.getR2();
	Button ButtonL2 = gp.getL2();
	
	Button ButtonLT = gp.getLT();
	Button ButtonRT = gp.getRT();
	
	//XBOX Buttons
	Button ButtonXX = gp.getButtonXX();
	Button ButtonY = gp.getButtonY();
	Button ButtonB = gp.getButtonB();
	Button ButtonA = gp.getButtonA();
	Button ButtonLB = gp.getLB();
	Button ButtonRB = gp.getRB();
	
	
	Button ButtonL3 = gp.getL3();
	Button ButtonR3 = gp.getR3();
	
	Button ButtonPad = gp.getButtonPad();

	//Allows the coPilot Access to His Controls 
	Button cpButtonX = cp.getButtonX();
	Button cpButtonCircle = cp.getButtonCircle();
	Button cpButtonTriangle = cp.getButtonTriangle();
	Button cpButtonSquare = cp.getButtonSquare();
	Button cpButtonOptions = cp.getOptionsButton();
	Button cpButtonR1 = cp.getR1();
    Button cpButtonL1 = cp.getL1();
	Button cpButtonR2 = cp.getR2();
	Button cpButtonL2 = cp.getL2();
	Button cpButtonPad = cp.getButtonPad();
	
	
	
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public OI() {
		//Pilot Controls
		ButtonPad.toggleWhenPressed(new CameraRelay());
		ButtonB.whileHeld(new RunAgitate());
		ButtonL2.whileHeld(new RunStrafeRight());
		ButtonR2.whileHeld(new RunStrafeLeft());
		ButtonSquare.whenPressed(new RunGearCollection());
		ButtonTriangle.whenPressed(new RunCollectorReset());
		ButtonCircle.toggleWhenPressed(new RunShooter());

		ButtonL1.whileHeld(new RunGearCollectNoBeam());
		ButtonShare.whileHeld(new RunGearPlaceNoBeam());
		
		
		ButtonR1.whileHeld(new RunClimber());
		ButtonStart.toggleWhenPressed(new RunShooter());
		ButtonOptions.whileHeld(new RunGear());
		
/*		ButtonXX.toggleWhenPressed(new RunShooter());
		ButtonY.whileHeld(new RunGear());
		ButtonA.whileHeld(new RunAgitate());
		ButtonB.whileHeld(new RunClimber());
		ButtonRB.whileHeld(new RunStrafeRight());
		ButtonLB.whileHeld(new RunStrafeLeft());
		
*/
		
		//CoPilot Controls
		cpButtonPad.toggleWhenPressed(new CameraRelay());
		cpButtonCircle.toggleWhenPressed(new RunShooter());
		cpButtonR1.whileHeld(new RunAgitate());
		cpButtonSquare.whileHeld(new RunGear());
		cpButtonX.toggleWhenPressed(new RunPickup());
		cpButtonL2.whileHeld(new RunSlowClimb());
		cpButtonR2.whileHeld(new RunClimber());
		cpButtonTriangle.whenPressed(new RunGearPlacement());
	}

	public PS4Gamepad getGamepad() {
		return gp;

	}

	
}

