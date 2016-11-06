package com.gdx.spacepie;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen extends ScreenAdapter {
	private SpacePie spacePie;
	static Texture bgImg, bgImg1, bgImg2, bgImg3, bgImg4;
	private int mapSize = 2;
	OrthographicCamera camera = new OrthographicCamera(SpacePie.screenWidth , SpacePie.screenHeight);
	World world;
	WorldRenderer worldRenderer;
	SpriteBatch batch;
	int gridXNumber;
	int gridYNumber;
	int gridX;
	int gridY;
	
	public GameScreen(SpacePie spacePie) {
		this.spacePie = spacePie;
		new Texture("rocket.png");
		bgImg = new Texture("bg2.png");
			
		world = new World (spacePie);
		worldRenderer = new WorldRenderer(spacePie, world, gridX, gridY);

	}

	@Override
	public void render(float delta) {
		boolean rocketBoosted = update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch = spacePie.batch;
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		renderBackground();
		batch.end();

		
		worldRenderer.render(delta, rocketBoosted);
	}
	
	private boolean update (float delta) {
		world.update(delta);
		updateRocketDirection();
		
		camera.position.x = world.getRocket().getPosition().x;
		camera.position.y = world.getRocket().getPosition().y;
		
		return updateRocketSpeed ();
	}
	
	public void renderBackground () {
		gridXNumber =(int) (Math.floor(world.getRocket().getPosition().x / bgImg.getWidth()));
		gridYNumber = (int) (Math.floor(world.getRocket().getPosition().y / bgImg.getHeight()));
		gridX = (int) (bgImg.getWidth() * gridXNumber);
		gridY = (int) (bgImg.getHeight() * gridYNumber);
		for (int i = -mapSize; i <= mapSize; i++) {
			for (int j = -mapSize; j <= mapSize; j++) {
				batch.draw(bgImg, (i*bgImg.getWidth()) + gridX, (j*bgImg.getHeight()) + gridY);
			}
		}
//		System.out.println("grid" + gridX + "." + gridY + "_____________" + gridXNumber + " " + gridYNumber);
	}
	private boolean updateRocketSpeed () {
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			Rocket.boostSpeed(true);
			return true;
		}
		else {
			Rocket.boostSpeed(false);
			return false;
		}
	}
	
	private void updateRocketDirection () {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			Rocket.updateRocketRotation(-1);
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			Rocket.updateRocketRotation(1);
		} 
	}	
}
