package inAtTheDeepEnd;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.util.Delay;


public class HelloWorld 
{
	private final RegulatedMotor m_left;
	private final RegulatedMotor m_right;

	
	public HelloWorld(RegulatedMotor _left, RegulatedMotor _right)
	{
		m_left = _left;
		m_right = _right;
	}
	
	
	public void run()
	{
		spin();
		Delay.msDelay(5000);
		stop();
	}
	
	public void spin()
	{
		m_left.forward();
		m_right.backward();
	}
	
	public void stop()
	{
		m_left.stop();
		m_right.stop();
	}
	
	public void config()
	{
		Motor.A.setSpeed(500);
		Motor.C.setSpeed(500);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		Button.waitForAnyPress();
		
		HelloWorld h = new HelloWorld(Motor.A, Motor.C);
		
		h.config();
		h.run();
		
	}

}
