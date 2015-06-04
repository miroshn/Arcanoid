package ru.miroshn.arcanoid.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Res;

/**
 * Фон игры <br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public class Background extends Actor {
    private TextureRegion region;

    public Background() {
        region = AGAssetManager.getInstance().get(Res.BACKGROUND);
        setSize(region.getRegionWidth(),region.getRegionHeight());
        if (Gdx.graphics.getDensity() > 1)
            setScale(Gdx.graphics.getDensity());
    }

    /**
     * Отрисовка фона, который застилает черепицей текстуру на экране
     * @param batch упаковщик спрайтов с помошью которого рисуется объект
     * @param parentAlpha прозрачность - не используется
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int x = 0; x < Gdx.graphics.getWidth(); x += region.getRegionWidth()) {
            for (int y = 0; y < Gdx.graphics.getHeight() * 2; y += region.getRegionHeight()) {
                batch.draw(region, x, y, getWidth(), getHeight(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            }
        }
    }

    /**
     *  Заглушка, созданная для того чтоб не отрисовывалась отладочная графика для фона
     * @param shapes Рендерер с помошью которого рисуются линии отладочной графики
     */
    @Override
    public void drawDebug(ShapeRenderer shapes) {
    }
}
