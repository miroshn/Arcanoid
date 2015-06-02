package ru.miroshn.arcanoid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.miroshn.arcanoid.ArcanoidGame;
import ru.miroshn.arcanoid.helpers.Conf;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Conf.DISPLAY_WIDTH;
		config.height = Conf.DISPLAY_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new ArcanoidGame(), config);
	}
}
