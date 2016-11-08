package com.gdx.spacepie;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AsteroidRenderer {
	private Texture asteroidImg = new Texture("asteroid.png");
	private SpriteBatch batch;
	private List<Asteroid> asteroids;

	public AsteroidRenderer(SpriteBatch batch, List<Asteroid> asteroid) {
		this.batch = batch;
		this.asteroids = asteroid;
	}
	
	public void renderAsteroid () {
		batch.begin();
		for (Asteroid asteroid : this.asteroids) {	
			batch.draw(asteroidImg, asteroid.getPosition().x, asteroid.getPosition().y, asteroid.getSize(), asteroid.getSize());
		}
		batch.end();
		}
}
