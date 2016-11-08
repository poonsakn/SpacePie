package com.gdx.spacepie;

import java.util.ArrayList;
import java.util.List;

public class World {
	private static Rocket rocket;
	List <Asteroid> asteroids = new ArrayList<Asteroid>();
	int a = 0;
	World (SpacePie spacePie) {
		System.out.println("world");
//		asteroid = new Asteroid();
		for (int i = 0 ; i < 10000 ; i++) {
			asteroids.add(new Asteroid());
		}
		rocket = new Rocket(0,0,asteroids);

	}
	public static Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		rocket.update();
		a = rocket.checkCollision();
		if (a != 0) {
			System.out.println(a);
			asteroids.remove(a);
		}
	}
}
