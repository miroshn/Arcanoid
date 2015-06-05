package ru.miroshn.arcanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import ru.miroshn.arcanoid.gameobjects.Background;
import ru.miroshn.arcanoid.gameobjects.Ball;
import ru.miroshn.arcanoid.gameobjects.Rocket;
import ru.miroshn.arcanoid.helpers.Conf;

/**
 * Основной игровой экран
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public class GameScreen implements Screen {
    private final Stage stage;

    public GameScreen() {
        stage = new Stage();
        stage.setDebugAll(Conf.GRAPHICS_DEBUG);
        stage.addActor(new Background());
        Rocket r = new Rocket();
        r.setPosition(Gdx.graphics.getWidth() / 2.0f - r.getOriginX(),-r.getHeight());
        r.addAction(Actions.moveTo(Gdx.graphics.getWidth() / 2.0f - r.getOriginX()
                , Conf.BOTTOM_BORDER * Gdx.graphics.getHeight() / 100.f - r.getHeight(), 0.2f));
        stage.addActor(r);

        Ball b = new Ball();
        b.setPosition(Gdx.graphics.getWidth() / 2.0f - b.getOriginX(), Conf.BOTTOM_BORDER * Gdx.graphics.getHeight() / 100.f);
        stage.addActor(b);
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
        stage.dispose();
    }
}
