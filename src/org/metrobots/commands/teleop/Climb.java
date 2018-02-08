//package org.metrobots.commands.teleop;
//
//import org.metrobots.subsystems.Climber;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class Climb extends Command {
//
//	public Climber mClimber = new Climber();
//	
//    public Climb() {
//    	requires(mClimber);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
// 
//    /**
//     *  When command is executed, the climber will enable while the button is pressed. 
//     *  Backdrive is handled by a wrench.
//     */
//    
//    protected void execute() {
//    	mClimber.climb(1.0);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
