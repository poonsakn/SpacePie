package com.gdx.spacepie;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	static Texture rocketImg;
	private SpriteBatch batch;
	private SpacePie spacePie;
	private World world;
	private Asteroid asteroid;
	private AsteroidRenderer asteroidRenderer;
	private TextureRegion rocketRegion;
	private float Width, Height, OriginX, OriginY;
	private int countTest = 0;
	
	public WorldRenderer (SpacePie spacePie, World world) {
		this.spacePie = spacePie;
		this.world = world;
		batch = spacePie.batch;
		
		rocketImg = new Texture("rocket.png");
		rocketRegion = new TextureRegion(rocketImg);
		Width = rocketImg.getWidth();
		Height = rocketImg.getHeight();
		OriginX = Width/2;
		OriginY = Height/2;
		
	}
	
	public void render (float delta) {
		for (int i = 0 ; i < 10 ; i++) {
			if (countTest == 10) {
				break;
			}
			asteroidRenderer = new AsteroidRenderer (this.spacePie.batch, this.world.asteroids.get(i));
			asteroidRenderer.renderAsteroid();
			countTest++;
			System.out.println(countTest);
		}
		SpriteBatch batch = spacePie.batch;
		batch.begin();
		Vector2 pos = world.getRocket().getPosition();
		batch.draw(rocketRegion, pos.x-(Width/2) , pos.y-(Height/2)
				, OriginX , OriginY //origin x,y
				, Width, Height //width, height
				, (float) 0.5 , (float) 0.5 //scale x,y
				, Rocket.rotation //rotation
				);
		batch.end();
	}
	
}
