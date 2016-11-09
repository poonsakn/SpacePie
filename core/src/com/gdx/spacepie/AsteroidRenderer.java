package com.gdx.spacepie;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AsteroidRenderer {
	private Texture asteroidImg = new Texture("asteroid.png");
	private TextureRegion asteroidRegion = new TextureRegion(asteroidImg);
	private SpriteBatch batch;
	private List<Asteroid> asteroids;
	private float Width;
	private float Height;
	private float OriginX;
	private float OriginY;

	public AsteroidRenderer(SpriteBatch batch, List<Asteroid> asteroid) {
		this.batch = batch;
		this.asteroids = asteroid;
	}
	
	public void renderAsteroid () {
		batch.begin();
		for (Asteroid asteroid : this.asteroids) {

			Width = asteroid.getSize();
			Height = asteroid.getSize();
			OriginX = Width/2;
			OriginY = Height/2;
//			batch.draw(asteroidImg, asteroid.getPosition().x, asteroid.getPosition().y, asteroid.getSize(), asteroid.getSize());
			batch.draw(asteroidRegion, asteroid.getPosition().x-Width/2, asteroid.getPosition().y-Height/2
					, OriginX , OriginY //origin x,y
					, Width, Height //width, height
					, (float) 1 , (float) 1 //scale x,y
					, 0 //rotation
					);
		}
		batch.end();
		}
}
