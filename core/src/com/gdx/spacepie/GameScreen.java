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
	
	public GameScreen(SpacePie spacePie) {
		this.spacePie = spacePie;
		rocketImg = new Texture("rocket.png");
		bgImg = new Texture("bg.png");
		
		world = new World (spacePie);
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = spacePie.batch;
		batch.begin();
		Vector2 pos = world.getRocket().getPosition();
		batch.draw(bgImg, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	//	batch.draw(rocketImg, pos.x-100 , pos.y-100); //(100.100) center of rocketImg
		batch.draw(rocketImg, pos.x , pos.y
				,100,100 //origin x,y
				, 200, 200 //width, height
				, 1 , 1 //scale x,y
				, 20 //rotation
				, 0 , 0 //src x,y
				, 200, 200 //srcWidthe, height
				, false, false // flip x,y
				);
		batch.end();
	}
	
	private void update(float delta) {
	}
}
