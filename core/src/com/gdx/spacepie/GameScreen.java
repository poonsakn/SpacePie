package com.gdx.spacepie;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen extends ScreenAdapter {
	private SpacePie spacePie;
	private Texture bgImg;
	OrthographicCamera camera = new OrthographicCamera(SpacePie.screenWidth , SpacePie.screenHeight);
	World world;
	WorldRenderer worldRenderer;
	
	
	public GameScreen(SpacePie spacePie) {
		this.spacePie = spacePie;
		new Texture("rocket.png");
		bgImg = new Texture("bg.png");
		
		world = new World (spacePie);
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = spacePie.batch;

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		

		batch.begin();
		batch.draw(bgImg, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		worldRenderer = new WorldRenderer(spacePie, world);
		worldRenderer.render(delta);
	}
	
	private void update (float delta) {
		world.update(delta);
		updateRocketDirection();
		
		camera.position.x = world.getRocket().getPosition().x;
		camera.position.y = world.getRocket().getPosition().y;
	}
	
	private void updateRocketDirection () {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			Rocket.updateRocketRotation(-1);
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			Rocket.updateRocketRotation(1);
		}
	}
	
//	private void updateCamera () {
//		camera.translate(world.getRocket().getPosition());
//	}
	
	
}
