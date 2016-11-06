package com.gdx.spacepie;

import java.util.ArrayList;
import java.util.List;

public class World {
	private static Rocket rocket;
	List <Asteroid> asteroids = new ArrayList<Asteroid>();

	World (SpacePie spacePie) {
		rocket = new Rocket(0,0);
		System.out.println("world");
//		asteroid = new Asteroid();
		for (int i = 0 ; i < 10000 ; i++) {
			asteroids.add(new Asteroid());
		}
	}
	public static Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		rocket.update();
		rocket.updatePosition();
	}
}
