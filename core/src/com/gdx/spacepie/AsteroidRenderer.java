package com.gdx.spacepie;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AsteroidRenderer {
	private Texture asteroidImg = new Texture("asteroid.png");
	private SpriteBatch batch;
	private Asteroid asteroid;
	
	public AsteroidRenderer(SpriteBatch batch, Asteroid asteroid) {
		this.batch = batch;
		this.asteroid = asteroid;
	}
	
	public void render () {
		batch.begin();
		System.out.println(asteroid.getPosition().x);
		batch.draw(asteroidImg, asteroid.getPosition().x, asteroid.getPosition().y, asteroid.getSize(), asteroid.getSize());
		batch.end();
	}
}
