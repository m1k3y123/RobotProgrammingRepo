package com;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.util.PilotProps;

public class TouchTestEvent
{

	private final SensorPort m_port;
	private final DifferentialPilot m_pilot;
	
	public TouchTestEvent(SensorPort port, DifferentialPilot pilot)
	{
		m_pilot = pilot;
		m_port = port;
	}
	
	public void run()
	{
		m_port.addSensorPortListener(new SensorPortListener()
		{
			//@Override
			public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue)
			{
				if(aNewValue > aOldValue && aNewValue < 1000)
					reverseTurn();
			}
		});
	}
	
	public void reverseTurn()
	{
		m_pilot.stop();
		
		m_pilot.travel(20);
		m_pilot.rotate(180);
		
		Delay.msDelay(1000);
		m_pilot.backward();
	}
	
	public static void main(String[] args)
	{
		System.out.println("Press button to start moving!");
		
		Button.waitForAnyPress();
		DifferentialPilot pilot = new DifferentialPilot(2.2,4.0, Motor.A, Motor.C, true);
		TouchTestEvent demo = new TouchTestEvent(SensorPort.S1, pilot);
		
		pilot.backward();
		demo.run();
		
		Button.waitForAnyPress();
	}

}
