package com;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class MyButtonListener
{

	private static boolean press1 = true;

	public static void main(String[] args)
	{
		DifferentialPilot pilot = new DifferentialPilot(2.2, 4.0, Motor.A, Motor.C, true);
		final DemoPilot demo = new DemoPilot(pilot);

		Button.waitForAnyPress();

		Button.ENTER.addButtonListener(new ButtonListener()
		{
			public void buttonPressed(Button b){ press1 = true; }
			
			@Override
			public void buttonReleased(Button b){}
		});

		Button.LEFT.addButtonListener(new ButtonListener()
		{
			public void buttonPressed(Button b)
			{
				press1 = false;
				System.out.println("Second button");
			}

			public void buttonReleased(Button b){}
		});

		while (press1)
			demo.patternOne();
		while (!press1)
			demo.patternTwo();

		Button.ESCAPE.waitForPressAndRelease();
	}
}
