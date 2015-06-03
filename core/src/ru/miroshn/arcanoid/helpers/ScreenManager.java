package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.IntMap;
import ru.miroshn.arcanoid.ArcanoidGame;

/**
 * Менеджер экранов <br/>
 * Создает экраны по мере необходимости и хранит их для повторного использования <br/>
 * Сделан в виде синглтона <br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public class ScreenManager implements Disposable {
    private static ScreenManager instance; // Экземпляр класса
    private final IntMap<Screen> screens; // Хранилище экранов

    private ScreenManager() {
        screens = new IntMap<>();
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    /**
     * Установить текущим экран screen
     * @param screen Экран для отображения
     */
    public void show(CustomScreen screen) {
        if (Gdx.app.getApplicationListener() == null) return;
        if (!screens.containsKey(screen.ordinal())) { // проверка, создавался ли уже такой экран
            screens.put(screen.ordinal(),screen.getScreenInstance()); // создается экран и помещается в хранилище
        }
        ((ArcanoidGame)Gdx.app.getApplicationListener()).setScreen(screens.get(screen.ordinal())); // устанавливается текущим экраном
    }

    /**
     * Уничтожение всех экранов в хранилище и самого хранилища
     */
    @Override
    public void dispose() {
        for (Screen screen : screens.values()) {
            screen.dispose();
        }
        screens.clear();
        instance = null;
    }
}
