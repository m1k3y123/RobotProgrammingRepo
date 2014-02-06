package part1.linefollower;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class FollowerSensors implements Behavior
{
    private final double m_cal_left;
    private final double m_cal_right;
    private LightSensor m_light_left;
    private LightSensor m_light_right;
    private DifferentialPilot m_pilot;
    private boolean m_suppressed = false;
    private boolean m_is_left = true;
    
    public FollowerSensors(double _cal_left, double _cal_right, LightSensor _light_left, LightSensor _light_right, DifferentialPilot _pilot)
    {
	m_cal_left = _cal_left;
	m_cal_right = _cal_right;
	m_light_left = _light_left;
	m_light_right = _light_right;
	m_pilot = _pilot;
    }
    
    @Override
    public boolean takeControl()
    {
	// In this, you may want to cater for some margin of error. The light may change slightly over bumps etc.
	// This is where the testing will come in if you guys have chance.
	if(m_light_left.getLightValue() < m_cal_left)	    
	    return true;    
	else if(m_light_right.getLightValue() < m_cal_right)
	{
	    m_is_left = false;
	    return true;
	}
	else
	    return false;
    }

    @Override
    public void action()
    {
	while(!m_suppressed)
	{
	    if(m_is_left)
	    {
		// Left sensor triggered.
		// Either rotate the robot slightly to the left then check light again or change speed of wheels.
		// If rotating, stop the robot, then start it again below.
		// If changing speed of wheels slow left/speed up right to get straight again.
	    }
	    else
	    {
		// Right sensor triggered.
		// Either rotate the robot slightly to the right then check light again or change speed of wheels.
		// If rotating, stop the robot, then start it again below.
		// If changing speed of wheels slow right/speed up left to get straight again.		
	    }
	}
    }

    @Override
    public void suppress()
    {
	m_is_left = true;
	m_suppressed = true;
    }
}
