package com.gdx.spacepie;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	private SpacePie spacePie;
	
	public GameScreen(SpacePie spacePie) {
		this.spacePie = spacePie;
	}

	@Override
	public void render(float delta) {
		System.out.println("Hello " + delta);
	}
}
