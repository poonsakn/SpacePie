package com.gdx.spacepie;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	public Vector2 position;
	
	Random random = new Random();
	int randomSize = 30 + random.nextInt(50);
	
	public Asteroid () {
		position = new Vector2 (0,0);
		int randomRange = random.nextInt(400);
		int randomDirection = random.nextInt(4);
			
		position.x = randomRange + World.getRocket().getPosition().x;
		position.y = randomRange + World.getRocket().getPosition().y;
		
		switch (randomDirection) {
		case 0: break;
		case 1: position.x *= -1;
				break;
		case 2: position.y *= -1;
				break;
		case 3: position.x *= -1;
				position.y *= -1;
				break;
		}
	}
	public Vector2 getPosition () {
		return position;
	}
	
	public float getSize () {
		return (float) randomSize;
	}
}
