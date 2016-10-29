package com.gdx.spacepie;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
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
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = spacePie.batch;
		batch.begin();
		batch.draw(rocketImg, SpacePie.screenWidth/2 , SpacePie.screenHeight/2);
		batch.end();
	}
}
