package ru.miroshn.arcanoid.helpers;

import com.badlogic.gdx.graphics.Color;

/**
 * Класс общих настроек
 * Created by miroshn on 02.06.15.
 */
public class Conf {
    /** Ширина Экрана/Окна*/
    public static final int DISPLAY_WIDTH = 320*2;
    /** Высота Экрана/Окна*/
    public static final int DISPLAY_HEIGHT = 850;
    /** Графическая отладочная информация */
    public static final boolean GRAPHICS_DEBUG = false;
    /** Цвет по умолчанию */
    public static final Color DEF_COLOR = new Color(0,8.0f/255.0f,161.0f/255.0f,1);
    /** отступ от нижней границы экрана в процентах */
    public static final float BOTTOM_BORDER = 20;
}
