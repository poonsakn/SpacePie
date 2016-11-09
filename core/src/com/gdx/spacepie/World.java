package com.gdx.spacepie;

import java.util.ArrayList;
import java.util.List;

public class World {
	private static Rocket rocket;
	List <Asteroid> asteroids = new ArrayList <Asteroid> ();
	List <Point> points = new ArrayList <Point> ();
	int b = 0;
	World (SpacePie spacePie) {
		System.out.println("world");

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
		rocket.update();
		b = rocket.checkPointCollision();
		if (b != 0) {
			System.out.println(b);
			points.remove(b);
		}
	}
}
