package ru.miroshn.arcanoid.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Conf;
import ru.miroshn.arcanoid.helpers.Res;

/**
 * Мячик
 * <br/>Created by miroshn on 04.06.15.
 * @author miroshn
 */
public class Ball extends GameObjects {

    public Ball() {
        super((TextureRegion) AGAssetManager.getInstance().get(Res.BALL));
        float scale =  Gdx.graphics.getWidth() *4.f / 100.0f / getTexture().getRegionWidth();
        setBounds(0, 0, getTexture().getRegionWidth() * scale, getTexture().getRegionHeight() * scale);
        setColor(Conf.DEF_COLOR);
    }

}
