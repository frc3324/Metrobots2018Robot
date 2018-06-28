package org.metrobots.util;
import jaci.pathfinder.Trajectory;
public class TrajContainer {
	    Trajectory trajec;

		boolean isInverted;

		

		public TrajContainer(Trajectory trajec, boolean isInverted){

			this.trajec = trajec;

			this.isInverted = isInverted;

		}

		

		public Trajectory getTrajec(){

			return trajec;

		}

		

		public boolean isInverted(){

			return isInverted;
}
}
