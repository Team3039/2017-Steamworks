/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import frc.controllers.PS4Gamepad;
import frc.robot.commands.Climb;
import frc.robot.commands.CycleFuel;
import frc.robot.commands.GearEject;
import frc.robot.commands.Shoot;
import frc.robot.commands.StrafeLeft;
import frc.robot.commands.StrafeRight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Calls the Gamepad Classes: Defines gp and cp for the robot
	private PS4Gamepad driverPad = new PS4Gamepad(RobotMap.HID_Controller);
	private PS4Gamepad operatorPad = new PS4Gamepad(RobotMap.HID_Copilot);
	
	//Returns Controller Data for use with certain Methods
	public PS4Gamepad getGamepad() {
		return driverPad;
	}
	
	public PS4Gamepad getCopad() {
		return operatorPad;
	}

	public OI() {
		//Driver Buttons
		Button driverL2 = driverPad.getL2();
		Button driverR2 = driverPad.getR2();
		Button driverX = driverPad.getButtonX();
		Button driverCircle = driverPad.getButtonCircle();
		Button driverSquare = driverPad.getButtonSquare();
		Button driverR1 = driverPad.getR1();


		//Operator Buttons
		// Button operatorTriangle = operatorPad.getButtonTriangle();
		
		driverL2.whileHeld(new StrafeLeft());
		driverR2.whileHeld(new StrafeRight());
		driverX.whileHeld(new CycleFuel());
		driverSquare.whileHeld(new GearEject());
		driverR1.whileHeld(new Climb());

		driverCircle.toggleWhenPressed(new Shoot());


	}
}
