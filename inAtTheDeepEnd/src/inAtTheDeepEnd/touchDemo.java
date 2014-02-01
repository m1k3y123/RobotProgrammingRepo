package inAtTheDeepEnd;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class touchDemo {

	public static void main(String[] args) {
		
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		
		if(touch.isPressed())
		{
			
		}

	}

}
