package com.gdx.spacepie;

public class World {
	private Rocket rocket;
	World (SpacePie spacePie) {
		rocket = new Rocket(SpacePie.screenWidth/2 , SpacePie.screenHeight/2);
	}
	Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		rocket.update();
		rocket.updatePosition();
	}
}
