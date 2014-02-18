package part1.walldetector;

import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Reverse implements Behavior
{
    private UltrasonicSensor m_sonar;
    private boolean m_suppressed;
    private DifferentialPilot m_pilot;
    private final Double SPEED;
    
    public Reverse(DifferentialPilot _pilot, UltrasonicSensor _sonar, Double _speed)
    {
	SPEED = _speed;
	m_pilot = _pilot;
	m_sonar = _sonar;
	m_suppressed = false;  
    }
    @Override
    public boolean takeControl() { return m_sonar.getDistance() < 20; }

    @Override
    public void action()
    {
    	while(m_sonar.getDistance() < 20)
    	{
    		m_pilot.backward();
    		m_suppressed = false;
    	}
    	m_pilot.stop();
    	
	while(m_pilot.isMoving() && !m_suppressed)
	    Thread.yield();
    }

    @Override
    public void suppress() { m_suppressed = true; }
}