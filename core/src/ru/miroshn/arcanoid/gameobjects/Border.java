package ru.miroshn.arcanoid.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Conf;
import ru.miroshn.arcanoid.helpers.Res;

/**
 * Класс реализующий бордюр вокруг игрового поля
 * <br/>Created by miroshn on 30.07.15.
 */
public class Border extends GameObjects {

    public Border() {
        super((TextureRegion) AGAssetManager.getInstance().get(Res.BORDER_PART));
        float scale =  Gdx.graphics.getWidth() * Conf.BORDER_WIDTH / 100.0f / getTexture().getRegionWidth();
        setBounds(0, 0, getTexture().getRegionWidth() * scale, getTexture().getRegionHeight() * scale);
        //setOrigin(getWidth() / 2.0f, getHeight() / 2.0f);
        setColor(Conf.DEF_COLOR);
    }


    /** Отрисовка бордюра используя одну часть текстуры.*/
    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color c = batch.getColor();
        batch.setColor(getColor());
        // размеры экрана
        int disW = Gdx.graphics.getWidth(), disH = Gdx.graphics.getHeight();
        // левая стена
        for (int y = 0; y < disH; y += getHeight()) {
            batch.draw(getTexture(),getX(),getY()+y,getOriginX(),getOriginY()
                    ,getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
        }
        // правая сторона
        getTexture().flip(true,false);
        for (int y = 0; y < disH; y += getHeight()) {
            batch.draw(getTexture(),disW - getWidth(),getY()+y,getOriginX(),getOriginY()
                    ,getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
        }
        getTexture().flip(true,false);
        // верх
        for (int x = 0; x < disW; x += getHeight()) {
            batch.draw(getTexture(),x,disH,0,0
                    ,getWidth(),getHeight(),getScaleX(),getScaleY(),-90);
        }
        batch.setColor(c);
    }
}
