package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Менеджер ресурсов в виде синглтона
 * Created by miroshn on 02.06.15.
 */
public class AGAssetManager extends AssetManager{
    public static AGAssetManager instance; // экземпляр класса

    /**
     * Приватный конструктор, блокирует прямое создание объектов этого типа
     */
    private AGAssetManager() {
        super();
    }

    /**
     * Получение экземпляра класса
     * @return экземпляр AGAssetManager
     */
    public static AGAssetManager getInstance() {
        if (instance == null) {
            instance = new AGAssetManager();
        }
        return instance;
    }

    /**
     * Уничтожение объекта
     */
    @Override
    public synchronized void dispose() {
        super.dispose();
        instance = null;
    }

    /**
     * Получение ресурсов
     * @param value тип ресурса
     * @param <T> тип запрашиваемого ресурса
     * @return возвращает ресурс
     */
    @SuppressWarnings("unchecked")
    public <T> T get(Res value) {
        T obj = null;
        switch (value.getType()) {
            case TEXTURE:
                //noinspection unchecked
                obj = (T) get(value.getName(), Texture.class);
                break;
            case TEXTURE_REGION:
                obj = (T) get(Res.GRAPHIC_PACK.getName(), TextureAtlas.class).findRegion(value.getName());
                break;
            case BITMAP_FONT:
//                if (Gdx.graphics.getDensity() > 1)
//                    obj = (T) get(Res.FONT.getName(), BitmapFont.class);
//                else
//                    obj = (T) get(Res.FONT_16.getName(), BitmapFont.class);
//                break;
            case SOUND:
                obj = (T) get(value.getName(), Sound.class);
                break;
        }
        return obj;
    }
}
