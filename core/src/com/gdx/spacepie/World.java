package com.gdx.spacepie;

public class World {
	private Rocket rocket;
	private SpacePie spacePie;
	
	World (SpacePie spacePie) {
		this.spacePie = spacePie;
		
		rocket = new Rocket(SpacePie.screenWidth/2 , SpacePie.screenHeight/2);
	}
	Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
				
	}
}
