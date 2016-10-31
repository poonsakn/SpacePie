package com.gdx.spacepie;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	private float rocketSpeed = 5;
	public static int rotation = 0;
	public static double rotationRadian = Math.toRadians(rotation);
	
	public Rocket(int x, int y) {
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void update() {
		System.out.println(rotation + "===== " + position.x + "------" + position.y);
		rotation %= 360;
	}
	
	public void updatePosition() {
		position.x += rocketSpeed * Math.sin(-rotationRadian) ;
		position.y += rocketSpeed * Math.cos(-rotationRadian) ;
	}
	
	public static void updateRocketRotation(int key) {
		if (key == -1) {
			rotation += 5;
		} else if (key == 1) {
			rotation -= 5;
		}
		
		rotationRadian = Math.toRadians(rotation);
	}
}