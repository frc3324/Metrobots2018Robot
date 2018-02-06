package org.metrobots.commands.auto;

import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;
import src.org.metrobots.DriveTrain;

const private static double kP = 0.03f;			
const private static double kI = 0.00f;
const private static double kD = 0.00f;

/**
 *
 */
public class PIDRotate extends Command {
	AHRS ahrs;
	PIDController turnController;
	
	private double specifiedAngle
	
	const private static double kP = 0.03f;			//Declares PID controls
	const private static double kI = 0.00f;
	const private static double kD = 0.00f;
   
	
	static final double kToleranceDegrees = 2.0f;
	
	
	public PIDRotate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mDriveTrain);

    }
	public PIDRotate(float angle, double speed) {
		this.speed = speed;
		specifiedAngle = angle;
	    try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	    } catch (RuntimeException ex ) {
	        DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	}
	    turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
	      
	      /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
	      /* tuning of the Turn Controller's P, I and D coefficients.            */
	      /* Typically, only the P value needs to be modified.                   */
	LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
	}
		
    // Called just before this Command runs the first time
    protected void initialize() {
	      turnController.setInputRange(-180.0f,  180.0f);
	      turnController.setOutputRange(-1.0, 1.0);
	      turnController.setAbsoluteTolerance(kToleranceDegrees);
	      turnController.setContinuous(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    turnController -> SetSetpoint()
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
