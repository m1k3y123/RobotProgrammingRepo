package part2.gridfollower;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class GridLineFollower implements Behavior
{
    private final double m_cal_left;
    private final double m_cal_right;
    private LightSensor m_light_left;
    private LightSensor m_light_right;
    private DifferentialPilot m_pilot;
    private boolean m_suppressed = false;
    private boolean m_is_left = true;
    
    public GridLineFollower(double _cal_left, double _cal_right, LightSensor _light_left, LightSensor _light_right, DifferentialPilot _pilot)
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
	if(m_light_left.getNormalizedLightValue() + 20 < m_cal_left ){
	    m_suppressed = false;
		return true;
	}
	
	else if(m_light_right.getNormalizedLightValue() + 20 < m_cal_right){
	    m_suppressed = false;
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
		    System.out.println("LEFT: " + m_light_left.getNormalizedLightValue());
		    System.out.println("RIGHT: " + m_light_right.getNormalizedLightValue());
		    
		    if(m_is_left)
		    {
		    	while(m_light_left.getNormalizedLightValue() + 20 < m_cal_left && !m_suppressed){
		    	    m_pilot.steer(-75);
		    	    System.out.println("LEFT: " + m_light_left.getNormalizedLightValue());
		    	}
		    	m_suppressed = true;
			// Left sensor triggered.
			// Either rotate the robot slightly to the left then check light again or change speed of wheels.
			// If rotating, stop the robot, then start it again below.
			// If changing speed of wheels slow left/speed up right to get straight again.
		    }
		    else
		    {
		    	while(m_light_right.getNormalizedLightValue() + 20 < m_cal_right && !m_suppressed){
		    	    m_pilot.steer(75);
		    	    System.out.println("RIGHT: " + m_light_right.getNormalizedLightValue());
		    	}
		    	m_suppressed = true;
		    // Right sensor triggered.
			// Either rotate the robot slightly to the right then check light again or change speed of wheels.
			// If rotating, stop the robot, then start it again below.
			// If changing speed of wheels slow right/speed up left to get straight again.		
		    }
		    Thread.yield();
		}
		suppress();
    }

    @Override
    public void suppress()
    {
	m_is_left = true;
	m_suppressed = true;
    }
}
