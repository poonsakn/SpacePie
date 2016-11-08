package com.gdx.spacepie;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	public Vector2 position;
	
	Random random = new Random();
	int randomSize = 50 + random.nextInt(50);
	public Asteroid () {
		position = new Vector2 (0,0);
		int randomRange = 200 + random.nextInt(40000);
		int randomDirection = random.nextInt(4);
		double interval = 5;
			
//		position.x = 500 + randomRange + World.getRocket().getPosition().x;
//		position.y = 500 + randomRange + World.getRocket().getPosition().y;
		
		switch (randomDirection) {
		case 0: position.x = (float) ((interval)*randomRange*random.nextDouble());
				position.y = (float) ((interval)*randomRange*random.nextDouble());
				break;
		case 1: position.x = (float) ((interval)*randomRange*-random.nextDouble());
				position.y = (float) ((interval)*randomRange*random.nextDouble());
				break;
				
		case 2: position.x= (float) ((interval)*randomRange*random.nextDouble());
				position.y = (float) ((interval)*randomRange*-random.nextDouble());
				break;
		case 3: position.x = (float) ((interval)*randomRange*-random.nextDouble());
				position.y = (float) ((interval)*randomRange*-random.nextDouble());
				break;
		}
		
//		if (position.x <= 0) {
//			position.x -= 400;
//		} 
//		if ((position.y <= 0)) {
//			position.y -=400;
//		}
	}
	public Vector2 getPosition () {
		return position;
	}
	
	public float getSize () {
		return (float) randomSize;
	}
}
