//package org.metrobots.commands.auto;
//
//import org.metrobots.Constants;
//import org.metrobots.Robot;
//import org.metrobots.subsystems.DriveTrain;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.Encoder;
//
//public class DriveForward extends Command{
//	double pulsesToTravel, speed, distance, startingLocation, currentLocation;
//	
//	/**
//	 * Method for auto drive forward.<p>
//	 * 
//	 * Speed of motor, -1 to 1. Distance to be 
//	 * traveled by robot in inches.
//	 * @param speed
//	 * @param distance
//	 */
//	public DriveForward(double speed, double distance) {
//		//distance is equal to the circumference of the wheel times the amount of pulses.
//		this.speed = speed;
//		this.distance = distance;
//	}
//
//	@Override
//	protected void execute() {
//		pulsesToTravel = distance * (Constants.CIRCUMFERENCE / Constants.PULSES);
////		speed = pulsesToTravel / totalPulses;
//		Robot.mDriveTrain.arcadeDrive(speed, 0.0, true);
//	}
//	
//	@Override
//	protected void initialize() {
//		startingLocation = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2);
//	}
//	
//	@Override
//	protected boolean isFinished() {
//		// TODO Auto-generated method stub
//		currentLocation = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2);
//		if ((currentLocation - startingLocation) < distance) {
//			return false;
//		} else {
//			return true;
//		}
//		
//	}
//	
//	@Override
//	protected void interrupted() {}
//	
//}
