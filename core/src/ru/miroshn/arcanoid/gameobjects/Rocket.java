package ru.miroshn.arcanoid.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.miroshn.arcanoid.helpers.AGAssetManager;
import ru.miroshn.arcanoid.helpers.Conf;
import ru.miroshn.arcanoid.helpers.Res;

/**
 * Управляемая игроком ракетка
 * <br/>Created by miroshn on 04.06.15.
 * @author miroshn
 */
public class Rocket extends Actor {
    private TextureRegion texture;

    public Rocket() {
        texture = AGAssetManager.getInstance().get(Res.ROCKET);
        // 1/10 от экрана
        float scale =  Gdx.graphics.getWidth() *15.f / 100.0f / texture.getRegionWidth();
        Gdx.app.log(getClass().getSimpleName(),"scale = " + scale);
        setBounds(0,0,texture.getRegionWidth() * scale,texture.getRegionHeight() * scale);
        setOrigin(getWidth()/2.0f,getHeight()/2.0f);
        setColor(Conf.DEF_COLOR);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color c = batch.getColor();
        batch.setColor(getColor());
        batch.draw(texture,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
        batch.setColor(c);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        super.drawDebug(shapes);
        Color c = shapes.getColor();
        shapes.setColor(Color.RED);
        shapes.circle(getOriginX() + getX(),getOriginY() + getY(),5);
        shapes.x(getX(),getY(),5);
        shapes.setColor(Color.BLACK);
        shapes.x(Gdx.graphics.getWidth() / 2.0f,100.0f,5);
        shapes.setColor(c);
    }
}

