package ru.miroshn.arcanoid.helpers.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Conf;

/**
 * Различные заголовки используемые в игре <br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public class Title extends Actor {
    private final TextureRegion texture; // изображение заголовка

    public Title(Titles type) {
        texture = AGAssetManager.getInstance().get(type.getRes());
        setSize(texture.getRegionWidth(),texture.getRegionHeight());
        fitToScreen();
        setColor(Conf.DEF_COLOR);
    }

    /**
     * Отрисовка объекта <br/>
     * Идет игра с цветом упаковщика, иначе не работают действия с прозрачностью
     * @param batch упаковщик спрайтов через который идет отрисовка
     * @param parentAlpha прозрачность родителя
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color c = batch.getColor();
        batch.setColor(getColor());
        batch.draw(texture, getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
        batch.setColor(c);
    }

    /**
     * Установить размеры заголовка так чтоб он поместился на экран и занимал 3/5 места по ширене
     */
    private void fitToScreen() {
        float scale = Gdx.graphics.getWidth() * 3.0f / 5.0f / getWidth();
        setSize(getWidth() * scale,getHeight() * scale);
    }
}
