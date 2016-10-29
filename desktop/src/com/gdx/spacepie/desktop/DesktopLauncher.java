package com.gdx.spacepie.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.spacepie.SpacePie;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SpacePie.screenWidth;
		config.height = SpacePie.screenHeight;
		new LwjglApplication(new SpacePie(), config);
	}
}
