package inAtTheDeepEnd;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class DemoPilot {
	
	private final DifferentialPilot  m_pilot; 
	
	public DemoPilot(DifferentialPilot _pilot)
	{
		m_pilot = _pilot;
	}
	
	
	public void run()
	{
		m_pilot.travel(10);
		m_pilot.rotate(90);
		
	}
	
	public static void main(String[] args) 
	{
		Button.waitForAnyPress();
		
		DifferentialPilot pilot = new DifferentialPilot(2.2,4.0, Motor.A, Motor.C, true);
		DemoPilot demo = new DemoPilot(pilot);
		demo.run();

	}

}
