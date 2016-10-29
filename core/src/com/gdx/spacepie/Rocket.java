package com.gdx.spacepie;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	
	public Rocket(int x, int y) {
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition() {
		return position;
	}
}