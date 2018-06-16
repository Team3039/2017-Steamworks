package com.team3039.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Contains functions for use with the Logitech F310 controller.
 *
 *
 *		Credit to these awesome guys for mapping the F310 gamepad.
 * @author art.kalb96@gmail.com (Arthur Kalb)
 * @author articgrayling8x8@gmail.com (Dorian Chan)
 * @author kevinsundar@gmail.com (Kevin Vincent)
 * 
 * 		Updated by Wildcat Robotics
 * @author jptallman@icloud.com Jon Tallman
 */
public class Copad extends Joystick {
	// Gamepad axis ports
	private static final int AXIS_LEFT_X = 0;
	private static final int AXIS_LEFT_Y = 1;
	private static final int AXIS_RIGHT_X = 4;
	private static final int AXIS_RIGHT_Y = 5;
	//private static final int AXIS_BUMPER = 4;
	private static final int AXIS_DPAD = 5;

	// Gamepad buttons
	public static final int BUTTON_A = 1;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_Y = 4;
	private static final int BUTTON_BUMPER_LEFT = 5;	
	private static final int BUTTON_BUMPER_RIGHT = 6;
	private static final int BUTTON_TRIGGER_LEFT = 2;
	private static final int BUTTON_TRIGGER_RIGHT = 3;
	private static final int BUTTON_BACK = 7;
	private static final int BUTTON_START = 8;
	private static final int BUTTON_LEFT_STICK = 9;
	private static final int BUTTON_RIGHT_STICK = 10;
	//private static final int BUTTON_MODE = -1;
	//private static final int BUTTON_LOGITECH = -1;

	/**
	 * Constructor that creates a Joystick object.
	 */
	public Copad(int gamepadPort) {
		super(gamepadPort);
	}

	/**
	 * Returns the X position of the left stick.
	 */
	public double getLeftXAxis() {
		return getRawAxis(AXIS_LEFT_X);
	}

	/**
	 * Returns the X position of the right stick.
	 */
	public double getRightXAxis() {
		return getRawAxis(AXIS_RIGHT_X);
	}

	/**
	 * Returns the Y position of the left stick.
	 */
	public double getLeftYAxis() {
		return getRawAxis(AXIS_LEFT_Y);
	}

	/**
	 * Returns the Y position of the right stick.
	 */
	public double getRightYAxis() {
		return getRawAxis(AXIS_RIGHT_Y);
	}

	/**
	 * Checks whether Button A is being pressed and returns true if it is.
	 */
	public boolean getButtonStateA() {
		return getRawButton(BUTTON_A);
	}

	/**
	 * Checks whether Button B is being pressed and returns true if it is.
	 */
	public boolean getButtonStateB() {
		return getRawButton(BUTTON_B);
	}

	/**
	 * Checks whether Button X is being pressed and returns true if it is.
	 */
	public boolean getButtonStateX() {
		return getRawButton(BUTTON_X);
	}

	/**
	 * Checks whether Button Y is being pressed and returns true if it is.
	 */
	public boolean getButtonStateY() {
		return getRawButton(BUTTON_Y);
	}

	/**
	 * Returns an object of Button A.
	 */
	public JoystickButton getButtonA() {
		return new JoystickButton(this, BUTTON_A);
	}

	/**
	 * Returns an object of Button B.
	 */
	public JoystickButton getButtonB() {
		return new JoystickButton(this, BUTTON_B);
	}

	/**
	 * Returns an object of Button X.
	 */
	public JoystickButton getButtonX() {
		return new JoystickButton(this, BUTTON_X);
	}

	/**
	 * Returns an object of Button Y.
	 */
	public JoystickButton getButtonY() {
		return new JoystickButton(this, BUTTON_Y);
	}

	/**
	 * Return the DPad axis positions.
	 */
	public double getDPadX() {
		return getRawAxis(AXIS_DPAD);
	}

	/**
	 * DPad Left and Right only
	 * WPILIB cannot access the vertical axis of the Logitech Game Controller Dpad
	 */

	public boolean getDPadLeft() {
		double x = getDPadX();
		return (x < -0.5);
	}

	public boolean getDPadRight() {
		double x = getDPadX();
		return (x > 0.5);
	}

	/**
	 * Gets the state of the Start button
	 * @return the state of the Start button
	 */
	public JoystickButton getStartButton(){
		return new JoystickButton(this, BUTTON_START);
	}

	public JoystickButton getBackButton() {
		return new JoystickButton(this, BUTTON_BACK);
	}
 
	/**
	 * Gets the state of the left bumper
	 * @return the state of the left bumper
	 */
	public JoystickButton getLeftBumper() {
		return new JoystickButton(this, BUTTON_BUMPER_LEFT);
	}

	/**
	 * Gets the state of the right bumper
	 * @return the state of the right bumper
	 */
	public JoystickButton getRightBumper() {
		return new JoystickButton(this, BUTTON_BUMPER_RIGHT);
	}

	/**
	 * Gets the state of the left stick button
	 * @return the state of the left stick button
	 */
	public JoystickButton getLeftStickClick() {
		return new JoystickButton(this, BUTTON_LEFT_STICK);
	}

	/**
	 * Gets the state of the right stick button
	 * @return the state of the right stick button
	 */
	public JoystickButton getRightStickClick() {
		return new JoystickButton(this, BUTTON_RIGHT_STICK);
	}

	/**
	 * Gets the state of the left trigger
	 * @return the state of the left trigger
	 */
	public JoystickButton getLeftTriggerClick() {
		return new JoystickButton(this, BUTTON_TRIGGER_LEFT);
	}

	/**
	 * Gets the state of the right trigger
	 * @return the state of the right trigger
	 */
	public JoystickButton getRightTriggerClick() {
		return new JoystickButton(this, BUTTON_TRIGGER_RIGHT);
	}
	
	
	
}