package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.Screen;
import ru.miroshn.arcanoid.screens.GameScreen;
import ru.miroshn.arcanoid.screens.LoadScreen;
import ru.miroshn.arcanoid.screens.WelcomeScreen;

/**
 * Перечисление возможных экранов <br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public enum CustomScreen {
    /** Игровой экран */
    GAME_SCREEN {
        @Override
        protected Screen getScreenInstance() {
            return new GameScreen();
        }
    },
    /** Экран приветствия с названием игры */
    WELCOME_SCREEN {
        @Override
        protected Screen getScreenInstance() {
            return new WelcomeScreen();
        }
    },
    /** Экран загрузки ресурсов */
    LOAD_SCREEN {
        @Override
        protected Screen getScreenInstance() {
            return new LoadScreen();
        }
    };
    protected abstract Screen getScreenInstance();
}
