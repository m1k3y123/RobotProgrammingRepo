package part1.walldetector;

import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class BehaviourReverseTurn implements Behavior
{
    private UltrasonicSensor m_sonar;
    private boolean m_suppressed;
    private DifferentialPilot m_pilot;
    private final Double SPEED;
    
    public BehaviourReverseTurn(DifferentialPilot _pilot, UltrasonicSensor _sonar, Double _speed)
    {
	SPEED = _speed;
	m_pilot = _pilot;
	m_sonar = _sonar;
	m_suppressed = false;  
    }
    @Override
    public boolean takeControl() { return m_sonar.getDistance() < 25; }

    @Override
    public void action()
    {
	m_pilot.setTravelSpeed(SPEED);
	m_pilot.stop();
	m_suppressed = false;    
	m_pilot.travel(-10);
	m_pilot.rotate(210);

	while(m_pilot.isMoving() && !m_suppressed)
	    Thread.yield();
	
	m_pilot.stop();
    }

    @Override
    public void suppress() { m_suppressed = true; }
}