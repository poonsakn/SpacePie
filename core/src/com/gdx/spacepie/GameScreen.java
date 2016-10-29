package com.gdx.spacepie;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private SpacePie spacePie;
	private Texture rocketImg;
	
	public GameScreen(SpacePie spacePie) {
		this.spacePie = spacePie;
		rocketImg = new Texture("rocket.png");
	}

	@Override
	public void render(float delta) {
		SpriteBatch batch = spacePie.batch;
		batch.begin();
		batch.draw(rocketImg, 100, 100);
		batch.end();
	}
}
