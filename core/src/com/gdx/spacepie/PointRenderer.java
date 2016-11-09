package com.gdx.spacepie;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PointRenderer {
	private Texture pointImg = new Texture("point.png");
	private TextureRegion pointRegion = new TextureRegion(pointImg);
	private SpriteBatch batch;
	private List<Point> points;
	private float Width;
	private float Height;

	public PointRenderer(SpriteBatch batch, List<Point> point) {
		this.batch = batch;
		this.points = point;
	}
	
	public void renderPoint () {
		batch.begin();
		for (Point point : this.points) {

			Width = point.getSize();
			Height = point.getSize();
//			batch.draw(pointImg, point.getPosition().x, point.getPosition().y, point.getSize(), point.getSize());
			batch.draw(pointRegion, point.getPosition().x-Width/2, point.getPosition().y-Height/2
					, 0 , 0 //origin x,y
					, Width, Height //width, height
					, (float) 1 , (float) 1 //scale x,y
					, 0 //rotation
					);
		}
		batch.end();
		}
}
