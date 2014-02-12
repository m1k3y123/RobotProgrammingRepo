package part2.gridfollower;

import java.util.ArrayList;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class GridFollower
{
    /**
     * @param args
     */
    private final double m_cal_left;
    private final double m_cal_right;
    private LightSensor m_light_left;
    private LightSensor m_light_right;
    private DifferentialPilot m_pilot;
    private ArrayList<Double> m_path;
    private boolean m_stop = false;
    
    public GridFollower(DifferentialPilot _pilot, LightSensor _light_left, LightSensor _light_right)
    {
	m_pilot = _pilot;
	m_light_left = _light_left;
	m_light_right = _light_right;
	m_path = new ArrayList<Double>();
	
	    Button.ESCAPE.addButtonListener(new ButtonListener()
	    {
	        @Override
	        public void buttonReleased(Button b)
	        {
	           m_stop = true; 
	    	}
	        
	        @Override
	        public void buttonPressed(Button b){}
	    });
	    Button.LEFT.addButtonListener(new ButtonListener()
	    {
	        
	        @Override
	        public void buttonReleased(Button b)
	        {
	            m_path.add(-92.5);
	    	}
	        
	        @Override
	        public void buttonPressed(Button b){}
	    });
	    Button.RIGHT.addButtonListener(new ButtonListener()
	    {
	        
	        @Override
	        public void buttonReleased(Button b)
	        {
	            m_path.add(92.5);
	    	}
	        
	        @Override
	        public void buttonPressed(Button b){}
	    });
	
	System.out.println("Please press the left and right buttons to enter a path:");
	while(!m_stop){}
	
	System.out.println("Press button to calibrate the sensors (3 seconds to position the robot)");
	Button.waitForAnyPress();
	m_cal_left = m_light_left.getNormalizedLightValue();
	m_cal_right = m_light_right.getNormalizedLightValue();
	System.out.println("Wait");
	Delay.msDelay(3000);
	System.out.println("Running");
	
	
	// Is this the right method to call to get the reflected light rather than the ambient light? Again, do some sysout's to check
    }
    
    public void run()
    {
	// Create behaviors array.
  	Behavior[] behaviors = 
  	    {
  		new GridForward(m_pilot),
  		new GridLineFollower(m_cal_left, m_cal_right, m_light_left, m_light_right, m_pilot),
  		new GridJunction(m_cal_left, m_cal_right, m_light_left, m_light_right, m_pilot, m_path)
  	    }; 
        		
        // Set up the behaviors for when the light value of a sensor decreases below the original (set above) in an arby.
        Arbitrator arby = new Arbitrator(behaviors);
        
	// Check this as I haven't got the light sensors at home.	
	m_light_left.setFloodlight(true);
	m_light_right.setFloodlight(true);
	
       //while(true)
        //{
       // 	Button.waitForAnyPress();
       // 	System.out.println("Left : " + m_light_left.getNormalizedLightValue());
       // 	System.out.println("Right : " + m_light_right.getNormalizedLightValue());
        //}
        
         //Start arby.
       arby.start();	
        
    }
    
    public static void main(String[] args)
    {
	// Set up the pilot and both light sensors.
	DifferentialPilot pilot = new DifferentialPilot(2.2, 4.0, Motor.A, Motor.C);
	LightSensor light_left = new LightSensor(SensorPort.S3);
	LightSensor light_right = new LightSensor(SensorPort.S1);
	
	// Create the line follower.
	GridFollower follow = new GridFollower(pilot, light_left, light_right);
	follow.run();	
    }

}

