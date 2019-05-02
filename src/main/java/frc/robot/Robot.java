
package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoBoilerScoreBlue;
import frc.robot.commands.AutoBoilerScoreNoGearBlue;
import frc.robot.commands.AutoBoilerScoreNoGearRed;
import frc.robot.commands.AutoBoilerScoreRed;
import frc.robot.commands.AutoNoTrackBlueBoiler;
import frc.robot.commands.AutoNoTrackBlueHopper;
import frc.robot.commands.AutoNoTrackCenter;
import frc.robot.commands.AutoNoTrackRedBoiler;
import frc.robot.commands.AutoNoTrackRedHopper;
import frc.robot.commands.AutoRunShooter;
import frc.robot.commands.AutoScoreElementsBlue;
import frc.robot.commands.AutoScoreElementsRed;
import frc.robot.commands.AutoTest;
import frc.robot.commands.AutoTrackBlueBoiler;
import frc.robot.commands.AutoTrackBlueHopper;
import frc.robot.commands.AutoTrackCenterBLUE;
import frc.robot.commands.AutoTrackCenterRED;
import frc.robot.commands.AutoTrackRedBoiler;
import frc.robot.commands.AutoTrackRedHopper;
import frc.robot.commands.BackwardAuto;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Electronics;
import frc.robot.subsystems.Receiver;
import frc.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot{

	
	public static OI oi;
//	public static ShooterPID shooterpid;
	public static final Shooter shooter = new Shooter();
	public static final Electronics electronics = new Electronics();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Collector collector = new Collector();
	public static final Receiver receiver = new Receiver();
   
	public static boolean boilerRight;
	public static boolean boilerLeft;
	public static boolean boilerForward;
	public static boolean boilerBackward;	
	public static boolean gearRight;
	public static boolean gearLeft;
	public static double gearPosition;
	public NetworkTable boilerTable;
	public NetworkTable gearTable;
    
	Command autonomousCommand;
    SendableChooser<CommandGroup> chooser;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
		oi = new OI();
//		shooterpid = new ShooterPID();
		chooser = new SendableChooser<CommandGroup>();
    	boilerTable = NetworkTable.getTable("GRIP/boilerReport");
    	gearTable = NetworkTable.getTable("GRIP/gearReport");

        chooser.addObject("BLUE Alliance Boiler Tracking", new AutoTrackBlueBoiler());
        chooser.addObject("BLUE Alliance Hopper Tracking", new AutoTrackBlueHopper());
        chooser.addObject("RED Alliance Boiler Tracking", new AutoTrackRedBoiler());
        chooser.addObject("RED Alliance Hopper Tracking", new AutoTrackRedHopper());
        chooser.addObject("CENTER Tracking BLUE SCORE", new AutoTrackCenterBLUE());
        chooser.addObject("CENTER Tracking RED SCORE", new AutoTrackCenterRED());
               
    	chooser.addObject("BLUE Boiler NO Tracking", new AutoNoTrackBlueBoiler());
        chooser.addObject("BLUE Hopper NO Tracking", new AutoNoTrackBlueHopper());
        chooser.addObject("RED Boiler NO Tracking", new AutoNoTrackRedBoiler());
        chooser.addObject("RED Hopper NO Tracking", new AutoNoTrackRedHopper());
        chooser.addObject("CENTER No Tracking", new AutoNoTrackCenter());

        
        chooser.addObject("BLUE Score Fuel", new AutoBoilerScoreBlue());
        chooser.addObject("RED Score Fuel", new AutoBoilerScoreRed());
        
        chooser.addObject("BLUE Score Fuel NO Deploy", new AutoBoilerScoreNoGearBlue());
        chooser.addObject("RED Score Fuel NO Deploy", new AutoBoilerScoreNoGearRed());
        
        chooser.addObject("BLUE Score Gear And Fuel", new AutoScoreElementsBlue());
        chooser.addObject("RED Score Gear And Fuel", new AutoScoreElementsRed());

        chooser.addObject("Test Realm", new AutoTest());
        chooser.addObject("Test Shoot", new AutoRunShooter());
        chooser.addObject("Back", new BackwardAuto());
                
        CameraServer cameraserver = CameraServer.getInstance();
        cameraserver.startAutomaticCapture(); 
        
       // SmartDashboard.putNumber("Shooter Voltage", Robot.shooterpid.shootVoltage);
        	
//       chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        //SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putData("Sendable Chooser", chooser); 
        
  
    }
    
    
    public void robotPeriodic() {
        double[] defaultValue = new double [0];  
        double[] boilerArrayX = boilerTable.getNumberArray("centerX", defaultValue);
        double[] boilerArrayY = boilerTable.getNumberArray("centerY", defaultValue);
     	double[] gearArrayX = gearTable.getNumberArray("centerX", defaultValue);

/*     	if((gearArrayX.length >= 2) && (!boilerArrayX.equals(null))) {
     		gearPosition = (gearArrayX[0] + gearArrayX[1]) /2;
     	}
     	else {
     		gearPosition = gearArrayX[0];
     	}*/

//Boiler 153 -257
        try{
        	
            if ((!boilerArrayX.equals(null)) && boilerArrayX.length >= 2) {
            	
                double BoilerX1 = boilerArrayX[0];
                double BoilerX2 = boilerArrayX[1];         
                double BoilerX = ((BoilerX1 + BoilerX2)/2);
    
                if (BoilerX >= 135) {
                	setBoilerRight(true);
                	setBoilerLeft(false);
                }
                
                if (BoilerX <= 145) {
                	setBoilerRight(false);
                	setBoilerLeft(true);
                }
                
                if ((BoilerX >= 135 ) && (BoilerX <= 145)) {
                	setBoilerRight(false);
                	setBoilerLeft(false); 
                }
            }
        }
        catch(Exception e){
                	setBoilerRight(false);
                	setBoilerLeft(false);
            }

        try{
        	
            if ((!gearArrayX.equals(null)) && gearArrayX.length >= 2) {
            	
                double GearX1 = gearArrayX[0];
                double GearX2 = gearArrayX[1];         
                double GearX = ((GearX1 + GearX2)/2);
    
                if (GearX >= 239) {
                	setGearRight(true);
                	setGearLeft(false);
                }
                
                if (GearX <= 241) {
                	setGearRight(false);
                	setGearLeft(true);
                }
                
                if ((GearX >= 239 ) && (GearX <= 241)) {
                	setGearRight(false);
                	setGearLeft(false); 
                }
            }
        }
        catch(Exception e){
                	setGearRight(false);
                	setGearLeft(false);
            }
 try{
        	
            if ((!boilerArrayY.equals(null)) && boilerArrayY.length >= 2) {
            	
                double Y1 = boilerArrayY[0];
                double Y2 = boilerArrayY[1];         
                double Y = ((Y1 + Y2)/2);
    
                if (Y >= 175) {
                	setBoilerForward(true);
                	setBoilerBackward(false);
                }
                
                if (Y <= 185) {
                	setBoilerForward(false);
                	setBoilerBackward(true);
                }
                
                if ((Y >= 175 ) && (Y <= 185)) {
                	setBoilerForward(false);
                	setBoilerBackward(false); 
                }
            }
        }
        catch(Exception e){
                	setGearRight(false);
                	setGearLeft(false);
            }
     } 
    	
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
//    	Robot.collector.retriveGearState();
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//Robot.collector.printGearStatus();
        Scheduler.getInstance().run();
        Robot.drivetrain.getDriveFactor();
        Robot.drivetrain.getTurnFactor();
        Robot.drivetrain.getStrafeFactor();
        //System.out.println("Gear Status " + Robot.collector.getGearStatus());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
        
    public static boolean getBoilerRight() {
    	return boilerRight;
    }
    public void setBoilerRight(Boolean boilerright) {
    	boilerRight = boilerright;
    }
    
    public static boolean getBoilerLeft(){
    	return boilerLeft;
    }
    
    public void setBoilerLeft(Boolean boilerleft){
    	boilerLeft = boilerleft;
    }
    
    public static boolean getGearRight() {
    	return gearRight;
    }
    
    public void setGearRight(Boolean gearright) {
    	gearRight = gearright;
    }
    
    public static boolean getGearLeft(){
    	return gearLeft;
    }
   
    public void setGearLeft(Boolean gearleft){
    	gearLeft = gearleft;
    }
    
    public static boolean getBoilerForward() {
    	return boilerForward;
    }
    
    public void setBoilerForward(Boolean boilerforward) {
    	boilerForward = boilerforward;
    }
    
    public static boolean getBoilerBackward() {
    	return boilerBackward;
    }
    
    public void setBoilerBackward(Boolean boilerbackward) {
    	boilerBackward = boilerbackward;
    }
}

