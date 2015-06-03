package ru.miroshn.arcanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import ru.miroshn.arcanoid.gameobjects.Background;
import ru.miroshn.arcanoid.helpers.CustomScreen;
import ru.miroshn.arcanoid.helpers.ScreenManager;
import ru.miroshn.arcanoid.helpers.ui.Title;
import ru.miroshn.arcanoid.helpers.ui.Titles;

/**
 * Экран приветствия с названием игры <br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public class WelcomeScreen implements Screen {
    private static final float FADE_TIME = 0.5f;
    private final Title title; // изображение названия игры
    private final Stage stage;

    /**
     * Инициализируется экран <br/>
     * Добавляется звголовок в центр экрана, заголовок полностью прозрачен и плавно появляется
     */
    public WelcomeScreen() {
        title = new Title(Titles.WELCOME_TITLE);
        title.setPosition((Gdx.graphics.getWidth() - title.getWidth())/2.0f
                ,(Gdx.graphics.getHeight() - title.getHeight()/2.0f)/2.0f);
        title.getColor().a = 0;
        title.addAction(Actions.fadeIn(FADE_TIME));
        stage = new Stage();
        stage.addActor(new Background());
        stage.addActor(title);
        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                title.addAction(Actions.fadeOut(FADE_TIME));
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        if (title.getColor().a == 0 && title.getActions().size == 0) {
            Gdx.input.setInputProcessor(null);
            ScreenManager.getInstance().show(CustomScreen.GAME_SCREEN);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
