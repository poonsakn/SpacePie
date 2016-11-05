package com.gdx.spacepie;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	public Vector2 position;
	
	Random random = new Random();
	int randomSize = 30 + random.nextInt(50);
	public Asteroid () {
		position = new Vector2 (0,0);
		int randomRange = random.nextInt(40000);
		int randomDirection = random.nextInt(4);
			
//		position.x = 500 + randomRange + World.getRocket().getPosition().x;
//		position.y = 500 + randomRange + World.getRocket().getPosition().y;
		position.x = 500 + randomRange;
		position.y = 500 + randomRange;
		switch (randomDirection) {
		case 0: position.x *= random.nextDouble();
				position.y *= random.nextDouble();
				break;
		case 1: position.x *= -random.nextDouble();
				position.y *= random.nextDouble();
				break;
				
		case 2: position.y *= random.nextDouble();
				position.y *= -random.nextDouble();
				break;
		case 3: position.x *= -random.nextDouble();
				position.y *= -random.nextDouble();
				break;
		}
		
		if (position.x <= 0) {
			position.x += 400;
			position.x *= -1;
		} 
		if ((position.y <= 0)) {
			position.y +=400;
			position.y *= -1;
		}
	}
	public Vector2 getPosition () {
		return position;
	}
	
	public float getSize () {
		return (float) randomSize;
	}
}
