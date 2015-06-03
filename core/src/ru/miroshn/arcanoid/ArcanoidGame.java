package ru.miroshn.arcanoid;

import com.badlogic.gdx.Game;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.CustomScreen;
import ru.miroshn.arcanoid.helpers.ScreenManager;

/**
 * Основной класс игры, при создании передает управление экрану загрузки ресурсов
 * @author miroshn
 */
public class ArcanoidGame extends Game {

	@Override
	public void create () {
		ScreenManager.getInstance().show(CustomScreen.LOAD_SCREEN);
	}

	@Override
	public void dispose() {
		ScreenManager.getInstance().dispose();
		AGAssetManager.getInstance().dispose();
	}
}
