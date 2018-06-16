package com.team3039.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Contains functions for use with the Playstation 4 controller.
 * Credit to these guys

 * @author Thomas Floyd tefloyd1215@att.net and
 * @author Joshua Lewis joshlewi14@gmail.com
 * 
 */
public class PS4Copad extends Joystick {
	// Gamepad axis ports
	private static final int AXIS_LEFT_X = 0;
	private static final int AXIS_LEFT_Y = 1;
	private static final int AXIS_RIGHT_X = 4;
	private static final int AXIS_RIGHT_Y = 5;
	//private static final int AXIS_BUMPER = 4;
	private static final int AXIS_DPAD = 5;

	// Gamepad buttons
	public static final int BUTTON_X = 2;
	public static final int BUTTON_Square = 1;
	public static final int BUTTON_Circle = 3;
	public static final int BUTTON_Triangle = 4;
	private static final int BUTTON_L1 = 5;	
	private static final int BUTTON_R1 = 6;
	private static final int BUTTON_L2 = 7;
	private static final int BUTTON_R2 = 8;
	private static final int BUTTON_BACK = 9;
	private static final int BUTTON_START = 10;
	private static final int BUTTON_L3 = 11;
	private static final int BUTTON_R3 = 12;
	private static final int BUTTON_PAD = 14;
	
	public static final int BUTTON_XX = 3;
	public static final int BUTTON_A = 1;
	public static final int BUTTON_Y = 4;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_LB = 5;
	public static final int BUTTON_RB = 6;
	private static final int BUTTON_LT = 00;
	private static final int BUTTON_RT = 00;
	
	//private static final int BUTTON_MODE = -1;
	//private static final int BUTTON_LOGITECH = -1;

	/**
	 * Constructor that creates a Joystick object.
	 */
	public PS4Copad(int gamepadPort) {
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
	 * Checks whether Button X is being pressed and returns true if it is.
	 */
	public boolean getButtonStateX() {
		return getRawButton(BUTTON_X);
	}

	/**
	 * Checks whether Button B is being pressed and returns true if it is.
	 */
	public boolean getButtonStateCircle() {
		return getRawButton(BUTTON_Circle);
	}

	/**
	 * Checks whether Button Square is being pressed and returns true if it is.
	 */
	public boolean getButtonStateSquare() {
		return getRawButton(BUTTON_Square);
	}

	/**
	 * Checks whether Button Triangle is being pressed and returns true if it is.
	 */
	public boolean getButtonStateTriangle() {
		return getRawButton(BUTTON_Triangle);
	}

	/**
	 * Returns an object of Button X.
	 */
	public JoystickButton getButtonX() {
		return new JoystickButton(this, BUTTON_X);
	}

	/**
	 * Returns an object of Button Circle.
	 */
	public JoystickButton getButtonCircle() {
		return new JoystickButton(this, BUTTON_Circle);
	}

	/**
	 * Returns an object of Button Sqaure.
	 */
	public JoystickButton getButtonSquare() {
		return new JoystickButton(this, BUTTON_Square);
	}

	/**
	 * Returns an object of Button Triangle.
	 */
	public JoystickButton getButtonTriangle() {
		return new JoystickButton(this, BUTTON_Triangle);
	}
	
	public boolean getButtonStatePad() {
		return getRawButton(BUTTON_PAD);
	}
	/**
	 * Return the DPad axis positions.
	 */
	public double getDPadX() {
		return getRawAxis(AXIS_DPAD);
	}

	/**
	 * DPad Left and Right only
	 * WPILIB cannot access the vertical axis of the Playstation 4
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
	
	public JoystickButton getButtonPad() {
		return new JoystickButton(this, BUTTON_PAD);
	}
	/**
	 * Gets the state of the left bumper
	 * @return the state of the left bumper
	 */
	public JoystickButton getL1() {
		return new JoystickButton(this, BUTTON_L1);
	}

	/**
	 * Gets the state of the right bumper
	 * @return the state of the right bumper
	 */
	public JoystickButton getR1() {
		return new JoystickButton(this, BUTTON_R1);
	}

	/**
	 * Gets the state of the left stick button
	 * @return the state of the left stick button
	 */
	public JoystickButton getL3() {
		return new JoystickButton(this, BUTTON_L3);
	}

	/**
	 * Gets the state of the right stick button
	 * @return the state of the right stick button
	 */
	public JoystickButton getR3() {
		return new JoystickButton(this, BUTTON_R3);
	}

	/**
	 * Gets the state of the left trigger
	 * @return the state of the left trigger
	 */
	public JoystickButton getL2() {
		return new JoystickButton(this, BUTTON_L2);
	}

	/**
	 * Gets the state of the right trigger
	 * @return the state of the right trigger
	 */
	public JoystickButton getR2() {
		return new JoystickButton(this, BUTTON_R2);
	}
	
	
	
}