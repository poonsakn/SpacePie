package com.gdx.spacepie;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;

public class Asteroid {
	private CircleShape asteroid;
	Random random = new Random();
	int randomSize = random.nextInt(200);
	public Asteroid (int x, int y) {	
		int randomRange = random.nextInt(500);
		
		Vector2 asteroidPos = new Vector2();
		asteroidPos.x = randomRange + World.getRocket().getPosition().x;
		asteroidPos.y = randomRange + World.getRocket().getPosition().y;
		
		asteroid.setPosition(asteroidPos);
	}
	
	public Vector2 getPosition () {
		return asteroid.getPosition();
	}
	
	public float getSize () {
		return (float) randomSize;
	}
}
