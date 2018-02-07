package src.org.metrobots.commands.teleop;

import src.org.metrobots.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;
import src.org.metrobots.subsystems.WPI_VictorSPX;


public class Winches extends Command {

	Climber mClimber = new Climber();
	
    public Winches() {
    	requires(mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // executes like a guillotine
    //or the salem witch trials
    protected void execute() {
    	Climber.mClimber.winch(0.3);
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
