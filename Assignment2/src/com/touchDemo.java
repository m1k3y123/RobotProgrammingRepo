package com;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;

public class touchDemo{
	
	
	public static void main(String[] args) throws Exception {
		
		boolean run = true;
		
		DifferentialPilot pilot = new DifferentialPilot(2.2,4.0, Motor.A, Motor.C, true);
		final DemoPilot demo = new DemoPilot(pilot);
		
		while(run)
		{
        demo.run();
		}
		
		SensorPort.S4.addSensorPortListener(new SensorPortListener() 
				{
				public void stateChanged(SensorPort s1, int o,int n)
				{
					
					System.out.println("Here");
					demo.stop();
					demo.reverse();
				}
				}
				);
		
		Button.waitForAnyPress();
		}
				

	
		}


