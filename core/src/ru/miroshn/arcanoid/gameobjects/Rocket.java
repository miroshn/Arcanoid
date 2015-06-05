package ru.miroshn.arcanoid.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Conf;
import ru.miroshn.arcanoid.helpers.Res;

/**
 * Управляемая игроком ракетка
 * <br/>Created by miroshn on 04.06.15.
 * @author miroshn
 */
public class Rocket extends GameObjects {
    public Rocket() {
        super((TextureRegion)AGAssetManager.getInstance().get(Res.ROCKET));
        // 1/10 от экрана
        float scale =  Gdx.graphics.getWidth() *30.f / 100.0f / getTexture().getRegionWidth();
        setBounds(0,0,getTexture().getRegionWidth() * scale,getTexture().getRegionHeight() * scale);
        setOrigin(getWidth()/2.0f,getHeight()/2.0f);
        setColor(Conf.DEF_COLOR);
    }
}

