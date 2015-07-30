package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.lang.reflect.Type;

/**
 * Тут собраны все имена файлов и ресурсов и превращены в валидируемый enum
 * <p>
 *    Сделано так что каждый элемент перечисления обязан иметь в себе имя ресурса, для централизованного хранения имен
 *    ресурсов, и класс ресурса.
 * </p>
 * Created by miroshn on 02.06.15.
 */
public enum Res {
    //// Ресурсы в альбоме
    /** альбом графических ресурсов*/
    GRAPHIC_PACK("arcanoid.pack",Types.TEXTURE_REGION),
    /** Часть бордюра */
    BORDER_PART("border", Types.TEXTURE_REGION),
    /** Мячик */
    BALL("ball",Types.TEXTURE_REGION),
    /** заголовок игры */
    WELCOME_TITLE("welcome_title",Types.TEXTURE_REGION),
    /** фон игры */
    BACKGROUND("background",Types.TEXTURE_REGION),
    /** ракетка */
    ROCKET("rocket",Types.TEXTURE_REGION),
    /** пустой блок */
    BRICK_EMPTY("empty_brick",Types.TEXTURE_REGION),
    /** заштрихованный блок */
    BRICK_HALF_HATCH("half_hatch_brick",Types.TEXTURE_REGION),
    /** заштрихованный на половину блок */
    BRICK_HATCH("half_hatch_brick",Types.TEXTURE_REGION),

    //// Ресурсы лежат отдельно
    /** фон прогрессбара */
    PROGRESS_BAR_BASE("progress_bar_base.png",Types.TEXTURE),
    /** индикатор прогрессбараа */
    PROGRESS_BAR("progress_bar.png",Types.TEXTURE);

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
