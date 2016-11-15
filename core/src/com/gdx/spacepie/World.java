package com.gdx.spacepie;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.ChoiceCallback;

public class World {
	private static Rocket rocket;
	int a = 0;
	int score = 0;
	int highScore = 0;
	static List <Asteroid> asteroids = new ArrayList <Asteroid> ();
	static List <Point> points = new ArrayList <Point> ();
	
	World (SpacePie spacePie) {
		init(spacePie);
	}
	public void init(SpacePie spacePie) {
		score = 0;
		asteroids = new ArrayList <Asteroid> ();
		points = new ArrayList <Point> ();
		
		for (int i = 0 ; i < 20000 ; i++) {
			asteroids.add(new Asteroid());
		}
		
		for (int i = 0 ; i < 10000 ; i++) {
			points.add(new Point());
		}
		rocket = new Rocket(0,0,asteroids, points);
	}
	
	public static Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		int b = 0;
		rocket.updateDirection();
		b = rocket.checkPointCollision();
		a = rocket.checkAsteroidCollision();
		
		if (b != 0) {
			System.out.println(b);
			points.remove(b);
			b=0;
			score++;
			if (score > highScore) {
				highScore = score;
			}
		}
		if (a == 0) {
			rocket.updatePosition();
		}
	}
}