package ru.miroshn.arcanoid.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.miroshn.arcanoid.helpers.Conf;

/**
 * <br/>Created by miroshn on 04.06.15.
 */
public class GameObjects extends Actor {
    private TextureRegion texture;

    public GameObjects(TextureRegion texture) {
        this.texture = texture;
        setBounds(0,0,texture.getRegionWidth(),texture.getRegionHeight());
        setColor(Conf.DEF_COLOR);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Color c = batch.getColor();
        batch.setColor(getColor());
        batch.draw(texture,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
        batch.setColor(c);
    }

    protected TextureRegion getTexture() {
        return texture;
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        super.drawDebug(shapes);
        Color c = shapes.getColor();
        shapes.setColor(Color.RED);
        shapes.circle(getOriginX() + getX(), getOriginY() + getY(), 5);
        shapes.x(getX(),getY(),5);
        shapes.setColor(c);
    }
}
