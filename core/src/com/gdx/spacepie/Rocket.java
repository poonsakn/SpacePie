package com.gdx.spacepie;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	private static float originalRocketSpeed = 7;
	private static float originalRotationSpeed = 5;
	private static float rocketSpeed = originalRocketSpeed;
	private static float rotationSpeed = originalRotationSpeed;
	public static int rotation = 0;
	public static double rotationRadian = Math.toRadians(rotation);
	
	public Rocket(int x, int y) {
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void update() {
//		System.out.println(rotation + " ===== " + (int) position.x + "." + (int) position.y);
		rotation %= 360;
	}
	
	public void updatePosition() {
		position.x += rocketSpeed * Math.sin(-rotationRadian) ;
		position.y += rocketSpeed * Math.cos(-rotationRadian) ;
	}
	
	public static void boostSpeed (boolean keyPressed) {
		if (keyPressed == true) {
			rocketSpeed = (float) (originalRocketSpeed*3);
			rotationSpeed = (float) (originalRotationSpeed*0.75); 
		} else if (keyPressed == false) {
			rocketSpeed = originalRocketSpeed;
			rotationSpeed = originalRotationSpeed;
		}
	}
	
	public static void updateRocketRotation(int key) {
		if (key == -1) {
			rotation += rotationSpeed;
		} else if (key == 1) {
			rotation -= rotationSpeed;
		}
		
		rotationRadian = Math.toRadians(rotation);
	}
}