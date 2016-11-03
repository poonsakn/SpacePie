package com.gdx.spacepie;

public class World {
	private static Rocket rocket;
	Asteroid asteroid;
	
	World (SpacePie spacePie) {
		rocket = new Rocket(0,0);
		asteroid = new Asteroid();
	}
	public static Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		rocket.update();
		rocket.updatePosition();
	}
}
