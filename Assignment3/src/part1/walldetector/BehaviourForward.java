package part1.walldetector;

import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class BehaviourForward implements Behavior
{
    private UltrasonicSensor m_sonar;
    private DifferentialPilot m_pilot;
    private boolean m_suppressed;
    private final double SPEED;
    
    public BehaviourForward(DifferentialPilot _pilot, UltrasonicSensor _sonar, Double _speed)
    {
	super();
	SPEED = _speed;
	m_pilot = _pilot;
	m_sonar = _sonar;
	m_suppressed = false;
    }

    @Override
    public boolean takeControl(){ return true; }

    @Override
    public void action()
    {
	m_suppressed = false;
	m_pilot.forward();
	
	while(!m_suppressed)
	{
    	 if(m_sonar.getDistance() > 100)
	    {	
    	    	m_pilot.setTravelSpeed(SPEED);
	    }
	   else if(m_sonar.getDistance() <= 100 && m_sonar.getDistance() > 85)
	    {
		m_pilot.setTravelSpeed(10);
	    }
	    else if(m_sonar.getDistance() <= 85 && m_sonar.getDistance() > 70)
	    {
    	    	m_pilot.setTravelSpeed(7.5);
	    }
	    else
	    {
    	    	m_pilot.setTravelSpeed(5);
	    }
	    Thread.yield(); 
	}
    }

    @Override
    public void suppress(){ m_suppressed = true; }
}
