package com.gdx.spacepie;

public class World {
	private Rocket rocket;
	private Asteroid asteroid;
	
	World (SpacePie spacePie) {
		rocket = new Rocket(0,0);
	}
	Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		rocket.update();
		rocket.updatePosition();
	}
}
