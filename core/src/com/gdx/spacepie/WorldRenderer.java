package com.gdx.spacepie;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private SpacePie spacePie;
	private World world;
	private Texture rocketImg;
	private TextureRegion rocketRegion;
	private float Width, Height, OriginX, OriginY, rotation;
	private SpriteBatch batch;

	public WorldRenderer (SpacePie spacePie, World world) {
		this.spacePie = spacePie;
		batch = spacePie.batch;
		
		this.world = world;
		
		rocketImg = new Texture("rocket.png");
		rocketRegion = new TextureRegion(rocketImg);
		Width = rocketImg.getWidth();
		Height = rocketImg.getHeight();
		OriginX = Width/2;
		OriginY = Height/2;
	}
	
	public void render (float delta) {
		SpriteBatch batch = spacePie.batch;
		batch.begin();
		Vector2 pos = world.getRocket().getPosition();
	//	batch.draw(rocketImg, pos.x-100 , pos.y-100); //(100.100) center of rocketImg
		batch.draw(rocketRegion, pos.x-(Width/2) , pos.y-(Height/2)
				, OriginX , OriginY //origin x,y
				, Width, Height //width, height
				, 1 , 1 //scale x,y
				, 0 //rotation
//				, 0 , 0 //src x,y
//				, 200, 200 //srcWidthe, height
//				, false, false // flip x,y
				);
		batch.end();
	}
}
