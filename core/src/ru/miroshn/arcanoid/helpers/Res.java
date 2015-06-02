package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Тут собраны все имена файлов и ресурсов и превращены в валидируемый enum
 * <p>
 *    Сделано так что каждый элемент перечисления обязан иметь в себе имя ресурса, для централизованного хранения имен
 *    ресурсов, и класс ресурса.
 * </p>
 * Created by miroshn on 02.06.15.
 */
public enum Res {
    /** фон игры */
    BACKGROUND("fon.jpg",Types.TEXTURE),
    /** альбом графических ресурсов*/
    GRAPHIC_PACK("",Types.TEXTURE_REGION);

    /** Имя файла или ресурса */
    private final String name;
    /** Тип ресурса */
    private final Types type;

    /**
     * @return Имя ресурса (наименование файла или внутреннее имя)
     */
    public String getName() {
        return name;
    }

    /**
     * @return тип ресурса (его класс)
     */
    public Types getType() {
        return type;
    }

    Res(String name,Types type) {
        this.name = name;
        this.type = type;
    }


    /**
     * Типы ресурсов
     */
    public enum Types {
        SOUND(Sound.class),
        TEXTURE(Texture.class),
        TEXTURE_REGION(TextureRegion.class),
        BITMAP_FONT(BitmapFont.class);


        private final Class type;

        Types(Class type) {
            this.type = type;
        }

        public Class getType() {
            return type;
        }
    }
}
