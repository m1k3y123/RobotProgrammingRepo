package part1.walldetector;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class WallDetector
{
    private DifferentialPilot m_pilot;
    private UltrasonicSensor m_sonar;
    private final Double SPEED = 11.5;
    
    public WallDetector(DifferentialPilot _pilot, UltrasonicSensor _sonar) 
    {
	m_pilot = _pilot;
	m_sonar = _sonar;
    }
    
    public void run()
    {
	Behavior[] behaviours = 
	{ 
		new BehaviourForward(m_pilot, m_sonar, SPEED),
		new BehaviourReverseTurn(m_pilot, m_sonar, SPEED),
		new Reverse(m_pilot, m_sonar, SPEED)
	};
	Arbitrator arby = new Arbitrator(behaviours);
	arby.start();
    }
    
    public static void main(String[] args)
    {
    System.out.println("Please Press any button");
	Button.waitForAnyPress();
	
	DifferentialPilot pilot = new DifferentialPilot(2.2, 4.0, Motor.A, Motor.C);
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S2);
	
	WallDetector wallD = new WallDetector(pilot, sonar);
	
	wallD.run();
    }
}
