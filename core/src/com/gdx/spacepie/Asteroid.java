package com.gdx.spacepie;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	public Vector2 position;
	Random random = new Random();
	int randomSize = random.nextInt(200);
	
	public Asteroid () {	
		int randomRange = random.nextInt(500);
		position = new Vector2 (0,0);
		
		position.x = randomRange + World.getRocket().getPosition().x;
		position.y = randomRange + World.getRocket().getPosition().y;
	}
	
	public Vector2 getPosition () {
		return position;
	}
	
	public float getSize () {
		return (float) randomSize;
	}
}
