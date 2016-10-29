package com.gdx.spacepie;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private SpacePie spacePie;
	private Texture rocketImg;
	private Rocket rocket;
	private Texture bgImg;
	World world;
	WorldRenderer worldRenderer;
	
	public GameScreen(SpacePie spacePie) {
		this.spacePie = spacePie;
		rocketImg = new Texture("rocket.png");
		bgImg = new Texture("bg.png");
		
		world = new World (spacePie);
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = spacePie.batch;
		batch.begin();
		batch.draw(bgImg, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		worldRenderer = new WorldRenderer(spacePie, world);
		worldRenderer.render(delta);
	}
	
	
}
