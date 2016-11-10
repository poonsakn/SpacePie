package com.gdx.spacepie;

import java.util.ArrayList;
import java.util.List;

public class World {
	private static Rocket rocket;
	List <Asteroid> asteroids = new ArrayList <Asteroid> ();
	List <Point> points = new ArrayList <Point> ();
	int a = 0;
	int score = 0;
	World (SpacePie spacePie) {
		for (int i = 0 ; i < 10000 ; i++) {
			asteroids.add(new Asteroid());
		}
		
		for (int i = 0 ; i < 10000 ; i++) {
			points.add(new Point());
		}

		rocket = new Rocket(0,0,asteroids, points);
	}
	public static Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		int b = 0;
		rocket.update();
		b = rocket.checkPointCollision();
		a = rocket.checkAsteroidCollision();
		
		if (b != 0) {
			System.out.println(b);
			points.remove(b);
			b=0;
			score++;
		}
		if (a == 0) {
			rocket.updatePosition();
		}
		
		

	}
}
