package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.Screen;
import ru.miroshn.arcanoid.screens.LoadScreen;

/**
 * Перечисление возможных экранов <br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public enum CustomScreen {
    /** Экран загрузки ресурсов */
    LOAD_SCREEN {
        @Override
        protected Screen getScreenInstance() {
            return new LoadScreen();
        }
    };
    protected abstract Screen getScreenInstance();
}
