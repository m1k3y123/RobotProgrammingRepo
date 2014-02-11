package part1.linefollower;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class FollowerForward implements Behavior
{   
    private DifferentialPilot m_pilot;
    private boolean m_suppressed = false;
    
    public FollowerForward(DifferentialPilot _pilot) { m_pilot = _pilot;}
    
    @Override
    public boolean takeControl() { return true; }

    @Override
    public void action()
    {
        m_pilot.setTravelSpeed(4.0);
	m_pilot.forward();
        m_suppressed = false;
		
		while(!m_suppressed)
		{
		    Thread.yield();
		}
    }

    @Override
    public void suppress() { m_suppressed = true; }

}
