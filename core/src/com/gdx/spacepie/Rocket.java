package com.gdx.spacepie;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	private static float originalRocketSpeed = 7;
	private static float startingRocketSpeed = 0;
	private static float originalRotationSpeed = 5;
	private static float rocketSpeed = originalRocketSpeed;
	private static float rotationSpeed = originalRotationSpeed;
	public static int rotation = 0;
	public static double rotationRadian = Math.toRadians(rotation);
	private List<Asteroid> asteroids;
	private List<Point> points;

	Texture rocket = new Texture("rocket.png");
	int a = 0;
	int b = 0;
	
	ShapeRenderer shape = new ShapeRenderer ();

	public Rocket(int x, int y, List<Asteroid> asteroids, List<Point> point) {
		position = new Vector2(x,y);
		this.asteroids = asteroids;
		this.points = point;
	
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void update() {
//		System.out.println(rotation + " ===== " + (int) position.x + "." + (int) position.y);
		rotation %= 360;
	}
	
	public void updatePosition() {
		if (startingRocketSpeed < originalRocketSpeed) {
			rocketSpeed = startingRocketSpeed;
			startingRocketSpeed += 0.15;
		}
		position.x += rocketSpeed * Math.sin(-rotationRadian) ;
		position.y += rocketSpeed * Math.cos(-rotationRadian) ;
	}
	
	public int checkAsteroidCollision () {
		for (Asteroid asteroid : this.asteroids) {
			if ((Math.abs(asteroid.getPosition().x-position.x) <= asteroid.getSize())&&(Math.abs(asteroid.getPosition().y-position.y) <= asteroid.getSize())) {
				System.out.println(asteroid.getPosition().x + "    " + position.x + "    " + asteroid.getSize());
				System.out.println(asteroid.getPosition().y + "    " + position.y + "\n");
				rocketSpeed = 0;
				return b;
			}
			b++;
		}
		b=0;
		updatePosition();
		return 0;
	}
	
	public int checkPointCollision () {
		for (Point point : this.points) {
			if ((Math.abs(point.getPosition().x-position.x) <= point.getSize())&&(Math.abs(point.getPosition().y-position.y) <= point.getSize())) {
				
				rocketSpeed = 0;
				return a;
			}
			a++;
		}
		a=0;
		updatePosition();
		return 0;
	}
	
	public static void boostSpeed (boolean keyPressed) {
		if (keyPressed == true) {
			rocketSpeed = (float) (rocketSpeed*1.01);
			rotationSpeed = (float) (originalRotationSpeed/originalRotationSpeed); 
		} else if (keyPressed == false) {
			rocketSpeed = originalRocketSpeed;
			rotationSpeed = originalRotationSpeed;
		}
	}
	
	public static void updateRocketRotation(int key) {
		if (key == -1) {
			rotation += rotationSpeed;
		} else if (key == 1) {
			rotation -= rotationSpeed;
		}
		
		rotationRadian = Math.toRadians(rotation);
	}
}