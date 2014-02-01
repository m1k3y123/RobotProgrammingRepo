package com;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

import java.util.*;

public class DemoPilot {

	private final DifferentialPilot  m_pilot; 
	private Random turn;
	private boolean m_run;
	
	public DemoPilot(DifferentialPilot _pilot)
	{
		m_pilot = _pilot;
		this.turn = new Random(360);
		this.m_run = false;
	}
	
	public void patternOne()
	{
		m_pilot.travel(-10);
		m_pilot.rotate(90);
	}
	
	public void patternTwo()
	{
		m_pilot.rotate(90);
	}
	
    public void reverse()
    {
    	m_pilot.travel(10);
    }
    
    public void turn()
    {
    	m_pilot.rotate(this.turn.nextDouble());
    }
   
    public void run()
    {
    		m_pilot.travel(-10);	
    }
	public void stop()
	{
		m_pilot.stop();
	}
	
	public static void main(String[]args)
	{
		DifferentialPilot pilot = new DifferentialPilot(2.2,4.0, Motor.A, Motor.C, true);
		DemoPilot demo = new DemoPilot(pilot);
	}
}
	

	

