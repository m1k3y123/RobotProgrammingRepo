package part1.linefollower;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class LineFollower
{
    private final double m_cal_left;
    private final double m_cal_right;
    private LightSensor m_light_left;
    private LightSensor m_light_right;
    private DifferentialPilot m_pilot;
    
    public LineFollower(DifferentialPilot _pilot, LightSensor _light_left, LightSensor _light_right)
    {
	m_pilot = _pilot;
	m_light_left = _light_left;
	m_light_right = _light_right;
	
	System.out.println("Press button to calibrate the sensors (3 seconds to position the robot");
	Button.waitForAnyPress();
	Delay.msDelay(3000);
	
	// Check this as I haven't got the light sensors at home.
	m_light_left.setFloodlight(true);
	m_light_right.setFloodlight(true);
	
	// Is this the right method to call to get the reflected light rather than the ambient light? Again, do some sysout's to check.
	m_cal_left = m_light_left.getLightValue();
	m_cal_right = m_light_right.getLightValue();
    }
    
    public void run()
    {
	// Create behaviors array.
  	Behavior[] behaviors = 
  	    {
  		new FollowerForward(m_pilot),
  		new FollowerSensors(m_cal_left, m_cal_right, m_light_left, m_light_right, m_pilot)
  	    }; 
        		
        // Set up the behaviors for when the light value of a sensor decreases below the original (set above) in an arby.
        Arbitrator arby = new Arbitrator(behaviors);
        
        // Start arby.
        arby.start();
		
    }
    
    public static void main(String[] args)
    {
	// Set up the pilot and both light sensors.
	DifferentialPilot pilot = new DifferentialPilot(2.2, 4.0, Motor.A, Motor.C);
	LightSensor light_left = new LightSensor(SensorPort.S1);
	LightSensor light_right = new LightSensor(SensorPort.S2);
	
	// Create the line follower.
	LineFollower follow = new LineFollower(pilot, light_left, light_right);
	follow.run();	
    }

}
