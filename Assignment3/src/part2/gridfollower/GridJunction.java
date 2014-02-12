package part2.gridfollower;

import java.util.ArrayList;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class GridJunction implements Behavior
{

    private final double m_cal_left;
    private final double m_cal_right;
    private LightSensor m_light_left;
    private LightSensor m_light_right;
    private DifferentialPilot m_pilot;
    private boolean m_suppressed = false;
    private ArrayList<Double> m_path;
    private int m_counter = 0;
    
    public GridJunction(double _cal_left, double _cal_right, LightSensor _light_left, LightSensor _light_right, DifferentialPilot _pilot, ArrayList<Double> _path)
    {
	m_cal_left = _cal_left;
	m_cal_right = _cal_right;
	m_light_left = _light_left;
	m_light_right = _light_right;
	m_pilot = _pilot;
	m_path = _path;
    }
    
    @Override
    public boolean takeControl()
    {
	// In this, you may want to cater for some margin of error. The light may change slightly over bumps etc.
	// This is where the testing will come in if you guys have chance.
	if(m_light_left.getNormalizedLightValue() + 20 < m_cal_left && m_light_right.getNormalizedLightValue() + 20 < m_cal_right)
	{
	    m_suppressed = false;
		return true;
	}
	else
	    return false;
	
    }
    
    @Override
    public void action()
    { 
	if(m_path.size() == m_counter + 1)
	{
	    System.exit(0);
	}
	while(!m_suppressed)
	{
	    m_pilot.stop();
	    m_pilot.travel(1.5);
	    m_pilot.rotate(m_path.get(m_counter));
	    
	    m_suppressed = true;
	}
	m_counter++;
	suppress();
    }
    
    @Override
    public void suppress(){ m_suppressed = true; }
}
