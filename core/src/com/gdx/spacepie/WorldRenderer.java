package com.gdx.spacepie;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	static Texture rocketImg;
	static Texture rocketBoostedImg;
	private TextureRegion rocketRegion;
	private TextureRegion rocketBoostedRegion;
	private SpriteBatch batch;
	private SpacePie spacePie;
	private World world;
	private AsteroidRenderer asteroidRenderer;
	private float Width, Height, OriginX, OriginY;
	
	
	public WorldRenderer (SpacePie spacePie, World world, int gridX, int gridY) {
		this.spacePie = spacePie;
		this.world = world;
		batch = spacePie.batch;
		
		rocketImg = new Texture("rocket.png");
		rocketBoostedImg = new Texture("rocket2.png");
		rocketRegion = new TextureRegion(rocketImg);
		rocketBoostedRegion = new TextureRegion(rocketBoostedImg);

		Width = rocketImg.getWidth();
		Height = rocketImg.getHeight();
		OriginX = Width/2;
		OriginY = Height/3;
		asteroidRenderer = new AsteroidRenderer (this.spacePie.batch, this.world.asteroids);

	}
	
	public void render (float delta, boolean rocketBoosted) {
		
		asteroidRenderer.renderAsteroid();		
		renderRocket(rocketBoosted);
	}
	public void renderRocket (boolean rocketBoosted) {
		batch.begin();
		Vector2 pos = World.getRocket().getPosition();
		if (rocketBoosted) {
			batch.draw(rocketBoostedRegion, pos.x-(Width/2) , pos.y-(Height/2)
					, OriginX , OriginY //origin x,y
					, Width, Height //width, height
					, (float) 0.5 , (float) 0.5 //scale x,y
					, Rocket.rotation //rotation
					);
		}  else {
			batch.draw(rocketRegion, pos.x-(Width/2) , pos.y-(Height/2)
					, OriginX , OriginY //origin x,y
					, Width, Height //width, height
					, (float) 0.5 , (float) 0.5 //scale x,y
					, Rocket.rotation //rotation
					);
		}
		batch.end();
	}
}
