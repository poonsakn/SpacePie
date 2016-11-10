package com.gdx.spacepie;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	private PointRenderer pointRenderer;
	private float Width;
	private float Height;
	private float OriginX;
	private float OriginY;
	BitmapFont font;
	
	public WorldRenderer (SpacePie spacePie, World world, int gridX, int gridY) {
		this.spacePie = spacePie;
		this.world = world;
		batch = spacePie.batch;
		font = new BitmapFont();
		rocketImg = new Texture("rocket.png");
		rocketBoostedImg = new Texture("rocket2.png");
		rocketRegion = new TextureRegion(rocketImg);
		rocketBoostedRegion = new TextureRegion(rocketBoostedImg);

		Width = rocketImg.getWidth();
		Height = rocketImg.getHeight();
		OriginX = Width/2;
		OriginY = Height/3;
		asteroidRenderer = new AsteroidRenderer (this.spacePie.batch, this.world.asteroids);
		pointRenderer = new PointRenderer (this.spacePie.batch, this.world.points);

	}
	
	public void render (float delta, boolean rocketBoosted) {
		
		asteroidRenderer.renderAsteroid();
		pointRenderer.renderPoint();
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
		font.draw(batch, "   " + pos.x + "   " + pos.y , pos.x, pos.y);

		batch.end();
	}
}
