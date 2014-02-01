package com;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class TouchTestWhile
{
	
	private final TouchSensor m_touchy;
	private final DifferentialPilot m_pilot;
	
	public TouchTestWhile(TouchSensor touchy, DifferentialPilot pilot)
	{
		m_pilot = pilot;
		m_touchy = touchy;
	}
	
	public void run()
	{
		while(true)
		{
			if(m_touchy.isPressed())
			{
				m_pilot.stop();
				
				m_pilot.travel(20);
				m_pilot.rotate(180);
				
				Delay.msDelay(1000);
				m_pilot.backward();
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		Button.waitForAnyPress();
		DifferentialPilot pilot = new DifferentialPilot(2.2,4.0, Motor.A, Motor.C, true);
		TouchTestWhile demo = new TouchTestWhile(new TouchSensor(SensorPort.S1), pilot);
		pilot.backward();
		demo.run();
		
		// Another button press for exit??
	}

}
