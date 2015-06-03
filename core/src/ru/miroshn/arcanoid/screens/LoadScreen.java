package ru.miroshn.arcanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Res;

/**
 * Экран загрузки ресурсов <br/>
 *
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public class LoadScreen implements Screen{
    private Texture progressBarTexture, progressBarBaseTexture; // Текстура прогрессбара и его фона
    private SpriteBatch batch; // упаковщик спрайтов с помощью которого будет идти рисование

    /**
     * Метод отрабатывается когда экран активируется, в приложении он должен активироваться один раз, поэтому все
     * действия по инициализации проводятся тут.
     * <ul>
     *     <li>Создается упаковщик спрайтов</li>
     *     <li>Загружается изображение прогрессбара</li>
     *     <li>Асинхронно загружаются остальные ресурсы</li>
     * </ul>
     */
    @Override
    public void show() {
        batch = new SpriteBatch();

        AGAssetManager am = AGAssetManager.getInstance();
        am.load(Res.PROGRESS_BAR.getName(), Texture.class);
        am.load(Res.PROGRESS_BAR_BASE.getName(), Texture.class);
        am.finishLoading();

        progressBarTexture = am.get(Res.PROGRESS_BAR);
        progressBarBaseTexture = am.get(Res.PROGRESS_BAR_BASE);

        loadAssets();
    }

    /**
     * Добавление ресурсов на асинхронную загрузку
     */
    private void loadAssets() {
        AGAssetManager am = AGAssetManager.getInstance();
        am.load(Res.GRAPHIC_PACK.getName(), TextureAtlas.class);
    }

    /**
     * Отрисовка экрана
     * @param delta время в секундах прошедшее с последней отрисовки
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(progressBarBaseTexture, 10, Gdx.graphics.getHeight() / 2 - progressBarBaseTexture.getHeight() / 2,
                Gdx.graphics.getWidth() - 20, progressBarBaseTexture.getHeight());
        batch.draw(progressBarTexture, 10, Gdx.graphics.getHeight() / 2 - progressBarTexture.getHeight() / 2,
                (Gdx.graphics.getWidth() - 20) * AGAssetManager.getInstance().getProgress(), progressBarTexture.getHeight());
        batch.end();

        AGAssetManager.getInstance().update();
//        if (AGAssetManager.getInstance().update()) {
//        }
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
        batch.dispose();
    }
}
