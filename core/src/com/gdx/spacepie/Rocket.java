package com.gdx.spacepie;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	public static int rotation = 0;
	
	public Rocket(int x, int y) {
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void update() {
		System.out.println(rotation+90);
		rotation %= 360;
	}
}